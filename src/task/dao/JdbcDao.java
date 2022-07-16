package task.dao;

import task.Task1;
import task.mysql.MySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDao {
    Connection conn = null;
    Statement statement = null;
    ResultSet result = null;
    public void myJdbc(){
        try {
            conn= MySql.getConnection();
            statement=conn.createStatement();
            Task1 task1=new Task1();
            String un=task1.test();
            System.out.println(un);
            statement.executeUpdate("insert into user (username)values ('"+un+"')");
            String sql1="select username from user";
            result=statement.executeQuery(sql1);
            if (result.next()){
                System.out.println(result.getString("username")+"aaaaaa");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JdbcDao jdbcDao=new JdbcDao();
        jdbcDao.myJdbc();
    }
}
