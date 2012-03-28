/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.build.enunciate.rs;

import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.*;
import com.sun.mirror.type.*;
import com.sun.mirror.util.Declarations;
import net.sf.jelly.apt.Context;
import net.sf.jelly.apt.decorations.declaration.DecoratedDeclaration;
import net.sf.jelly.apt.decorations.declaration.DecoratedMethodDeclaration;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.LocalElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.TypeDefinition;
import org.codehaus.enunciate.contract.jaxrs.Resource;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.codehaus.enunciate.contract.jaxrs.RootResource;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.codehaus.enunciate.util.ResourceMethodPathComparator;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.rs.*;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Basic processor for validating integration the model with RDF.
 *
 * @author Ryan Heaton
 */
public class ResourceServiceProcessor {

  private final Map<QName, ResourceDefinitionDeclaration> resourceDefinitions = new HashMap<QName, ResourceDefinitionDeclaration>();
  private Map<String, ResourceBinding> bindingsByPath;

  /**
   * @see <a href="http://tools.ietf.org/html/draft-nottingham-http-link-header">Web Linking</a>
   */
  private static final Set<String> REGISTERED_LINK_RELATIONS = new TreeSet<String>(Arrays.asList("alternate", "appendix", "bookmark", "chapter", "contents", "copyright", "current", "describedby", "edit", "edit-media", "enclosure", "first", "glossary", "help", "hub", "index", "last", "latest-version", "license", "next", "next-archive", "payment", "prev", "predecessor-version", "previous", "prev-archive", "related", "replies", "section", "self", "service", "start", "stylesheet", "subsection", "successor-version", "up", "version-history", "via", "working-copy", "working-copy-of"));

  public Collection<ResourceDefinitionDeclaration> getResourceDefinitions() {
    return resourceDefinitions.values();
  }

  public Map<String, ResourceBinding> getBindingsByPath() {
    return bindingsByPath;
  }

