package functional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/4 16:34
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/CurriedIntAdd.java

/**
 * 处理基本类型和装箱时，请使用适当的 Function 接口
 *
 * 可以在互联网上找到更多的柯里化示例。通常它们是用 Java 之外的语言实现的，但如果理解了柯里化的基本概念，你可以很轻松地用 Java 实现它们。
 */
public class CurriedIntAdd {

  public static void main(String[] args) {
    IntFunction<IntUnaryOperator> curriedIntAdd = a -> b -> a + b;
    IntUnaryOperator add4 = curriedIntAdd.apply(4);
    System.out.println(add4.applyAsInt(5));
  }

}
