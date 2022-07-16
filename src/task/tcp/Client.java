package task.tcp;

import task.Task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("127.0.0.1", 9999);
        OutputStream out=socket.getOutputStream();
        Task1 task1=new Task1();
        out.write((task1.test()).getBytes("utf-8"));
        InputStream in=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=in.read(bytes);
        System.out.println(new String(bytes,0,len));
        in.close();
        out.close();
        socket.close();
    }
}