  public ValidationResult processModel(EnunciateFreemarkerModel model, Collection<TypeDeclaration> resourceServiceDefinitions) {
    ValidationResult result = new ValidationResult();

    //todo: error if setter-based resource parameters in the implementation don't carry the annotations defined in the definition, binding...

    for (TypeDeclaration resourceServiceDefinition : resourceServiceDefinitions) {
      ResourceDefinition rsdInfo = resourceServiceDefinition.getAnnotation(ResourceDefinition.class);
      if (rsdInfo != null) {
        List<String> resourceElementsFqn = new ArrayList<String>();

        try {
          for (Class<?> clazz : rsdInfo.resourceElement()) {
            resourceElementsFqn.add(clazz.getName());
          }
        }
        catch (MirroredTypesException e) {
          resourceElementsFqn.addAll(e.getQualifiedNames());
        }

        AnnotationProcessorEnvironment ape = Context.getCurrentEnvironment();
        ArrayList<ElementDeclaration> resourceElements = new ArrayList<ElementDeclaration>();
        for (String resourceElementFqn : resourceElementsFqn) {
          TypeDeclaration declaration = ape.getTypeDeclaration(resourceElementFqn);
          ElementDeclaration resourceElement = null;
          if (declaration instanceof ClassDeclaration) {
            resourceElement = model.findElementDeclaration((ClassDeclaration) declaration);
          }

          if (resourceElement == null) {
            result.addWarning(resourceServiceDefinition, "Unable to find element declaration for " + resourceElementFqn + ".");
          }
          else {
            resourceElements.add(resourceElement);
          }
        }

        Set<QName> subresources = new HashSet<QName>();
        try {
          Class<?>[] subs = rsdInfo.subresources();
          for (Class<?> sub : subs) {
            ResourceDefinition subresourceInfo = sub.getAnnotation(ResourceDefinition.class);
            if (subresourceInfo == null) {
              result.addError(resourceServiceDefinition, String.format("Subresource %s is not annotated with @%s.", sub.getName(), ResourceDefinition.class.getName()));
            }
            else {
              subresources.add(new QName(subresourceInfo.namespace(), subresourceInfo.name()));
            }
          }
        }
        catch (MirroredTypesException e) {
          Collection<TypeMirror> subresourceTypes = e.getTypeMirrors();
          for (TypeMirror subresourceType : subresourceTypes) {
            if (subresourceType instanceof DeclaredType && ((DeclaredType) subresourceType).getDeclaration() != null) {
              ResourceDefinition subresourceInfo = ((DeclaredType) subresourceType).getDeclaration().getAnnotation(ResourceDefinition.class);
              if (subresourceInfo == null) {
                result.addError(resourceServiceDefinition, String.format("Subresource %s is not annotated with @%s.", ((DeclaredType) subresourceType).getDeclaration().getQualifiedName(), ResourceDefinition.class.getName()));
              }
              else {
                subresources.add(new QName(subresourceInfo.namespace(), subresourceInfo.name()));
              }
            }
            else {
              result.addError(resourceServiceDefinition, String.format("Unable to find @%s on subresource %s.", ResourceDefinition.class.getName(), subresourceType));
            }
          }
        }

        LinkedHashMap<QName, TypeDefinition> subresourceElements = new LinkedHashMap<QName, TypeDefinition>();
        XmlElement[] subresourceElementsInfo = rsdInfo.subresourceElements();
        for (XmlElement xmlElement : subresourceElementsInfo) {
          TypeDeclaration subelementDeclaration = null;
          try {
            Class type = xmlElement.type();
            subelementDeclaration = ape.getTypeDeclaration(type.getName());
          }
          catch (MirroredTypeException e) {
            TypeMirror typeMirror = e.getTypeMirror();
            if (typeMirror instanceof ClassType) {
              subelementDeclaration = ((ClassType) typeMirror).getDeclaration();
            }
            else {
              result.addError(resourceServiceDefinition, "Subresource elements must specify type() in the @XmlElement annotation.");
            }
          }

          TypeDefinition typeDef = null;
          RootElementDeclaration rootEl = null;
          if (subelementDeclaration instanceof ClassDeclaration) {
            if ("javax.xml.bind.annotation.XmlElement.DEFAULT".equals(subelementDeclaration.getQualifiedName())) {
              result.addError(resourceServiceDefinition, "Subresource elements must specify type() in the @XmlElement annotation.");
            }
            else {
              rootEl = model.findRootElementDeclaration((ClassDeclaration) subelementDeclaration);
              typeDef = model.findTypeDefinition((ClassDeclaration) subelementDeclaration);
            }
          }

          if (typeDef != null) {
            String ns = xmlElement.namespace();
            if ("##default".equals(ns)) {
              ns = rootEl == null ? "" : rootEl.getNamespace();
            }

            String name = xmlElement.name();
            if ("##default".equals(name)) {
              name = rootEl == null ? null : rootEl.getName();
            }

            if (name != null) {
              QName xmlName = new QName(ns, name);
              ElementDeclaration elementDeclaration = findLocalElementDeclaration(model, xmlName);
              if (elementDeclaration == null) {
                elementDeclaration = rootEl;
              }

              if (elementDeclaration != null) {
                JsonElementWrapper elementWrapper = elementDeclaration.getAnnotation(JsonElementWrapper.class);
                String jsonName = elementWrapper != null ? (elementWrapper.namespace() + elementWrapper.name()) : (elementDeclaration.getNamespace() + elementDeclaration.getName());
                subresourceElements.put(new QName(xmlName.getNamespaceURI(), xmlName.getLocalPart(), jsonName), typeDef);
              }
              else {
                result.addWarning(resourceServiceDefinition, "Unable to find element declaration for subresource element " + xmlName);
              }
            }
          }
        }


        ResourceDefinitionDeclaration rsd = new ResourceDefinitionDeclaration(resourceServiceDefinition, resourceElements, subresources, subresourceElements, this);
        Map<String, ResourceMethod> methodsByOp = new HashMap<String, ResourceMethod>();
        for (ResourceMethod method : rsd.getResourceMethods()) {
          if (method.getHttpMethods().size() > 1) {
            result.addError(method, "Resource definition methods may only apply to one HTTP operation.");
          }
          else {
            String op = method.getHttpMethods().iterator().next();
            ResourceMethod conflict = methodsByOp.put(op, method);
            if (conflict != null) {
              result.addError(method, String.format("HTTP operation %s is already defined by method %s.", op, conflict.getSimpleName()));
            }
          }
        }

        for (ResourceLink link : rsd.getLinks()) {
          String identifier = link.getRel();
          if (!REGISTERED_LINK_RELATIONS.contains(identifier)) {
            try {
              if (!new URI(identifier).isAbsolute()) {
                result.addWarning(rsd, String.format("Link rel %s should be either a registered link type or a valid absolute URI. For more information, see http://tools.ietf.org/html/draft-nottingham-http-link-header.", identifier));
              }
            }
            catch (URISyntaxException e) {
              result.addWarning(rsd, String.format("Link rel %s should be either a registered link type or a valid absolute URI. For more information, see http://tools.ietf.org/html/draft-nottingham-http-link-header.", identifier));
            }
          }
        }

        this.resourceDefinitions.put(new QName(rsd.getNamespace(), rsd.getName()), rsd);
      }
      else {
        result.addWarning(resourceServiceDefinition, String.format("No @%s annotation found.", ResourceDefinition.class.getName()));
      }
    }

    TreeMap<String, ResourceBinding> bindingsByPath = new TreeMap<String, ResourceBinding>(new ResourceMethodPathComparator());
    for (RootResource rootResource : model.getRootResources()) {
      List<ResourceMethod> resourceMethods = rootResource.getResourceMethods(true);
      for (ResourceMethod resourceMethod : resourceMethods) {
        resourceMethod.putMetaData("statusCodes", extractStatusCodes(resourceMethod.getParent(), resourceMethod));
        resourceMethod.putMetaData("warnings", extractWarnings(resourceMethod.getParent(), resourceMethod));

        Resource declaringResource = resourceMethod.getParent();
        ResourceDefinitionDeclaration rsd = findDefiningResourceDefinition(resourceMethod);
        if (rsd != null) {
          resourceMethod.putMetaData("definedBy", rsd);
          String path = resourceMethod.getFullpath();
          ResourceBinding binding = bindingsByPath.get(path);
          if (binding == null) {
            binding = new ResourceBinding(path, rsd);
            bindingsByPath.put(path, binding);
          }
          else {
            String fqn = binding.getDefinition().getQualifiedName();
            if (!fqn.equals(rsd.getQualifiedName())) {
              //it would be nice if a binding could bind more that one resource because then
              //you could return a different resource based on query paramaters.
              //but there are a couple of reasons why this isn't supported yet
              //one is because there would be no way to tell in the docs which resource method to use
              //to get the error codes, etc.
              result.addError(resourceMethod, String.format("Cannot bind resource %s defined by %s to path %s because that path is already binding resource %s defined by %s.", rsd.getName(), rsd.getQualifiedName(), path, binding.getDefinition().getName(), binding.getDefinition().getQualifiedName()));
              continue;
            }
          }

          binding.getMethods().add(resourceMethod);

          if (declaringResource.getAnnotation(ResourceDefinition.class) == null) {
            //as long as the declaring resource class isn't a resource definition itself,
            //we'll consider it's metadata as binding refinements.

            binding.getStatusCodes().addAll(extractStatusCodes(declaringResource));
            binding.getWarnings().addAll(extractWarnings(declaringResource));
            binding.getLinks().addAll(extractLinks(declaringResource));
            binding.getResourceParameters().addAll(declaringResource.getResourceParameters());

            binding.setDocValue(declaringResource.getDocValue()); //last one in wins.
          }
        }
      }
    }

    this.bindingsByPath = bindingsByPath;

    //todo: warn if a definition method isn't bound?

    return result;
  }

