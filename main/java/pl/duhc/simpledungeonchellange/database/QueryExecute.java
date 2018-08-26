package pl.duhc.simpledungeonchellange.database;

import java.sql.SQLException;

public class QueryExecute extends DBConnection {

    //private String sqlQuery, sql;

    public QueryExecute(String sqlQuery) {
        super(sqlQuery);
    }

    protected void executeQuery() throws SQLException, ClassNotFoundException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("NAME"));
        }
    }
}
