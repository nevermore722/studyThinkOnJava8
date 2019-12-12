package streams;

import java.util.stream.*;

import static java.util.stream.LongStream.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 18:11
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * distinct()：在 Randoms.java 类中的 distinct() 可用于消除流中的重复元素。相比创建一个 Set 集合，该方法的工作量要少得多。
 *
 * filter(Predicate)：过滤操作会保留与传递进去的过滤器函数计算结果为 true 元素。
 *
 * 在下例中，isPrime() 作为过滤器函数，用于检测质数。
 *
 * rangeClosed() 包含了上限值。如果不能整除，即余数不等于 0，则 noneMatch() 操作返回 true，如果出现任何等于 0 的结果则返回 false。 noneMatch() 操作一旦有失败就会退出。
 */
public class Prime {

  public static Boolean isPrime(long n) {
    return rangeClosed(2, (long) Math.sqrt(n))
        .noneMatch(i -> n % i == 0);
  }

  public LongStream numbers() {
    return iterate(2, i -> i + 1)
        .filter(Prime::isPrime);
  }

  public static void main(String[] args) {
    new Prime().numbers()
        .limit(10)
        .forEach(n -> System.out.format("%d ", n));
    System.out.println();
    new Prime().numbers()
        .skip(90)
        .limit(10)
        .forEach(n -> System.out.format("%d ", n));
  }
}
