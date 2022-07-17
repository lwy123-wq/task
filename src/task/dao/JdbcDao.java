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
    public String myJdbc(){
        String str=null;
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
                str=result.getString("username");
            }
            //System.out.println(str+"aa");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        JdbcDao jdbcDao=new JdbcDao();
        jdbcDao.myJdbc();
    }
}
