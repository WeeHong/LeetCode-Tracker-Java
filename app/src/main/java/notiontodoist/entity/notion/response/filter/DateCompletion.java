package notiontodoist.entity.notion.response.filter;

public class DateCompletion extends Type {
  private String id;
  private Timestamp date;

  public String getId() { return this.id; }

  public void setId(String id) { this.id = id; }

  public Timestamp getDate() { return this.date; }

  public void setDate(Timestamp date) { this.date = date; }
}