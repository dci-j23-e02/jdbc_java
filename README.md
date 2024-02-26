
# PostgreSQL CRUD Operations with JDBC

This guide walks you through setting up a Java project that performs Create, Read, Update, and Delete (CRUD) operations on a PostgreSQL database using the JDBC API.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- PostgreSQL server installed and running.
- Access to a PostgreSQL database and credentials.

## Step 0: Setting Up the Project

1. **Create a New Java Project**: Use your favorite IDE or command line to create a new Java project.

2. **Add PostgreSQL JDBC Driver**: Download the PostgreSQL JDBC driver (`postgresql-VERSION.jar`) from the [official PostgreSQL JDBC Driver page](https://jdbc.postgresql.org/download/).

   - **For IDE Users**: Add the downloaded `.jar` file to your project's build path.
   - **For Command-Line Users**: Place the `.jar` file in your project directory. You will include it in your classpath when compiling and running your program.

## Step 1: Establishing a Connection to the Database

Create a `ConnectionFactory` class that manages the connection to your PostgreSQL database. This class should provide a method to retrieve a `Connection` object using the `DriverManager.getConnection()` method.

## Step 2: Defining the User Model

Define a `User` class that represents the data model for your application. This class includes properties such as `id`, `name`, `pass`, and `age`, along with their getters and setters.

## Step 3: Creating the DAO Interface and Implementation

1. **UserDao Interface**: Define an interface (`UserDao`) that specifies the operations to be performed on the `users` table.

2. **UserDaoImpl Class**: Implement the `UserDao` interface in a class (`UserDaoImpl`). This implementation includes methods to perform CRUD operations using JDBC.

## Step 4: Executing CRUD Operations

Create a `Main` class that demonstrates the usage of `UserDaoImpl` to perform CRUD operations:

1. **Insert Users**: Add three new users to the database.
2. **List Users**: Retrieve and display all users from the database.
3. **Update a User**: Modify the details of one of the users.
4. **Add Another User**: Insert an additional user into the database.
5. **Delete a User**: Remove one of the users from the database.
6. **Final Listing**: Display the final list of users in the database.

## Step 5: Running the Application

- **For IDE Users**: Run the `Main` class using your IDE's run functionality.
- **For Command-Line Users**: Compile and run your application from the command line, ensuring to include the PostgreSQL JDBC driver in your classpath.

    ```bash
    javac -cp .:postgresql-VERSION.jar src/*.java
    java -cp .:postgresql-VERSION.jar src.Main
    ```

  Note: Use `;` instead of `:` on Windows.

## Conclusion

This guide provided a step-by-step approach to setting up a Java project for performing CRUD operations on a PostgreSQL database using JDBC. By following these steps, you can create, read, update, and delete records in your database from a Java application.
