package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 17:09
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * Optional 的 flatMap() 应用于已生成 Optional 的映射函数，所以 flatMap() 不会像 map() 那样将结果封装在 Optional 中。代码示例：
 *
 * 同 map()，flatMap() 将提取非空 Optional 的内容并将其应用在映射函数。唯一的区别就是 flatMap() 不会把结果包装在 Optional 中，因为映射函数已经被包装过了。在如上示例中，我们已经在每一个映射函数中显式地完成了包装，但是很显然 Optional.flatMap() 是为那些自己已经生成 Optional 的函数而设计的。
 */
public class OptionalFlatMap {

  static String[] elements = {"12", "", "23", "45"};

  static Stream<String> testStream() {
    return Arrays.stream(elements);
  }

  static void test(String descr, Function<String, Optional<String>> func) {
    System.out.println(" ---( " + descr + " )---");
    for (int i = 0; i <= elements.length; i++) {
      System.out.println(
          testStream()
              .skip(i)
              .findFirst()
              .flatMap(func)
      );
    }
  }

  public static void main(String[] args) {
    test("Add brackets", s -> Optional.of("[" + s + "]"));
    test("Increment", s -> {
      try {
        return Optional.of(
            Integer.parseInt(s) + 1 + ""
        );
      } catch (NumberFormatException e) {
        return Optional.of(s);
      }
    });
    test("Replace", s -> Optional.of(s.replace("2", "9")));
    test("Take last digit", s -> Optional.of(s.length() > 0 ? s.charAt(s.length() - 1) + "" : s));
  }
}
