package org.familysearch.ct.ws;

import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@Models ( {
  @Model (
    id = "fsct",
    namespace = ConclusionTreeModel.CONCLUSION_TREE_V1_NAMESPACE,
    label = "Conclusion Tree Model",
    description = "The conclusion tree model defines the FamilySearch-specific extensions of the standard model.",
    version = "v1",
    xmlMediaType = ConclusionTreeModel.CONCLUSION_TREE_V1_XML_MEDIA_TYPE,
    jsonMediaType = ConclusionTreeModel.CONCLUSION_TREE_V1_JSON_MEDIA_TYPE,
    definesRDFSchema = false
  )
} )
public class ConclusionTreeModel {

  private ConclusionTreeModel() {}

  public static final String CONCLUSION_TREE_V1_NAMESPACE = "http://familysearch.org/ct/v1/";
  public static final String CONCLUSION_TREE_V1_XML_MEDIA_TYPE = "application/x-fs-ct-v1+xml";
  public static final String CONCLUSION_TREE_V1_JSON_MEDIA_TYPE = "application/x-fs-ct-v1+json";

}