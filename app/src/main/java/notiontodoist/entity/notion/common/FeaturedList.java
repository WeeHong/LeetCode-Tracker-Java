package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import notiontodoist.entity.notion.response.filter.Object;
import notiontodoist.entity.notion.response.filter.Type;

public class FeaturedList extends Type {
  private String id;
  @JsonProperty("multi_select") private ArrayList<Object> multiSelect;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public ArrayList<Object> getObject() { return this.multiSelect; }

  public void setObject(ArrayList<Object> multiSelect) {
    this.multiSelect = multiSelect;
  }
}