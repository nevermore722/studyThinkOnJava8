package streams;

import java.util.*;
import java.util.stream.*;
// streams/RandInts.java
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 15:11
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * toArray()：将流转换成适当类型的数组。 toArray(generator)：在特殊情况下，生成器用于分配自定义的数组存储。
 * 这组方法在流操作产生的结果必须是数组形式时很有用。假如我们想在流里复用获取的随机数，可以将他们保存到数组中。代码示例:
 */
public class RandInts {

  private static int[] rints = new Random(47).ints(0, 1000).limit(100).toArray();

  public static IntStream rands() {
    return Arrays.stream(rints);
  }
  /**
   * 上例将100个数值范围在 0 到 1000 之间的随机数流转换成为数组并将其存储在 rints 中，在每次调用 rands() 的时候可以重复获取相同的流。
   */
}
