package org.familysearch.ct.ws;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "fsct",
    uri = ConclusionTreeNamespaces.CONCLUSION_TREE_V1_NAMESPACE,
    label = "Conclusion Tree Namespace",
    description = "The conclusion tree namespace defines the FamilySearch-specific extensions of the model.",
    version = "v1",
    xmlMediaType = ConclusionTreeNamespaces.CONCLUSION_TREE_V1_XML_MEDIA_TYPE,
    jsonMediaType = ConclusionTreeNamespaces.CONCLUSION_TREE_V1_JSON_MEDIA_TYPE,
    definesRDFSchema = false
  )
} )
public class ConclusionTreeNamespaces {

  private ConclusionTreeNamespaces() {}

  public static final String CONCLUSION_TREE_V1_NAMESPACE = "http://familysearch.org/ct/v1/";
  public static final String CONCLUSION_TREE_V1_XML_MEDIA_TYPE = "application/x-fs-ct-v1+xml";
  public static final String CONCLUSION_TREE_V1_JSON_MEDIA_TYPE = "application/x-fs-ct-v1+json";

}