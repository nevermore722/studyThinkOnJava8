package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 16:57
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/OptionalMap.java

/**
 * 同 map() 一样 ， Optional.map() 应用于函数。它仅在 Optional 不为空时才应用映射函数，并将 Optional 的内容提取到映射函数。代码示例：
 */
public class OptionalMap {

  static String[] elements = {"12", "", "23", "45"};

  static Stream<String> testStream() {
    return Arrays.stream(elements);
  }

  static void test(String descr, Function<String, String> func) {
    System.out.println(" ---( " + descr + " )---");
    for (int i = 0; i <= elements.length; i++) {
      System.out.println(
          testStream()
              .skip(i)
              .findFirst()// Produces an Optional
              .map(func)
      );
    }
  }

  public static void main(String[] args) {
    // If Optional is not empty, map() first extracts
    // the contents which it then passes
    // to the function:
    test("Add brackets", s -> "[" + s + "]");
    test("Increment", s -> {
      try {
        return Integer.parseInt(s) + 1 + "";
      } catch (NumberFormatException e) {
        return s;
      }
    });
    test("Replace", s -> s.replace("2", "9"));
    test("Take last digit", s -> s.length() > 0 ? s.charAt(s.length() - 1) + "" : s);
  }
  // After the function is finished, map() wraps the
  // result in an Optional before returning it:
}
