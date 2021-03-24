package com.atguigu.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网路编程
 * 例子1：客户端发送信息给服务端，服务端将信息显示在控制台
 *
 *
 * @author yuqiCao
 * @create 2021-03-20 4:58 下午
 */
public class TCPTest1 {

    //客户端
    @Test
    public  void client()  {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet,8899);

            os = socket.getOutputStream();
            os.write("你好，我是客户端mm".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务端
    @Test
    public void server()  {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2。调用accept()表示接受来自于客户端的Socket
            socket = ss.accept();
            //3。获取输入流
            is = socket.getInputStream();

            //可能有乱码，不建议
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }
            //4。读取输入流当中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (baos != null){

                //5。资源的关闭
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //关闭资源

    }
}
