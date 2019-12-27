package streams;

// streams/Reduce.java
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 16:34
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.Random;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * reduce(BinaryOperator)：使用 BinaryOperator 来组合所有流中的元素。因为流可能为空，其返回值为 Optional。 reduce(identity,
 * BinaryOperator)：功能同上，但是使用 identity 作为其组合的初始值。因此如果流为空，identity 就是结果。 reduce(identity, BiFunction,
 * BinaryOperator)：这个形式更为复杂（所以我们不会介绍它），在这里被提到是因为它使用起来会更有效。通常，你可以显式地组合 map() 和 reduce() 来更简单的表达它。
 * 如下是一个用于演示 reduce() 的示例：
 */
@AllArgsConstructor
@ToString
class Frobnitz {

  int size;

  // Generator:
  static Random rand = new Random(47);
  static final int BOUND = 100;

  static Frobnitz supply() {
    return new Frobnitz(rand.nextInt(BOUND));
  }

}

public class Reduce {

  public static void main(String[] args) {
    Stream.generate(Frobnitz::supply)
        .limit(10)
        .peek(System.out::println)
        .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
        .ifPresent(System.out::println);
  }
  /**
   * Frobnitz 包含了一个名为 supply() 的生成器；因为这个方法对于 Supplier<Frobnitz> 是签名兼容的，我们可以将其方法引用传递给 Stream.generate()（这种签名兼容性被称作结构一致性）。我们使用没有给“起始值”的 reduce()方法，这意味着它的返回值是 Optional 类型的。Optional.ifPresent() 只有在结果非空的时候才会调用 Consumer<Frobnitz> （println 方法可以被调用是因为 Frobnitz 可以通过 toString() 方法转换成 String）。
   *
   * Lambda 表达式中的第一个参数 fr0 是上一次调用 reduce() 的结果。而第二个参数 fr1 是从流传递过来的值。
   *
   * reduce() 中的 Lambda 表达式使用了三元表达式来获取结果，当其 size 小于 50 的时候获取 fr0 否则获取序列中的下一个值 fr1。因此你会取得第一个 size 小于 50 的 Frobnitz，只要找到了就这个结果就会紧紧地攥住它，即使有其他候选者出现。虽然这是一个非常奇怪的约束，但是它确实让你对 reduce() 有了更多的了解。
   */
}
