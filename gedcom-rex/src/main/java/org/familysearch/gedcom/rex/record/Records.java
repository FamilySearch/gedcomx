package org.familysearch.gedcom.rex.record;

import org.codehaus.enunciate.ClientName;

import java.util.List;
import java.util.Iterator;

/**
 * @author Merlin Carpenter
 *         Date: Jun 9, 2009
 */
@javax.xml.bind.annotation.XmlRootElement(name = "records")
public class Records  implements Iterable<Record> {

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