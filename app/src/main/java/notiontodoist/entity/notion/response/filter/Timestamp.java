package notiontodoist.entity.notion.response.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timestamp {
  private String start;
  private String end;
  @JsonProperty("time_zone") private String timezone;

  public String getStart() { return this.start; }

  public void setStart(String start) { this.start = start; }

  public String getEnd() { return this.end; }

  public void setEnd(String end) { this.end = end; }

  public String getTimezone() { return this.timezone; }

  public void setTimezone(String timezone) { this.timezone = timezone; }
}