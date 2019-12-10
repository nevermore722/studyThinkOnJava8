package streams;

import java.util.stream.*;
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 19:53
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Duplicator.java

/**
 * 如果要创建包含相同对象的流，只需要传递一个生成那些对象的 lambda 到 generate() 中：
 */
public class Duplicator {

  public static void main(String[] args) {
    Stream.generate(()->"duplicate")
        .limit(3)
        .forEach(System.out::println);
  }
}
