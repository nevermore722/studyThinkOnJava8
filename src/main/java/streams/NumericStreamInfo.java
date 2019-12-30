package streams;


import static streams.RandInts.*;
// streams/NumericStreamInfo.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/30 18:00
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * average() ：求取流元素平均值。
 * max() 和 min()：因为这些操作在数字流上面，所以不需要 Comparator。
 * sum()：对所有流元素进行求和。
 * summaryStatistics()：生成可能有用的数据。目前还不太清楚他们为什么觉得有必要这样做，因为你可以使用直接的方法产生所有的数据。
 * 这些操作对于 LongStream 和 DoubleStream 也同样适用。
 */
public class NumericStreamInfo {

  public static void main(String[] args) {
    System.out.println(rands().average().getAsDouble());
    System.out.println(rands().max().getAsInt());
    System.out.println(rands().min().getAsInt());
    System.out.println(rands().sum());
    System.out.println(rands().summaryStatistics());
  }

}
