package streams;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 16:50
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/OptionalFilter.java

/**
 * 当我们的流管道生成了 Optional 对象，下面 3 个方法可使得 Optional 的后续能做更多的操作：
 *
 * filter(Predicate)：将 Predicate 应用于 Optional 中的内容并返回结果。当 Optional 不满足 Predicate 时返回空。如果 Optional
 * 为空，则直接返回。
 *
 * map(Function)：如果 Optional 不为空，应用 Function 于 Optional 中的内容，并返回结果。否则直接返回 Optional.empty。
 *
 * flatMap(Function)：同 map()，但是提供的映射函数将结果包装在 Optional 对象中，因此 flatMap() 不会在最后进行任何包装。
 *
 * 以上方法都不适用于数值型 Optional。一般来说，流的 filter() 会在 Predicate 返回 false 时移除流元素。而 Optional.filter() 在失败时不会删除
 * Optional，而是将其保留下来，并转化为空。下面请看代码示例：
 *
 *
 * 即使输出看起来像流，特别是 test() 中的 for 循环。每一次的 for 循环时重新启动流，然后根据 for 循环的索引跳过指定个数的元素，这就是它最终在流中的每个连续元素上的结果。接下来调用
 * findFirst() 获取剩余元素中的第一个元素，结果会包装在 Optional 中。
 */
public class OptionalFilter {

  static String[] elements = {
      "Foo", "", "Bar", "Baz", "Bingo"
  };

  static Stream<String> testStream() {
    return Arrays.stream(elements);
  }

  static void test(String descr, Predicate<String> pred) {
    System.out.println(" ---( " + descr + " )---");
    for (int i = 0; i <= elements.length; i++) {
      System.out.println(
          testStream()
              .skip(i)
              .findFirst()
              .filter(pred)
      );
    }
  }

  public static void main(String[] args) {
    test("true", str -> true);
    test("false", str -> false);
    test("str != \"\"", str -> str.length() == 3);
    test("startsWith(\"B\")", str -> str.startsWith("B"));
  }

}
