package notiontodoist.entity.notion.response.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Object {
  private String id;
  private String name;
  private String color;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  public String getColor() { return this.color; }

  public void setColor(String color) { this.color = color; }
}