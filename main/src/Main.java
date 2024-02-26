package src;

public class Main {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImpl();

    // Insert three new users
    System.out.println("Inserting three new users...");
    User user1 = new User("Alice", "pass123", 28);
    User user2 = new User("Bob", "pass456", 32);
    User user3 = new User("Charlie", "pass789", 24);

    userDao.insertUser(user1);
    userDao.insertUser(user2);
    userDao.insertUser(user3);

    // List all users
    System.out.println("\nListing all users after initial insert:");
    listAllUsers(userDao);

    // Update the first user (assuming Alice's ID is 1, this might need adjustment based on your actual data)
    System.out.println("\nUpdating Alice's information...");
    User userToUpdate = userDao.getUserByUserNameAndPassword("Alice", "pass123");
    if (userToUpdate != null) {
      userToUpdate.setName("AliceUpdated");
      userToUpdate.setPass("newpass123");
      userToUpdate.setAge(29);
      userDao.updateUser(userToUpdate);
    }

    // Add another user
    System.out.println("\nAdding a new user (Dave)...");
    User newUser = new User("Dave", "davepass", 35);
    userDao.insertUser(newUser);

    // List all users after update and addition
    System.out.println("\nListing all users after update and addition:");
    listAllUsers(userDao);

    // Delete one user (assuming Bob's ID is 2, this might need adjustment based on your actual data)
    System.out.println("\nDeleting Bob...");
    User userToDelete = userDao.getUserByUserNameAndPassword("Bob", "pass456");
    if (userToDelete != null) {
      userDao.deleteUser(userToDelete.getId());
    }

    // List all users after deletion
    System.out.println("\nListing all users after deletion:");
    listAllUsers(userDao);
  }

  private static void listAllUsers(UserDao userDao) {
    for (User user : userDao.getAllUsers()) {
      System.out.println(user.getId() + ", " + user.getName() + ", " + user.getPass() + ", " + user.getAge());
    }
  }
}