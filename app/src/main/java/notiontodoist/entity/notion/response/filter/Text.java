package notiontodoist.entity.notion.response.filter;

public class Text {
  private String content;
  private Link link;

  public String getContent() { return this.content; }

  public void setContent(String content) { this.content = content; }

  public Link getLink() { return this.link; }

  public void setLink(Link link) { this.link = link; }
}