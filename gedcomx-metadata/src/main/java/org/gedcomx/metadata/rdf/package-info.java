//todo: document how we're going to extend metadata later
@XmlSchema (
  namespace = MetadataConstants.RDF_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED,
  attributeFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.metadata.rdf;

import org.gedcomx.metadata.MetadataConstants;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;