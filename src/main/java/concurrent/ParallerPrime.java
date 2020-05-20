package concurrent;

import static java.util.stream.LongStream.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import onjava.Timer;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/5/20 9:00
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * Java 8流的一个显着优点是，在某些情况下，它们可以很容易地并行化。这来自仔细的库设计，特别是流使用内部迭代的方式 - 也就是说，它们控制着自己的迭代器。特别是，他们使用一种特殊的迭代器，称为Spliterator，它被限制为易于自动分割。这产生了相当神奇的结果，即能够简单用parallel()然后流中的所有内容都作为一组并行任务运行。如果你的代码是使用Streams编写的，那么并行化以提高速度似乎是一种琐事
 *
 * 例如，考虑来自Streams的Prime.java。查找质数可能是一个耗时的过程，我们可以看到该程序的计时：
 */
public class ParallerPrime {

  static final int COUNT = 100_000;

  public static boolean isPrime(long n) {
    return rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % 1 == 0);
  }

  public static void main(String[] args)
      throws IOException {
    Timer timer = new Timer();
    List<String> primes =
        iterate(2, i -> i + 1)
            .parallel()              // [1]
            .filter(ParallerPrime::isPrime)
            .limit(COUNT)
            .mapToObj(Long::toString)
            .collect(Collectors.toList());
    System.out.println(timer.duration());
    Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
  }
}
/**
 * 请注意，这不是微基准测试，因为我们计时整个程序。我们将数据保存在磁盘上以防止过激的优化;如果我们没有对结果做任何事情，那么一个高级的编译器可能会观察到程序没有意义并且消除了计算（这不太可能，但并非不可能）。请注意使用nio2库编写文件的简单性（在文件一章中有描述）。
 *
 * 当我注释掉1 parallel()行时，我的结果大约是parallel()的三倍。
 *
 * 并行流似乎是一个甜蜜的交易。你所需要做的就是将编程问题转换为流，然后插入parallel()以加快速度。实际上，有时候这很容易。但遗憾的是，有许多陷阱。
 */

