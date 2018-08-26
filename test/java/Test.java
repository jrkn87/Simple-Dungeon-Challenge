import java.sql.*;

public class Test {
    public static void main(String[] args) {

        try {
            Class.forName("org.hsqldb.jdbcDriver");

            Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/loty.db", "SA", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM HERO");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("NAME"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
