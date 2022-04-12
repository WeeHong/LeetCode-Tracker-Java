package notiontodoist.entity.notion.response.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response extends Type {
  private ArrayList<Result> results;
  @JsonProperty("next_cursor") private String nextCursor;
  @JsonProperty("has_more") private boolean hasMore;

  public ArrayList<Result> getResults() { return this.results; }

  public void setResults(ArrayList<Result> results) { this.results = results; }

  public String getNextCursor() { return this.nextCursor; }

  public void setNextCursor(String nextCursor) { this.nextCursor = nextCursor; }

  public boolean isHasMore() { return this.hasMore; }

  public boolean getHasMore() { return this.hasMore; }

  public void setHasMore(boolean hasMore) { this.hasMore = hasMore; }
}
