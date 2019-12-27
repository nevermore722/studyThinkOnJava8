package streams;
// streams/ForEach.java

import java.util.*;
import java.util.stream.*;

import static streams.RandInts.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 15:19
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * forEach(Consumer)：你已经看到过很多次 System.out::println 作为 Consumer 函数。
 * forEachOrdered(Consumer)： 保证 forEach 按照原始流顺序操作。
 * 第一种形式：显式设计为任意顺序操作元素，仅在引入 parallel() 操作时才有意义。在 并发编程 章节之前我们不会深入研究这个问题。这里简单介绍下 parallel()：可实现多处理器并行操作。实现原理为将流分割为多个（通常数目为 CPU 核心数）并在不同处理器上分别执行操作。因为我们采用的是内部迭代，而不是外部迭代，所以这是可能实现的。
 *
 * parallel() 看似简单，实则棘手。更多内容将在稍后的 并发编程 章节中学习。
 *
 * 下例引入了 parallel() 来帮助理解 forEachOrdered(Consumer) 的作用和使用场景。代码示例：
 */
public class ForEach {

  static final int SZ = 14;

  public static void main(String[] args) {
    rands().limit(SZ)
        .forEach(n -> System.out.printf("%d ", n));
    System.out.println();
    rands().limit(SZ)
        .parallel()
        .forEach(n -> System.out.printf("%d ", n));
    System.out.println();
    rands().limit(SZ)
        .parallel()
        .forEachOrdered(n -> System.out.printf("%d ", n));
  }
  /**
   * 为了方便测试不同大小的数组，我们抽离出了 SZ 变量。结果很有趣：在第一个流中，未使用 parallel() ，所以 rands() 按照元素迭代出现的顺序显示结果；在第二个流中，引入parallel() ，即便流很小，输出的结果顺序也和前面不一样。这是由于多处理器并行操作的原因。多次运行测试，结果均不同。多处理器并行操作带来的非确定性因素造成了这样的结果。
   *
   * 在最后一个流中，同时使用了 parallel() 和 forEachOrdered() 来强制保持原始流顺序。因此，对非并行流使用 forEachOrdered() 是没有任何影响的。
   */
}
