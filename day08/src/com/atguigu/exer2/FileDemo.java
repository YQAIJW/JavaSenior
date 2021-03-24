package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author yuqiCao
 * @create 2021-03-18 7:58 下午
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {

        File file = new File("/Users/tom/Downloads/IO/hello.txt");
        //创建一个与file同目录下的另一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile){
            System.out.println("创建成功！");
        }
    }
}
