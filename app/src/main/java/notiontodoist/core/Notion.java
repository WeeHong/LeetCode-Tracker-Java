package notiontodoist.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import notiontodoist.entity.notion.common.Difficulty;
import notiontodoist.entity.notion.common.Name;
import notiontodoist.entity.notion.common.No;
import notiontodoist.entity.notion.common.Progress;
import notiontodoist.entity.notion.common.Properties;
import notiontodoist.entity.notion.common.Tag;
import notiontodoist.entity.notion.common.Title;
import notiontodoist.entity.notion.request.createpage.Page;
import notiontodoist.entity.notion.request.createpage.Parent;
import notiontodoist.entity.notion.request.filter.Filter;
import notiontodoist.entity.notion.request.filter.Request;
import notiontodoist.entity.notion.request.filter.RichText;
import notiontodoist.entity.notion.response.filter.Annotations;
import notiontodoist.entity.notion.response.filter.Link;
import notiontodoist.entity.notion.response.filter.Object;
import notiontodoist.entity.notion.response.filter.Response;
import notiontodoist.entity.notion.response.filter.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Notion {
  private static final Logger logger = LogManager.getLogger(Notion.class);
  private String token;
  private String database;
  private String version;

  public Notion(String token, String version, String database) {
    this.token = token;
    this.database = database;
    this.version = version;
  }

  public boolean IsDatabaseExists() throws URISyntaxException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(
                "https://api.notion.com/v1/databases/%s".formatted(database)))
            .GET()
            .header("Authorization", "Bearer %s".formatted(token))
            .header("Content-Type", "application/json")
            .header("Notion-Version", version)
            .build();
    CompletableFuture<HttpResponse<String>> response =
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    try {
      int statusCode =
          response.thenApply(HttpResponse::statusCode).get(5, TimeUnit.SECONDS);
      return statusCode == 200;
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      logger.error("IsDatabaseExists: {}", e);
    }

    return false;
  };

  public int CountTotalRecord(String token, String version, String database)
      throws IOException, InterruptedException {
    Response notions = null;
    String startCursor = null;
    int total = 0;
    RichText richText = new RichText();
    richText.setIsNotEmpty(true);

    Filter filter = new Filter();
    filter.setRichText(richText);
    filter.setProperty("Name");

    Request notionRequest = new Request();
    notionRequest.setFilter(filter);

    do {
      logger.info("Querying Notion database total {} record:", total);

      if (startCursor != null) {
        notionRequest.setStartCursor(startCursor);
      }

      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request =
          HttpRequest.newBuilder()
              .uri(URI.create(
                  "https://api.notion.com/v1/databases/%s/query".formatted(
                      database)))
              .POST(HttpRequest.BodyPublishers.ofString(
                  ow.writeValueAsString(notionRequest)))
              .header("Authorization", "Bearer %s".formatted(token))
              .header("Content-Type", "application/json")
              .header("Notion-Version", version)
              .build();
      CompletableFuture<HttpResponse<String>> response =
          client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
      try {
        String result = response.thenApply(HttpResponse::body).get();
        ObjectMapper mapper = new ObjectMapper();
        notions = mapper.readValue(result, new TypeReference<Response>() {});
        total += notions.getResults().size();
        startCursor = notions.getNextCursor();
      } catch (InterruptedException | ExecutionException e) {
        logger.error("IsDatabaseExists: {}", e);
      }
    } while (startCursor != null);

    return total;
  }

  public boolean createNotionRecord(List<HashMap<String, String>> rs)
      throws SQLException, JsonProcessingException, URISyntaxException,
             TimeoutException {
    boolean isSuccess = true;

    logger.info("Reading database record");

    for (HashMap<String, String> result : rs) {
      List<Object> tagOptions = new ArrayList<>();
      HashSet<String> uniqueTags = new HashSet<>();

      String[] tags = result.get("tags").split(",");
      for (String tag : tags) {
        uniqueTags.add(tag.trim());
      }
      for (String tag : uniqueTags) {
        Object multiSelect = new Object();
        multiSelect.setName(tag);
        tagOptions.add(multiSelect);
      }

      Link link = new Link();
      link.setUrl(
          "https://leetcode.com/problems/%s".formatted(result.get("slug")));

      Text text = new Text();
      text.setContent(result.get("title"));
      text.setLink(link);

      Annotations annotations = new Annotations();
      annotations.setBold(false);
      annotations.setItalic(false);
      annotations.setStrikethrough(false);
      annotations.setUnderline(false);
      annotations.setCode(false);
      annotations.setColor("default");

      Title title = new Title();
      title.setType("text");
      title.setText(text);
      title.setAnnotations(annotations);
      title.setPlainText(result.get("title"));
      title.setHref(
          "https://leetcode.com/problems/%s".formatted(result.get("slug")));

      List<Title> titles = new ArrayList<>();
      titles.add(title);

      Parent parent = new Parent();
      parent.setDatabaseId(database);

      Tag tag = new Tag();
      tag.setType("multi_select");
      tag.setObject(tagOptions);

      Object multiSelect = new Object();
      multiSelect.setName(result.get("difficulty"));

      Difficulty difficulty = new Difficulty();
      difficulty.setType("select");
      difficulty.setObject(multiSelect);

      Progress progress = new Progress();
      progress.setType("select");

      No no = new No();
      no.setType("number");
      no.setNumber(Integer.parseInt(result.get("id")));

      Name name = new Name();
      name.setId("title");
      name.setType("title");
      name.setTitle(titles);

      Properties properties = new Properties();
      properties.setTag(tag);
      properties.setDifficulty(difficulty);
      properties.setProgress(progress);
      properties.setNo(no);
      properties.setName(name);

      Page page = new Page();
      page.setParent(parent);
      page.setProperties(properties);

      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request =
          HttpRequest.newBuilder()
              .uri(new URI("https://api.notion.com/v1/pages"))
              .POST(HttpRequest.BodyPublishers.ofString(
                  ow.writeValueAsString(page)))
              .header("Authorization", "Bearer %s".formatted(token))
              .header("Content-Type", "application/json")
              .header("Notion-Version", version)
              .build();
      CompletableFuture<HttpResponse<String>> response =
          client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
      try {
        int statusCode = response.thenApply(HttpResponse::statusCode)
                             .get(5, TimeUnit.SECONDS);
        logger.info("Reading response from API");
        return statusCode == 200;
      } catch (InterruptedException | ExecutionException e) {
        logger.error("IsDatabaseExists: {}", e);
      }
    }
    return isSuccess;
  }
}
