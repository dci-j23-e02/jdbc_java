package src;

import java.util.Set;

public interface UserDao {
      User getUser(int userId);
      Set<User> getAllUsers();
      User getUserByUserNameAndPassword(String userName, String password);
      boolean insertUser(User user);
      boolean updateUser(User user);
      boolean deleteUser(int userId);
}
