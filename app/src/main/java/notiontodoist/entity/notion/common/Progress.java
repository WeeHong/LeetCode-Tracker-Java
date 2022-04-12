package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import notiontodoist.entity.notion.response.filter.Object;
import notiontodoist.entity.notion.response.filter.Type;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Progress extends Type {
  private String id;
  private Object select;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public Object getObject() { return this.select; }

  public void setObject(Object select) { this.select = select; }
}