  private ElementDeclaration findLocalElementDeclaration(EnunciateFreemarkerModel model, QName xmlName) {
    SchemaInfo schemaInfo = model.getNamespacesToSchemas().get(xmlName.getNamespaceURI());
    for (LocalElementDeclaration localElementDeclaration : schemaInfo.getLocalElementDeclarations()) {
      if (xmlName.getLocalPart().equals(localElementDeclaration.getName())) {
        return localElementDeclaration;
      }
    }
    return null;
  }

  public Set<ResourceLink> extractLinks(TypeDeclaration delegate) {
    Set<ResourceLink> rels = new HashSet<ResourceLink>();
    org.gedcomx.rt.rs.ResourceLink[] resourceLinkInfo = {};
    ResourceLinks resourceLinks = delegate.getAnnotation(ResourceLinks.class);
    if (resourceLinks != null) {
      resourceLinkInfo = resourceLinks.value();
    }
    for (org.gedcomx.rt.rs.ResourceLink rel : resourceLinkInfo) {
      rels.add(new ResourceLink(rel, this));
    }

    Collection<InterfaceType> supers = delegate.getSuperinterfaces();
    for (InterfaceType iface : supers) {
      InterfaceDeclaration decl = iface.getDeclaration();
      if (decl != null && decl.getAnnotation(ResourceDefinition.class) == null && decl.getAnnotation(Path.class) == null) {
        rels.addAll(extractLinks(decl));
      }
    }

    return rels;
  }

