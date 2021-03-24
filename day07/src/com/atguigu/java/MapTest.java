package com.atguigu.java;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

/**
 * 一、Map的实现类的框架：
 * ----Map:双列数据，存储key-value对的数据 --类似于高中的函数：y = f(x)
 *         ---HashMap:作为Map的主要实现类；线程不安全，效率高；存储null的key和value
 *              --LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                  原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                  对于频繁的遍历操作，此类执行效率高于HashMap。
 *         ---TreeMap:保证按照的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。
 *                    底层使用红黑树
 *         ---Hashtable:作为古老实现类；线程安全，效率低；不能存储null的key和value
 *             --Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 * HashMap的底层：数组+链表（jdk7及之前）
 *              数组+链表+红黑树（jdk8）
 *
 * 面试题：
 * 1.HashMap的底层实现原理
 *
 * 2.HashMap和Hashtable的异同？
 *
 *
 * 3.CurrentHashMap 与 Hashtable的异同
 *
 *
 * 二、Map结构的理解：
 * Map中的key：无序的、不可重复的，使用set存储所有的key  ---->key所在的类要重写equals()和hashCode()（以HashMap为例）
 * Map中的value：无序的、可重复的，使用Collection存储所有的value存储所有的value ---value所在类要重写equals
 * 一个键值对：key-value构成了一个Entry对象。
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *
 * 三、HashMap的底层实现原理，以jdk7为例
 * HashMap map = new HashMap();//在实例化以后，底层创建了长度是16的一维数组Entry[] table.
 * ..可能已经执行多次put..
 * map.put(key1,value1):
 * 首先调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 * 如果此位置上的数据为空，此时的key1-value1添加成功。----情况1
 * 如果此位置上的数据不为空，（意味着此位置存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多
 * 个数据的哈希值：
 *              如果key1的哈希值与已经存在的数据的哈希值都不同，此时的key1-value1添加成功。---情况2
 *              如果key1的哈希值和已经存在的某一个数据（key2-value2）的哈希值相同，继续比较：调用key1所在类的
 *              equals(key2)
 *                     如果equals()返回false：此时的key1-value1添加成功。---情况3
 *                     如果equals()返回true：此时的key1-value1添加失败。
 *
 *
 * 补充：关于情况2和情况3：此时的key1-value1和原来的数据以链表的方式存储。
 * 在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原来的数据复制过来。
 *
 *
 * jdk8 相较于jdk7在底层实现方面的不同：
 * 1.new HashMap():在底层没有创建一个长度为16的数组
 * 2。jdk8底层的数组是：Node[] ,而非Entry[]
 * 3.首次调用put()方法时，底层创建长度为16的数组
 * 4。jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数 >8 且当前数组的长度 >64时，
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 *
 *
 *
 *五、Map中的常用方法：
 * 添加：put(Object key,Object value)
 * 删除：remove(Object key)
 * 修改：put(Object key,Object value)
 * 查询：get(Object key)
 * 长度：size()
 * 遍历：KeySet()/values()/entrySet()
 *
 *
 *
 *
 * @author yuqiCao
 * @create 2021-03-15 8:23 下午
 */
public class MapTest {

    @Test
    public void test1(){
        Map map = new Hashtable();

        map.put(null,null);

    }
}
