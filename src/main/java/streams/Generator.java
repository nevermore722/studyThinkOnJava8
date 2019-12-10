package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 19:38
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Generator.java

/**
 * 参照 RandomWords.java 中 Stream.generate() 搭配 Supplier<T> 使用的例子。代码示例：
 *
 * 使用 Random.nextInt() 方法来挑选字母表中的大写字母。Random.nextInt() 的参数代表可以接受的最大的随机数范围，所以使用数组边界是经过深思熟虑的。
 */
public class Generator implements Supplier<String> {

  Random rand = new Random(47);
  char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  @Override
  public String get() {
    return "" + letters[rand.nextInt(letters.length)];
  }

  public static void main(String[] args) {
    String word = Stream.generate(new Generator())
        .limit(30)
        .collect(Collectors.joining());
    System.out.println(word);
  }
}
