package streams;

import java.util.Optional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 16:45
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/CreatingOptionals.java

/**
 * 当我们在自己的代码中加入 Optional 时，可以使用下面 3 个静态方法：
 *
 * empty()：生成一个空 Optional。
 * of(value)：将一个非空值包装到 Optional 里。
 * ofNullable(value)：针对一个可能为空的值，为空时自动生成 Optional.empty，否则将值包装在 Optional 中。
 * 下面来看看它是如何工作的。代码示例：
 *
 * 我们不能通过传递 null 到 of() 来创建 Optional 对象。最安全的方法是， 使用 ofNullable() 来优雅地处理 null。
 */
public class CreatingOptionals {

  static void test(String testName, Optional<String> opt) {
    System.out.println(" === " + testName + " === ");
    System.out.println(opt.orElse("Null"));
  }

  public static void main(String[] args) {
    test("empty", Optional.empty());
    test("of", Optional.of("Howdy"));
    try {
      test("of", Optional.of(null));
    } catch (Exception e) {
      System.out.println(e);
    }
    test("ofNullable", Optional.ofNullable("Hi"));
    test("ofNullable", Optional.ofNullable(null));
  }

}
