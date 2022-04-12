package notiontodoist.entity.notion.response.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notiontodoist.entity.notion.common.Properties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
  private Properties properties;
  private String url;

  public Properties getProperties() { return this.properties; }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public String getUrl() { return this.url; }

  public void setUrl(String url) { this.url = url; }
}