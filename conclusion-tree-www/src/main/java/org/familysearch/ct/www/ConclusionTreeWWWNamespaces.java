package org.familysearch.ct.www;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "fsctw",
    uri = ConclusionTreeWWWNamespaces.CONCLUSION_TREE_WWW_V1_NAMESPACE,
    label = "Conclusion Tree WWW Namespace",
    description = "The conclusion tree WWW namespace defines the FamilySearch-specific extensions of the WWW Support.",
    version = "v1",
    xmlMediaType = ConclusionTreeWWWNamespaces.CONCLUSION_TREE_WWW_V1_XML_MEDIA_TYPE,
    jsonMediaType = ConclusionTreeWWWNamespaces.CONCLUSION_TREE_WWW_V1_JSON_MEDIA_TYPE,
    definesRDFSchema = false
  )
} )
public class ConclusionTreeWWWNamespaces {

  private ConclusionTreeWWWNamespaces() {}

  public static final String CONCLUSION_TREE_WWW_V1_NAMESPACE = "http://familysearch.org/ct/www/v1/";
  public static final String CONCLUSION_TREE_WWW_V1_XML_MEDIA_TYPE = "application/x-fs-ct-www-v1+xml";
  public static final String CONCLUSION_TREE_WWW_V1_JSON_MEDIA_TYPE = "application/x-fs-ct-www-v1+json";

}