  public Set<ResponseCode> extractStatusCodes(TypeDeclaration type, final ResourceMethod method) {
    HashSet<ResponseCode> codes = new HashSet<ResponseCode>();

    if (type != null) {
      for (MethodDeclaration methodDeclaration : type.getMethods()) {
        if (refines(methodDeclaration, method)) {
          codes.addAll(extractStatusCodes(methodDeclaration));
        }
      }

      Collection<InterfaceType> superifaces = type.getSuperinterfaces();
      for (InterfaceType superiface : superifaces) {
        InterfaceDeclaration decl = superiface.getDeclaration();
        codes.addAll(extractStatusCodes(decl, method));
      }

      if (type instanceof ClassDeclaration) {
        codes.addAll(extractStatusCodes(((ClassDeclaration)type).getSuperclass().getDeclaration(), method));
      }
    }

    return codes;
  }

  public Set<ResponseCode> extractWarnings(TypeDeclaration type, final ResourceMethod method) {
    HashSet<ResponseCode> codes = new HashSet<ResponseCode>();

    if (type != null) {
      for (MethodDeclaration methodDeclaration : type.getMethods()) {
        if (refines(methodDeclaration, method)) {
          codes.addAll(extractWarnings(methodDeclaration));
        }
      }

      Collection<InterfaceType> superifaces = type.getSuperinterfaces();
      for (InterfaceType superiface : superifaces) {
        InterfaceDeclaration decl = superiface.getDeclaration();
        codes.addAll(extractWarnings(decl, method));
      }

      if (type instanceof ClassDeclaration) {
        codes.addAll(extractWarnings(((ClassDeclaration) type).getSuperclass().getDeclaration(), method));
      }
    }

    return codes;
  }

  private boolean refines(MethodDeclaration m1, MethodDeclaration m2) {
    while (m1 instanceof DecoratedDeclaration) {
      m1 = (MethodDeclaration) ((DecoratedDeclaration) m1).getDelegate();
    }

    while (m2 instanceof DecoratedDeclaration) {
      m2 = (MethodDeclaration) ((DecoratedDeclaration) m2).getDelegate();
    }

    if (m1.equals(m2)) {
      return true;
    }
    else {
      AnnotationProcessorEnvironment env = Context.getCurrentEnvironment();
      Declarations decls = env.getDeclarationUtils();
      if (decls.overrides(m1, m2)) {
        return true;
      }
      else if (decls.overrides(m2, m1)) {
        return true;
      }
    }

    return false;
  }

