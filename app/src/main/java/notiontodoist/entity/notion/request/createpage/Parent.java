package notiontodoist.entity.notion.request.createpage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parent {
  @JsonProperty("database_id") private String databaseId;

  public String getDatabaseId() { return this.databaseId; }

  public void setDatabaseId(String databaseId) { this.databaseId = databaseId; }
}
