import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/10/22 17:07
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 *首先，我们给 Random 对象一个种子（以便程序再次运行时产生相同的输出）。ints() 方法产生一个流并且 ints() 方法有多种方式的重载 — 两个参数限定了数值产生的边界。这将生成一个整数流。我们可以使用中间流操作（intermediate stream operation） distinct() 来获取它们的非重复值，然后使用 limit() 方法获取前 7 个元素。接下来，我们使用 sorted() 方法排序。最终使用 forEach() 方法遍历输出，它根据传递给它的函数对每个流对象执行操作。在这里，我们传递了一个可以在控制台显示每个元素的方法引用。System.out::println 。
 *
 * 注意 Randoms.java 中没有声明任何变量。流流可以在不使用赋值或可变数据的情况下对有状态的系统建模，这非常有用。
 *
 * 声明式编程（Declarative programming）是一种：声明要做什么，而非怎么做的编程风格。正如我们在函数式编程中所看到的。注意，命令式编程的形式更难以理解。代码示例：
 *
 */
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
/**
 * 在 Randoms.java 中，我们无需定义任何变量，但在这里我们定义了 3 个变量： rand，rints 和 r。由于 nextInt() 方法没有下限的原因（其内置的下限永远为 0），这段代码实现起来更复杂。所以我们要生成额外的值来过滤小于 5 的结果。
 *
 * 注意，你必须要研究程序的真正意图，而在 Randoms.java 中，代码只是告诉了你它正在做什么。这种语义清晰性也是 Java 8 的流式编程更受推崇的重要原因。
 *
 * 在 ImperativeRandoms.java 中显式地编写迭代机制称为外部迭代。而在 Randoms.java 中，流式编程采用内部迭代，这是流式编程的核心特性之一。这种机制使得编写的代码可读性更强，也更能利用多核处理器的优势。通过放弃对迭代过程的控制，我们把控制权交给并行化机制。我们将在并发编程一章中学习这部分内容。
 *
 * 另一个重要方面，流是懒加载的。这代表着它只在绝对必要时才计算。你可以将流看作“延迟列表”。由于计算延迟，流使我们能够表示非常大（甚至无限）的序列，而不需要考虑内存问题。
 */