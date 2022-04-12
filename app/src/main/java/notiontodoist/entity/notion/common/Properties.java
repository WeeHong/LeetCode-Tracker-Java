package notiontodoist.entity.notion.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import notiontodoist.entity.notion.response.filter.DateCompletion;

public class Properties {
  @JsonProperty("Date Completion") private DateCompletion dateCompletion;
  @JsonProperty("Featured List") private FeaturedList featuredList;
  @JsonProperty("Difficulty") private Difficulty difficulty;
  @JsonProperty("Tag") private Tag tag;
  @JsonProperty("Progress") private Progress progress;
  @JsonProperty("No") private No no;
  @JsonProperty("Name") private Name name;

  public DateCompletion getDateCompletion() { return this.dateCompletion; }

  public void setDateCompletion(DateCompletion dateCompletion) {
    this.dateCompletion = dateCompletion;
  }

  public FeaturedList getFeaturedList() { return this.featuredList; }

  public void setFeaturedList(FeaturedList featuredList) {
    this.featuredList = featuredList;
  }

  public Difficulty getDifficulty() { return this.difficulty; }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public Tag getTag() { return this.tag; }

  public void setTag(Tag tag) { this.tag = tag; }

  public Progress getProgress() { return this.progress; }

  public void setProgress(Progress progress) { this.progress = progress; }

  public No getNo() { return this.no; }

  public void setNo(No no) { this.no = no; }

  public Name getName() { return this.name; }

  public void setName(Name name) { this.name = name; }
}