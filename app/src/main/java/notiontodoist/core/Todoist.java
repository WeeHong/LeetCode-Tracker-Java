package notiontodoist.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Todoist {
  public Todoist() {}

  public List<String> getAllTasks() throws URISyntaxException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(new URI("https://api.todoist.com/rest/v1/tasks"))
            .GET()
            .header("Content-Type", "application/json")
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
  }
}
