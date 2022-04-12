package notiontodoist.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Database {
  private static final Logger logger = LogManager.getLogger(Database.class);
  private static Connection connection = null;

  public Database(String host, String port, String database, String user,
                  String password) {
    try {
      String url =
          "jdbc:postgresql://%s:%s/%s?user=%s&password=%s&ssl=false".formatted(
              host, port, database, user, password);
      connection = DriverManager.getConnection(url);
    } catch (SQLException e) {
      logger.error("PostgreSQL error: {}", e.getMessage());
      System.exit(-1);
    }
  }

  public int CompareTotalQuestions() {
    String query =
        "SELECT total FROM records ORDER BY created_at DESC LIMIT 1;";
    int total = 0;

    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        total = rs.getInt("total");
      }
      rs.close();
      pstmt.close();
    } catch (SQLException e) {
      logger.error("CompareTotalQuestions error: ", e);
    }

    return total;
  }

  public List<HashMap<String, String>> selectQuestions(int total) {
    HashMap<String, String> hm = new HashMap<>();
    List<HashMap<String, String>> result = new ArrayList<>();
    String query =
        "SELECT questions_tags.question_id, questions.title, questions.slug, questions.difficulty, string_agg(tags.name, ', ') FROM questions_tags LEFT JOIN questions ON questions.id = questions_tags.question_id LEFT JOIN tags ON tags.id = questions_tags.tag_id GROUP BY questions_tags.question_id, questions.title, questions.slug, questions.difficulty OFFSET %d"
            .formatted(total);

    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        hm.put("id", rs.getString("id"));
        hm.put("title", rs.getString("title"));
        hm.put("slug", rs.getString("slug"));
        hm.put("difficulty", rs.getString("difficulty"));

        result.add(hm);
      }

      rs.close();
      pstmt.close();

      return result;
    } catch (SQLException e) {
      logger.error("CompareTotalQuestions error: ", e);
    }

    return null;
  }
}
