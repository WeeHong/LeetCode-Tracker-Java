package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import notiontodoist.entity.notion.response.filter.Object;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {
  private String id;
  private String type;
  @JsonProperty("multi_select") private List<Object> multiSelect;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public String getType() { return this.type; }

  public void setType(String type) { this.type = type; }

  public List<Object> getObject() { return this.multiSelect; }

  public void setObject(List<Object> multiSelect) {
    this.multiSelect = multiSelect;
  }
}