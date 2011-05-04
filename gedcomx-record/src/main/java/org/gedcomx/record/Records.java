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