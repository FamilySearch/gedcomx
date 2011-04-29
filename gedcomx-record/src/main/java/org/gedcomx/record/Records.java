package org.gedcomx.record;

import org.codehaus.enunciate.ClientName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Iterator;
import java.util.List;

@XmlRootElement (name = "records")
public class Records implements Iterable<Record> {

  private List<Record> records;

  public Records() {
  }

  @javax.xml.bind.annotation.XmlElement(name = "record")
  @ClientName("recordList")
  public List<Record> getRecords() {
    return records;
  }

  public void setRecords(List<Record> records)
  {
    this.records = records;
  }

  public Iterator<Record> iterator() {
    return records.iterator();
  }

}