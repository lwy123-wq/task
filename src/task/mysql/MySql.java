package task.mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySql {
    /*public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","lwy0328");
            System.out.println("aaaaaaaaa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }*/
    public static Connection getConnection() throws Exception {
        String driver =null;
        String jdbcUrl =null;
        String user =null;
        String password =null;

        InputStream inputStream = MySql.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        driver = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        Class.forName(driver);
        Connection conn = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
        return conn;
    }

    public static void main(String[] args) throws Exception {
        MySql.getConnection();
    }
}
