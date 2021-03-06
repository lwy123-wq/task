package task.tcp;

import task.dao.JdbcDao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(9999);
            Socket socket=serverSocket.accept();
            InputStream in=socket.getInputStream();
            byte[] bytes=new byte[1024];
            int len=in.read(bytes);
            System.out.println(new String(bytes,0,len));
            OutputStream out=socket.getOutputStream();
            JdbcDao jdbcDao=new JdbcDao();
            String str=jdbcDao.myJdbc();
            out.write(("接收到了"+str).getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
