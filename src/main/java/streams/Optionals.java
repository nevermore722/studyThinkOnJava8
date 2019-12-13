package streams;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 15:45
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Optionals.java

/**
 * 有许多便利函数可以解包 Optional ，这简化了上述“对所包含的对象的检查和执行操作”的过程：
 *
 * ifPresent(Consumer)：当值存在时调用 Consumer，否则什么也不做。
 * orElse(otherObject)：如果值存在则直接返回，否则生成 otherObject。
 * orElseGet(Supplier)：如果值存在则直接返回，否则使用 Supplier 函数生成一个可替代对象。
 * orElseThrow(Supplier)：如果值存在直接返回，否则使用 Supplier 函数生成一个异常。
 * 如下是针对不同便利函数的简单演示：
 *
 * test() 通过传入所有方法都适用的 Consumer 来避免重复代码。
 *
 * orElseThrow() 通过 catch 关键字来捕获抛出的异常。更多细节，将在 异常 这一章节中学习。
 */
public class Optionals {

  static void basics(Optional<String> optString) {
    if (optString.isPresent()) {
      System.out.println(optString.get());
    } else {
      System.out.println("Nothing inside!");
    }
  }

  static void ifPresent(Optional<String> optString) {
    optString.ifPresent(System.out::println);
  }

  static void orElse(Optional<String> optString) {
    System.out.println(optString.orElse("Nada"));
  }

  static void orElseGet(Optional<String> optString) {
    System.out.println(
        optString.orElseGet(() -> "Generated")
    );
  }

  static void orElseThrow(Optional<String> optString) {
    try {
      System.out.println(optString.orElseThrow(
          () -> new Exception("Supplied")
      ));
    } catch (Exception e) {
      System.out.println("Caught " + e);
    }
  }

  static void test(String testName,Consumer<Optional<String>> cos){
    System.out.println(" === "+testName+" === ");
    cos.accept(Stream.of("Epithets").findFirst());
    cos.accept(Stream.<String>empty().findFirst());
  }

  public static void main(String[] args) {
    test("basics",Optionals::basics);
    test("ifPresent",Optionals::ifPresent);
    test("orElse",Optionals::orElse);
    test("orElseGet",Optionals::orElseGet);
    test("orElseThrow",Optionals::orElseThrow);
  }
}
