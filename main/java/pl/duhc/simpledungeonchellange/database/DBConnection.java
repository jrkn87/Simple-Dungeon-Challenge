package pl.duhc.simpledungeonchellange.database;

import java.sql.*;

public abstract class DBConnection {

    private static final String JDBC_URL = "jdbc:hsqldb:file:data/loty.db";
    private static final String USERNAME = "SA";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASSNAME = "org.hsqldb.jdbcDriver";
    private Statement statement;
    protected ResultSet resultSet;
    private Connection connection;
    private String sqlQuery;

    public DBConnection(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public void execute() {
        try {
            connectToDataBase();
            createQuery();
            executeQuery();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connectToDataBase() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASSNAME);
        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void createQuery() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sqlQuery);
    }

    abstract protected void executeQuery() throws SQLException, ClassNotFoundException;

    private void close() throws SQLException {
        resultSet.close();
        statement.executeQuery("SHUTDOWN;");
        statement.close();
        connection.close();
    }
}
