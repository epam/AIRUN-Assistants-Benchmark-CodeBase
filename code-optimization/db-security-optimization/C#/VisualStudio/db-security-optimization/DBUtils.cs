using Microsoft.Data.Sqlite;

public static class DBUtils
{
    private const string CreateUserTableSql = "CREATE TABLE user (id INT PRIMARY KEY, name VARCHAR(255))";
    private const string ConnectionString = "Data Source=:memory:";

    public static SqliteConnection CreateDbConnection()
    {
        try
        {
            var connection = new SqliteConnection(ConnectionString);
            connection.Open();
            return connection;
        }
        catch (Exception e)
        {
            throw new Exception("Exception during DB connection", e);
        }
    }

    public static void InsertUsersIntoUserTable(SqliteConnection connection)
    {
        using (var command = new SqliteCommand("INSERT INTO user (id, name) VALUES (1, 'Name1')", connection))
        {
            command.ExecuteNonQuery();
        }
    }

    public static void CreateUserTable(SqliteConnection connection)
    {
        using (var command = new SqliteCommand(CreateUserTableSql, connection))
        {
            command.ExecuteNonQuery();
        }
    }



}