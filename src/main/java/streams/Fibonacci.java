package streams;

import java.util.stream.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 11:12
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Fibonacci.java

/**
 * Stream.iterate() 以种子（第一个参数）开头，并将其传给方法（第二个参数）。方法的结果将添加到流，并存储作为第一个参数用于下次调用 iterate()，依次类推。我们可以利用 iterate() 生成一个斐波那契数列。代码示例：
 *
 * 斐波那契数列将数列中最后两个元素进行求和以产生下一个元素。iterate() 只能记忆结果，因此我们需要利用一个变量 x 追踪另外一个元素。
 *
 * 在主方法中，我们使用了一个之前没有见过的 skip() 操作。它根据参数丢弃指定数量的流元素。在这里，我们丢弃了前 20 个元素。
 */
public class Fibonacci {

  int x = 1;

  Stream<Integer> numbers() {
    return Stream.iterate(0, i -> {
      int result = x + i;
      x = i;
      return result;
    });
  }

  public static void main(String[] args) {
    new Fibonacci().numbers()
        .skip(20)       // 过滤前20个
        .limit(10)      // 然后取10个
        .forEach(System.out::println);
  }

}
