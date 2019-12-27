package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 17:29
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Matching.java
// Demonstrates short-circuiting of *Match() operations

import java.util.stream.*;
import java.util.function.*;

import static streams.RandInts.*;

/**
 * allMatch(Predicate) ：如果流的每个元素根据提供的 Predicate 都返回 true 时，结果返回为 true。这个操作将会在第一个 false 之后短路；也就是不会在发生
 * false 之后继续执行计算。 anyMatch(Predicate)：如果流中的任意一个元素根据提供的 Predicate 返回 true 时，结果返回为 true。这个操作将会在第一个
 * true 之后短路；也就是不会在发生 true 之后继续执行计算。 noneMatch(Predicate)：如果流的每个元素根据提供的 Predicate 都返回 false 时，结果返回为
 * true。这个操作将会在第一个 true 之后短路；也就是不会在发生 true 之后继续执行计算。 你已经在 Prime.java 中看到了 noneMatch() 的示例；
 * allMatch() 和 anyMatch() 的用法基本上是等同的。让我们探究短路行为。为了创建消除冗余代码的 show() 方法，我们必须首先发现如何统一地描述所有三个匹配器操作，然后将其转换为称作
 * Matcher 的接口：
 */

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {

}

public class Matching {

  static void show(Matcher match, int val) {
    System.out.println(
        match.test(
            IntStream.rangeClosed(1, 9)
                .boxed()
                .peek(n -> System.out.format("%d ", n)),
            n -> n < val));
  }

  public static void main(String[] args) {
    show(Stream::allMatch, 10);
    show(Stream::allMatch, 4);
    show(Stream::anyMatch, 2);
    show(Stream::anyMatch, 0);
    show(Stream::noneMatch, 5);
    show(Stream::noneMatch, 0);
  }
  /**
   * BiPredicate 是一个二元谓词，这意味着它只能接受两个参数并且只返回 true 或者 false。它的第一个参数是我们要测试的流，第二个参数是一个谓词 Predicate。因为 Matcher 适用于所有的 *Stream::Match 方法形式，所以我们可以传递每一个到 show() 中。match.test() 的调用会被转换成 *Stream::Match 函数的调用。
   *
   * show() 获取两个参数，Matcher 匹配器和用于表示谓词测试 n < val 中最大值的 val。这个方法生成一个从 1 到 9 的整数流。peek() 是用于向我们展示测试在短路之前的情况。你可以在输出中发现每一次短路都会发生。
   */
}
