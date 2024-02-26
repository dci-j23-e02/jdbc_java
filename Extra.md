The `UserDaoImpl` class implements the `UserDao` interface, providing concrete implementations for interacting with a PostgreSQL database to perform CRUD operations on a `users` table. Let's break down each method step by step:

### `getUser(int userId)`

1. **Prepare SQL Query**: A SQL query string is defined to select all columns from the `users` table where the `id` matches a specific value. The `?` is a placeholder for the user ID parameter.
2. **Establish Connection**: It obtains a database connection using the `ConnectionFactory.getConnection()` method.
3. **Prepare Statement**: A `PreparedStatement` is created from the connection, which allows setting the user ID parameter safely to prevent SQL injection.
4. **Execute Query**: The query is executed, and a `ResultSet` object is returned, containing the data fetched from the database.
5. **Extract User**: If the `ResultSet` has at least one row (`resultSet.next()` returns `true`), the `extractUserFromResultSet` method is called to map the row to a `User` object.
6. **Return User or Null**: The method returns the `User` object if found; otherwise, it returns `null`.

### `getAllUsers()`

1. **Prepare SQL Query**: A SQL query string is defined to select all columns from the `users` table.
2. **Establish Connection and Create Statement**: Similar to `getUser`, but uses a `Statement` since the query does not have parameters.
3. **Execute Query and Fetch Results**: The query is executed, and results are fetched into a `ResultSet`.
4. **Iterate and Extract Users**: Iterates over the `ResultSet`, extracting each user using `extractUserFromResultSet` and adding them to a `Set<User>` to ensure uniqueness.
5. **Return Users**: Returns the set of users.

### `getUserByUserNameAndPassword(String userName, String password)`

Similar to `getUser(int userId)`, but the query filters users by both `name` and `pass` columns. It demonstrates how to use multiple parameters in a `PreparedStatement`.

### `insertUser(User user)`

1. **Prepare SQL Insert Query**: Defines a SQL query to insert a new row into the `users` table with values for `name`, `pass`, and `age`.
2. **Set Parameters and Execute Update**: Sets the parameters from the `User` object on the `PreparedStatement` and executes the update.
3. **Check Insertion Success**: Checks if the insertion was successful by examining the number of affected rows. Returns `true` if at least one row was affected.

### `updateUser(User user)`

1. **Prepare SQL Update Query**: Defines a SQL query to update a user's `name`, `pass`, and `age` in the `users` table based on the user's `id`.
2. **Set Parameters and Execute Update**: Similar to `insertUser`, but includes the user's `id` as a parameter to identify which row to update.
3. **Check Update Success**: Returns `true` if the update affected at least one row.

### `deleteUser(int userId)`

1. **Prepare SQL Delete Query**: Defines a SQL query to delete a row from the `users` table where the `id` matches the specified user ID.
2. **Set Parameter and Execute Update**: Sets the user ID parameter on the `PreparedStatement` and executes the update.
3. **Check Deletion Success**: Returns `true` if the deletion affected at least one row.

### `extractUserFromResultSet(ResultSet resultSet)`

A helper method that maps a row from the `ResultSet` to a `User` object by calling the appropriate `get` methods on the `ResultSet` for each column and setting the corresponding fields on the `User` object.

### Exception Handling

Each method includes a `try-catch` block to handle `SQLException`, ensuring the program does not crash due to database errors. The exceptions are printed to the standard error stream.

This class demonstrates a straightforward approach to implementing CRUD operations using JDBC, emphasizing the importance of using `PreparedStatement` to prevent SQL injection and the pattern of resource management (e.g., using try-with-resources to ensure connections, statements, and result sets are closed properly).