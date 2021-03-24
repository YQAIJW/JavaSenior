package com.atguigu.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 二、网络编程中的两个要素：
 * 1。IP和端口号
 * 2。提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路）
 *
 * 三、通信要素：IP和端口号
 * 1。IP：唯一的标识Internet上的计算机（通信实体）
 * 2。在Java中使用InetAddress类代表Ip
 * 3。IP分类：IPv4和Ipv6；万维网和局域网
 * 4.域名：www.baidu.com www.mi.com www.sina.com
 * 5.本地回路地址：127.0.0.1 对应着：localhost
 *
 * 6.如何实例化InetAddress：两个方法：getByName(String host)、getLocalHost()
 *      两个常用方法：getHostname()/getHostAddress()
 *
 *
 * 7。端口号标识正在计算机上运行的进程
 *     要求： 不同的进程有不同的端口号
 *       规定为一个16位的整数 0～65535
 *
 * 8。端口号与IP地址的组合得出一个网络套接字：Socket
 *
 * @author yuqiCao
 * @create 2021-03-20 4:16 下午
 */
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);


            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
