package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import notiontodoist.entity.notion.response.filter.Object;
import notiontodoist.entity.notion.response.filter.Type;

public class Difficulty extends Type {
  private String id;
  @JsonProperty("select") private Object select;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public Object getObject() { return this.select; }

  public void setObject(Object select) { this.select = select; }
}