package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author yuqiCao
 * @create 2021-03-20 11:22 下午
 */
public class TCPTest2 {
    /*
    涉及的异常，应该使用try-catch-finally
     */
    @Test
    public void client() throws IOException {

        //1
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2
        OutputStream os = socket.getOutputStream();
        //3
        FileInputStream fis = new FileInputStream(new File("图片.png"));
        //4
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5
        fis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {

        //1.造  ServerSocket
        ServerSocket ss = new ServerSocket(9090);
        //2获取客户端的socket
        Socket socket = ss.accept();
        //3。获取客户端的输入流
        InputStream is = socket.getInputStream();
        //本地的
        FileOutputStream fos = new FileOutputStream(new File("图片2.png"));
        //5
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer) )!= -1){
            fos.write(buffer,0,len);
        }
        //6
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }


}
