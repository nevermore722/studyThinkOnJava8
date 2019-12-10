package streams;

import static java.util.stream.IntStream.*;
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 16:45
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Ranges.java

/**
 * IntStream 类提供了 range() 方法用于生成整型序列的流。编写循环时，这个方法会更加便利：
 *
 * 在主方法中的第一种方式是我们传统编写 for 循环的方式；第二种方式，我们使用 range() 创建了流并将其转化为数组，然后在 for-in 代码块中使用。但是，如果你能像第三种方法那样全程使用流是更好的。我们对范围中的数字进行求和。在流中可以很方便的使用 sum() 操作求和。
 *
 * 注意 IntStream.range() 相比 onjava.Range.range() 拥有更多的限制。这是由于其可选的第三个参数，后者允许步长大于 1，并且可以从大到小来生成。
 */
public class Ranges {

  public static void main(String[] args) {
    //传统方法
    int result = 0;
    for (int i = 10; i < 20; i++) {
      result += i;
    }
    System.out.println(result);
    //for-in 循环
    result = 0;
    for (int i:range(10,20).toArray()){
      result += i;
    }
    System.out.println(result);
    // 使用流：
    System.out.println(range(10,20).sum());
  }

}
