package streams;

import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 17:14
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/FunctionMap3.java
// Producing numeric output streams（ 产生数值输出流）

/**
 * 如果使用 Function 返回的结果是数值类型的一种，我们必须使用合适的 mapTo数值类型 进行替代。代码示例：
 *
 * 遗憾的是，Java 设计者并没有尽最大努力去消除基本类型。
 */
public class FunctionMap3 {

  public static void main(String[] args) {
    Stream.of("5", "7", "9")
        .mapToInt(Integer::parseInt)
        .forEach(n -> System.out.format("%d ", n));
    System.out.println();
    Stream.of("17", "19", "23")
        .mapToLong(Long::parseLong)
        .forEach(n -> System.out.format("%d ", n));
    System.out.println();
    Stream.of("17", "1.9", ".23")
        .mapToDouble(Double::parseDouble)
        .forEach(n -> System.out.format("%f ", n));
  }

}
