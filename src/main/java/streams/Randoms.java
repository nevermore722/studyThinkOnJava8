package streams;

import java.util.Random;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/10/22 16:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Randoms.java
public class Randoms {


    /**
     * 流是一系列与特定存储机制无关的元素——实际上，流并没有“存储”之说。
     *
     * 利用流，我们无需迭代集合中的元素，就可以提取和操作它们。这些管道通常被组合在一起，在流上形成一条操作管道。
     *
     * 在大多数情况下，将对象存储在集合中是为了处理他们，因此你将会发现你将把编程的主要焦点从集合转移到了流上。流的一个核心好处是，它使得程序更加短小并且更易理解。当 Lambda 表达式和方法引用（method references）和流一起使用的时候会让人感觉自成一体。流使得 Java 8 更具吸引力。
     *
     * 举个例子，假如你要随机展示 5 至 20 之间不重复的整数并进行排序。实际上，你的关注点首先是创建一个有序集合。围绕这个集合进行后续的操作。但是使用流式编程，你就可以简单陈述你想做什么
     * @param args
     */
    public static void main(String[] args) {
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }
}
