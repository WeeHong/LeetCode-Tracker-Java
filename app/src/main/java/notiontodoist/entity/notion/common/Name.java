package notiontodoist.entity.notion.common;

import java.util.List;
import notiontodoist.entity.notion.response.filter.Type;

public class Name extends Type {
  private String id;
  private List<Title> title;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public List<Title> getTitle() { return this.title; }

  public void setTitle(List<Title> title) { this.title = title; }
}