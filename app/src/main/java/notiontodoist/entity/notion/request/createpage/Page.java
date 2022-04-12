package notiontodoist.entity.notion.request.createpage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import notiontodoist.entity.notion.common.Properties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {
  private Parent parent;
  private Properties properties;

  public Parent getParent() { return this.parent; }

  public void setParent(Parent parent) { this.parent = parent; }

  public Properties getProperties() { return this.properties; }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }
}
