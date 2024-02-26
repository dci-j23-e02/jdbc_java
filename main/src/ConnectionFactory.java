package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  public static final String URL = "jdbc:postgresql://localhost:5432/test_db";
  private static final String USER = "postgres"; // Default user
  private static final String PASSWORD = ""; // No password set

  /**
   * Get a connection to database
   * @return Connection object
   */
  public static Connection getConnection() {
    Connection conn = null;
    try {
      // Attempt to establish a connection using the default user and no password
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      if (conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn; // Return the connection object
  }
  /**
   * Test Connection
   */

  public static void main(String[] args) {
    Connection connection = getConnection();
    // Ensure to close the connection after use, which is not shown here
  }

}
