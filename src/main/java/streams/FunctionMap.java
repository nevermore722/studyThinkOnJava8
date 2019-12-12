package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 15:54
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/FunctionMap.java

public class FunctionMap {

  static String[] elements = {"12", "", "23", "45"};

  static Stream<String>
  testStream() {
    return Arrays.stream(elements);
  }

  static void test(String descr, Function<String, String> func) {
    System.out.println(" ---(" + descr + ")---");
    testStream()
        .map(func)
        .forEach(System.out::println);
  }

  public static void main(String[] args) {
    test("add brackets", s -> "[" + s + "]");
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
}
