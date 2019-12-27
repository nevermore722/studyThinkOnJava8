package streams;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 15:40
 * @description：
 * @modified By：
 * @version: 1.0
 */

class Pair {

  public final Character c;
  public final Integer i;

  Pair(Character c, Integer i) {
    this.c = c;
    this.i = i;
  }

  public Character getC() {
    return c;
  }

  public Integer getI() {
    return i;
  }

  @Override
  public String toString() {
    return "Pair{" +
        "c=" + c +
        ", i=" + i +
        '}';
  }
}

class RandomPair {

  Random rand = new Random(47);
  // An infinite iterator of random capital letters:
  Iterator<Character> capChars = rand.ints(65, 91)
      .mapToObj(i -> (char) i)
      .iterator();

  public Stream<Pair> stream() {
    return rand.ints(100, 1000).distinct()
        .mapToObj(i -> new Pair(capChars.next(), i));
  }
}

public class MapCollector {

  public static void main(String[] args) {
    Map<Integer, Character> map =
        new RandomPair().stream()
            .limit(8)
            .collect(
                Collectors.toMap(Pair::getI, Pair::getC));
    System.out.println(map);
  }
  /**
   * Pair 只是一个基础的数据对象。RandomPair 创建了随机生成的 Pair 对象流。在 Java 中，我们不能直接以某种方式组合两个流。所以这里创建了一个整数流，并且使用 mapToObj() 将其转化成为 Pair 流。 capChars 随机生成的大写字母迭代器从流开始，然后 iterator() 允许我们在 stream() 中使用它。就我所知，这是组合多个流以生成新的对象流的唯一方法。
   *
   * 在这里，我们只使用最简单形式的 Collectors.toMap()，这个方法值需要一个可以从流中获取键值对的函数。还有其他重载形式，其中一种形式是在遇到键值冲突时，需要一个函数来处理这种情况。
   */
}
