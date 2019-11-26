package functional;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/26 18:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/FunctionWithWrapped.java

/**
 * 上例简单使用了包装类型，装箱和拆箱用于在基本类型之间来回转换。 我们也可以使用包装类型，如 Function，而不是预定义的基本类型。代码示例：
 * <p>
 * 如果没有强制转换，则会收到错误消息：“Integer cannot be converted to Double”（Integer 无法转换为 Double），而使用 IntToDoubleFunction 就没有此类问题。 IntToDoubleFunction 接口的源代码是这样的：
 *
 * @FunctionalInterface public interface IntToDoubleFunction {
 * double applyAsDouble(int value);
 * }
 * 之所以我们可以简单地编写 Function <Integer，Double> 并返回合适的结果，很明显是为了性能。使用基本类型可以防止传递参数和返回结果过程中的自动装箱和自动拆箱。
 * <p>
 * 似乎是考虑到使用频率，某些函数类型并没有预定义。
 * <p>
 * 当然，如果因缺少基本类型而造成的性能问题，你也可以轻松编写自己的接口（ 参考 Java 源代码）——尽管这里出现性能瓶颈的可能性不大。
 */
public class FunctionWithWrapped {
    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double) i;
        IntToDoubleFunction fid2 = i -> i;
    }
}
