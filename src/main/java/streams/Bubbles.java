package streams;
import java.util.stream.*;
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 20:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Bubbles.java

/**
 * 由于 bubbler() 与 Supplier<Bubble> 是接口兼容的，我们可以将其方法引用直接传递给 Stream.generate()：
 *
 * 这是创建单独工厂类（Separate Factory class）的另一种方式。在很多方面它更加整洁，但是这是一个对于代码组织和品味的问题——你总是可以创建一个完全不同的工厂类。
 */
public class Bubbles {

  public static void main(String[] args) {
    Stream.generate(Bubble::bubbler)
        .limit(5)
        .forEach(System.out::println);
  }

}
