package JDBC;

import java.sql.*;

/**
 * Created by Errol on 17/3/9.
 * jdbc连接mysql
 */
public class JdbcTest {

    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/mjmh";
    static final String user = "root";
    static final String pass = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        CallableStatement callableStatement = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
//            preparedStatement = connection.prepareStatement("UPDATE  mjmh_cards set balance=? where id=?");
//            preparedStatement.setInt(1, 100);
//            preparedStatement.setInt(2, 1);
//            callableStatement = connection.prepareCall("{call getBalanceList(?,?)}");//getBalanceList()如何定义？
            ResultSet resultSet = statement.executeQuery("SELECT  cardtype,balance FROM  mjmh_cards");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("cardtype") + "|" + resultSet.getInt("balance"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
