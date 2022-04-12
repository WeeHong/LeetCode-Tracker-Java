package notiontodoist.entity.notion.common;

import notiontodoist.entity.notion.response.filter.Type;

public class No extends Type {
  private String id;
  private int number;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public int getNumber() { return this.number; }

  public void setNumber(int number) { this.number = number; }
}