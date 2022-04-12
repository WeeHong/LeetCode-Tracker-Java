package notiontodoist.entity.notion.response.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class File {
  private String url;
  @JsonProperty("expiry_time") private Date expiryTime;

  public String getUrl() { return this.url; }

  public void setUrl(String url) { this.url = url; }

  public Date getExpiryTime() { return this.expiryTime; }

  public void setExpiryTime(Date expiryTime) { this.expiryTime = expiryTime; }
}