package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import notiontodoist.entity.notion.response.filter.Annotations;
import notiontodoist.entity.notion.response.filter.Text;
import notiontodoist.entity.notion.response.filter.Type;

public class Title extends Type {
  private Text text;
  private Annotations annotations;
  @JsonProperty("plain_text") private String plainText;
  private String href;

  public Text getText() { return this.text; }

  public void setText(Text text) { this.text = text; }

  public Annotations getAnnotations() { return this.annotations; }

  public void setAnnotations(Annotations annotations) {
    this.annotations = annotations;
  }

  public String getPlainText() { return this.plainText; }

  public void setPlainText(String plainText) { this.plainText = plainText; }

  public String getHref() { return this.href; }

  public void setHref(String href) { this.href = href; }
}