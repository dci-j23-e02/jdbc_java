
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
