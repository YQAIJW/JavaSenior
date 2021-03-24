import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * RandomAccessFile的使用
 * 1。RandomAccessFile直接继承java.lang.Object类，实现了DataInput和DataOutput接口
 * 2。RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.RandomAccessFile如果作为一个输出流，写出到的文件如果不存在，则在执行过程中自动创建，
 * 如果写出到的文件存在，则会对原有的文件内容进行覆盖。（默认情况从头覆盖）
 *
 * 4.通过相关操作，可以实现RandomAccessFile"插入"数据的效果
 *
 * @author yuqiCao
 * @create 2021-03-20 2:14 下午
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("截屏.png"),"r");
            raf2 = new RandomAccessFile(new File("截屏1.png"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

        raf1.seek(3);//将指针插到角标为3的位置

        raf1.write("xyz".getBytes());

        raf1.close();
    }

    /*
    使用RandomAccessFile实现插入功能效果
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");

        raf1.seek(3);//将指针插到角标为3的位置
        //保存指针3后面所有的数据到StringBuilder
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len =raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //在将指针调回角标为3处，写入xyz
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据再写入文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

    }


}
