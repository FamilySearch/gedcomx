@XmlSchema(
  namespace = RecordConstants.GEDCOMX_RECORD_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.record;

//todo: figure out all the valid types
//todo: figure out user-defined types: come up with conventions for extending known types (e.g. qname ns/localpart should resolve to a description of the type)
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;