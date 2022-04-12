package notiontodoist.entity.notion.request.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Request {
  private Filter filter;
  @JsonProperty("start_cursor") private String startCursor;

  public Filter getFilter() { return this.filter; }

  public void setFilter(Filter filter) { this.filter = filter; }

  public String getStartCursor() { return this.startCursor; }

  public void setStartCursor(String startCursor) {
    this.startCursor = startCursor;
  }
}