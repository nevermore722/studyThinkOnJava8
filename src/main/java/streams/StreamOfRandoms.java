package streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 17:34
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/StreamOfRandoms.java

/**
 * 下面是另一个演示，我们从一个整数流开始，然后使用每一个整数去创建更多的随机数。
 *
 * 在这里我们引入了 concat()，它以参数顺序组合两个流。 如此，我们在每个随机 Integer 流的末尾添加一个 -1 作为标记。你可以看到最终流确实是从一组扁平流中创建的。
 *
 * 因为 rand.ints() 产生的是一个 IntStream，所以我必须使用 flatMap()、concat() 和 of() 的特定整数形式。
 *
 * 让我们再看一下将文件划分为单词流的任务。我们最后使用到的是 FileToWordsRegexp.java，它的问题是需要将整个文件读入行列表中 —— 显然需要存储该列表。而我们真正想要的是创建一个不需要中间存储层的单词流。
 */
public class StreamOfRandoms {

  static Random rand = new Random(47);

  public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5)
        .flatMapToInt(i -> IntStream.concat(
            rand.ints(0, 100).limit(i),
                IntStream.of(-1)))
            .forEach(n -> System.out.format("%d ", n));
  }

}
