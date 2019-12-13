package streams;

import java.util.Optional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 17:53
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/StreamOfOptionals.java

/**
 * 当我们使用这个流的时候，必须要弄清楚如何解包 Optional。代码示例：
 *
 * 在这里，我们使用 filter() 来保留那些非空 Optional，然后在 map() 中使用 get() 获取元素。由于每种情况都需要定义“空值”的含义，所以通常我们要为每个应用程序采用不同的方法。
 */
public class StreamOfOptionals {

  public static void main(String[] args) {
    Signal.stream()
        .limit(10)
        .forEach(System.out::println);
    System.out.println(" ---");
    Signal.stream()
        .limit(10)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .forEach(System.out::println);
  }

}
