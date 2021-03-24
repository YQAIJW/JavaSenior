package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 从客户端发送文件给服务端，服务端保存到本地。并返回"发送成功"给客户端。
 * 并关闭相应的连接
 *
 *
 * @author yuqiCao
 * @create 2021-03-20 11:45 下午
 */
public class TCPTest3 {

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

        socket.shutdownOutput();

        //5接收服务端的反馈信息，显示到控制台
        InputStream is = socket.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while ((len1 = is.read(bufferr) )!= -1){
            baos.write(bufferr,0,len1);
        }
        System.out.println(baos.toString());


        //6
        fis.close();
        os.close();
        socket.close();
        baos.close();
        is.close();

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
        FileOutputStream fos = new FileOutputStream(new File("图片3.png"));
        //5
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer) )!= -1){
            fos.write(buffer,0,len);
        }
        //6.服务器端给予反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好mm，照片已收到！".getBytes());


        //7
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }



}
