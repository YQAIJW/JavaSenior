package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 测试InputStream和OutputStream的使用
 *
 * 结论：
 * 1。对于文本文件(.txt,.java,.c,.cpp)使用字符流处理
 * 2。对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)，使用字节流处理
 * @author yuqiCao
 * @create 2021-03-19 12:33 下午
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件可能出现乱码的
    @Test
    public void testFileInputStream()  {
        FileInputStream fis = null;

        try {
            //1.造文件
            File file = new File("hello.txt");

            //2。造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取字节的个数
            while ((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    //实现对图片的复制
    @Test
    public void testFileInputOutputStream() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //
            File srcFile = new File("截屏.png");
            File destFile = new File("截屏2.png");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //指定路径下的文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void testCopyFile(){
        long start =System.currentTimeMillis();

        String srcPath = "/Users/tom/Desktop/01.mkv";
        String destPath = "/Users/tom/Desktop/02.mkv";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";


        copyFile(srcPath,destPath);

        long end =System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//14328

    }

}
