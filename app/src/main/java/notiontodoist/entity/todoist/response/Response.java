package notiontodoist.entity.todoist.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
  @JsonProperty("id") private int id;

  @JsonProperty("assigner") private int assigner;

  @JsonProperty("project_id") private int projectId;

  @JsonProperty("section_id") private int sectionId;

  @JsonProperty("order") private int order;

  @JsonProperty("content") private String content;

  @JsonProperty("description") private String description;

  @JsonProperty("completed") private boolean Completed;

  @JsonProperty("label_ids") private List<?> LabelIds;

  @JsonProperty("priority") private int Priority;

  @JsonProperty("comment_count") private int CommentCount;

  @JsonProperty("creator") private int Creator;

  @JsonProperty("url") private URI Url;

  public int getId() { return this.id; }

  public void setId(int id) { this.id = id; }

  public int getAssigner() { return this.assigner; }

  public void setAssigner(int assigner) { this.assigner = assigner; }

  public int getProjectId() { return this.projectId; }

  public void setProjectId(int projectId) { this.projectId = projectId; }

  public int getSectionId() { return this.sectionId; }

  public void setSectionId(int sectionId) { this.sectionId = sectionId; }

  public int getOrder() { return this.order; }

  public void setOrder(int order) { this.order = order; }

  public String getContent() { return this.content; }

  public void setContent(String content) { this.content = content; }

  public String getDescription() { return this.description; }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() { return this.Completed; }

  public boolean getCompleted() { return this.Completed; }

  public void setCompleted(boolean Completed) { this.Completed = Completed; }

  public List<?> getLabelIds() { return this.LabelIds; }

  public void setLabelIds(List<?> LabelIds) { this.LabelIds = LabelIds; }

  public int getPriority() { return this.Priority; }

  public void setPriority(int Priority) { this.Priority = Priority; }

  public int getCommentCount() { return this.CommentCount; }

  public void setCommentCount(int CommentCount) {
    this.CommentCount = CommentCount;
  }

  public int getCreator() { return this.Creator; }

  public void setCreator(int Creator) { this.Creator = Creator; }

  public URI getUrl() { return this.Url; }

  public void setUrl(URI Url) { this.Url = Url; }
}
