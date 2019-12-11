package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 15:02
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.Arrays;

/**
 * stream() 同样可以产生 IntStream，LongStream 和 DoubleStream。
 *
 * 最后一次 stream() 的调用有两个额外的参数。第一个参数告诉 stream() 从数组的哪个位置开始选择元素，第二个参数用于告知在哪里停止。每种不同类型的 stream() 都有类似的操作。
 */
public class ArrayStreams {

  public static void main(String[] args) {
    Arrays.stream(new double[]{3.14159, 2.718, 1.618})
        .forEach(n -> System.out.format("%f", n));
    System.out.println();

    Arrays.stream(new int[]{1, 3, 5})
        .forEach(n -> System.out.format("%d", n));
    System.out.println();

    Arrays.stream(new long[]{11, 22, 44, 66})
        .forEach(n -> System.out.format("%d", n));
    System.out.println();

    //选择一个子域
    Arrays.stream(new int[]{1, 3, 5, 7, 15, 28, 37}, 3, 6)
        .forEach(n -> System.out.format("%d", n));
  }

}
