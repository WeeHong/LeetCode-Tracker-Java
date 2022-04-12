package notiontodoist.entity.notion.request.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
  private String property;
  @JsonProperty("rich_text") private RichText richText;

  public String getProperty() { return this.property; }

  public void setProperty(String property) { this.property = property; }

  public RichText getRichText() { return this.richText; }

  public void setRichText(RichText richText) { this.richText = richText; }
}
