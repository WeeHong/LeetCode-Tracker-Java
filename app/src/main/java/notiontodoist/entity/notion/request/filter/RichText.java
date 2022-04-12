package notiontodoist.entity.notion.request.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RichText {
  @JsonProperty("is_not_empty") private boolean isNotEmpty;

  public boolean isIsNotEmpty() { return this.isNotEmpty; }

  public boolean getIsNotEmpty() { return this.isNotEmpty; }

  public void setIsNotEmpty(boolean isNotEmpty) {
    this.isNotEmpty = isNotEmpty;
  }
}