  public Set<ResponseCode> extractStatusCodes(Declaration delegate) {
    Set<ResponseCode> codes = new HashSet<ResponseCode>();
    if (delegate != null) {
      org.gedcomx.rt.rs.ResponseCode[] responseCodes = {};
      StatusCodes statusCodesContainer = delegate.getAnnotation(StatusCodes.class);
      if (statusCodesContainer != null) {
        responseCodes = statusCodesContainer.value();
      }
      for (org.gedcomx.rt.rs.ResponseCode responseCode : responseCodes) {
        codes.add(new ResponseCode(responseCode.code(), responseCode.condition()));
      }

      if (delegate instanceof TypeDeclaration) {
        Collection<InterfaceType> supers = ((TypeDeclaration) delegate).getSuperinterfaces();
        for (InterfaceType iface : supers) {
          InterfaceDeclaration decl = iface.getDeclaration();
          if (decl != null && decl.getAnnotation(ResourceDefinition.class) == null && decl.getAnnotation(Path.class) == null) {
            codes.addAll(extractStatusCodes(decl));
          }
        }
      }
    }
    return codes;
  }

  public Set<ResponseCode> extractWarnings(Declaration delegate) {
    Set<ResponseCode> codes = new HashSet<ResponseCode>();

    if (delegate != null) {
      org.gedcomx.rt.rs.ResponseCode[] responseCodes = {};
      Warnings warningsContainer = delegate.getAnnotation(Warnings.class);
      if (warningsContainer != null) {
        responseCodes = warningsContainer.value();
      }
      for (org.gedcomx.rt.rs.ResponseCode responseCode : responseCodes) {
        codes.add(new ResponseCode(responseCode.code(), responseCode.condition()));
      }

      if (delegate instanceof TypeDeclaration) {
        Collection<InterfaceType> supers = ((TypeDeclaration) delegate).getSuperinterfaces();
        for (InterfaceType iface : supers) {
          InterfaceDeclaration decl = iface.getDeclaration();
          if (decl != null && decl.getAnnotation(ResourceDefinition.class) == null && decl.getAnnotation(Path.class) == null) {
            codes.addAll(extractWarnings(decl));
          }
        }
      }
    }

    return codes;
  }

  public ResourceDefinitionDeclaration findResourceDefinition(QName qname) {
    return this.resourceDefinitions.get(qname);
  }

  public ResourceDefinitionDeclaration findDefiningResourceDefinition(ResourceMethod method) {
    TypeDeclaration declaringType = method.getDeclaringType();
    if (declaringType == null) {
      return null;
    }
    else if (declaringType.getAnnotation(ResourceDefinition.class) != null) {
      //the resource method is declared on a resource definition...
      ResourceDefinition rsdInfo = declaringType.getAnnotation(ResourceDefinition.class);
      return findResourceDefinition(new QName(rsdInfo.namespace(), rsdInfo.name()));
    }
    else {
      HashMap<QName, TypeDeclaration> candidates = new HashMap<QName, TypeDeclaration>();
      gatherResourceDefinitions(candidates, declaringType);
      Declarations utils = Context.getCurrentEnvironment().getDeclarationUtils();
      for (Map.Entry<QName, TypeDeclaration> candidate : candidates.entrySet()) {
        for (MethodDeclaration op : candidate.getValue().getMethods()) {
          while (op instanceof DecoratedMethodDeclaration) {
            op = (MethodDeclaration) ((DecoratedMethodDeclaration) op).getDelegate();
          }

          MethodDeclaration implOp = method;
          while (implOp instanceof DecoratedMethodDeclaration) {
            implOp = (MethodDeclaration) ((DecoratedMethodDeclaration) implOp).getDelegate();
          }

          if (utils.overrides(implOp, op)) {
            return findResourceDefinition(candidate.getKey());
          }
        }
      }
    }

    return null;
  }

  private void gatherResourceDefinitions(Map<QName, TypeDeclaration> bucket, TypeDeclaration declaration) {
    Collection<InterfaceType> supers = declaration.getSuperinterfaces();
    for (InterfaceType iface : supers) {
      InterfaceDeclaration idecl = iface.getDeclaration();
      if (idecl != null) {
        ResourceDefinition rsdInfo = idecl.getAnnotation(ResourceDefinition.class);
        if (rsdInfo != null) {
          bucket.put(new QName(rsdInfo.namespace(), rsdInfo.name()), idecl);
        }

        gatherResourceDefinitions(bucket, idecl);
      }
    }
  }
}
