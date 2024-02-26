package src;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements UserDao {

  @Override
  public User getUser(int userId) {
    final String query = "SELECT * FROM users WHERE id = ?";
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, userId);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return extractUserFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Set<User> getAllUsers() {
    final String query = "SELECT * FROM users";
    Set<User> users = new HashSet<>();
    try (Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      while (resultSet.next()) {
        User user = extractUserFromResultSet(resultSet);
        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public User getUserByUserNameAndPassword(String userName, String password) {
    final String query = "SELECT * FROM users WHERE name = ? AND pass = ?";
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, userName);
      preparedStatement.setString(2, password);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return extractUserFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean insertUser(User user) {
    final String query = "INSERT INTO users (name, pass, age) VALUES (?, ?, ?)";
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getPass());
      preparedStatement.setInt(3, user.getAge());
      int affectedRows = preparedStatement.executeUpdate();
      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean updateUser(User user) {
    final String query = "UPDATE users SET name = ?, pass = ?, age = ? WHERE id = ?";
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getPass());
      preparedStatement.setInt(3, user.getAge());
      preparedStatement.setInt(4, user.getId());
      int affectedRows = preparedStatement.executeUpdate();
      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean deleteUser(int userId) {
    final String query = "DELETE FROM users WHERE id = ?";
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, userId);
      int affectedRows = preparedStatement.executeUpdate();
      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
    User user = new User();
    user.setId(resultSet.getInt("id"));
    user.setName(resultSet.getString("name"));
    user.setPass(resultSet.getString("pass"));
    user.setAge(resultSet.getInt("age"));
    return user;
  }
}