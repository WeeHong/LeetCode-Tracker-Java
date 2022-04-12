package notiontodoist.entity.notion.response.filter;

public class Annotations {
  private boolean bold;
  private boolean italic;
  private boolean strikethrough;
  private boolean underline;
  private boolean code;
  private String color;

  public boolean isBold() { return this.bold; }

  public boolean getBold() { return this.bold; }

  public void setBold(boolean bold) { this.bold = bold; }

  public boolean isItalic() { return this.italic; }

  public boolean getItalic() { return this.italic; }

  public void setItalic(boolean italic) { this.italic = italic; }

  public boolean isStrikethrough() { return this.strikethrough; }

  public boolean getStrikethrough() { return this.strikethrough; }

  public void setStrikethrough(boolean strikethrough) {
    this.strikethrough = strikethrough;
  }

  public boolean isUnderline() { return this.underline; }

  public boolean getUnderline() { return this.underline; }

  public void setUnderline(boolean underline) { this.underline = underline; }

  public boolean isCode() { return this.code; }

  public boolean getCode() { return this.code; }

  public void setCode(boolean code) { this.code = code; }

  public String getColor() { return this.color; }

  public void setColor(String color) { this.color = color; }
}