package streams;
// streams/SelectElement.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 17:57
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.*;
import java.util.stream.*;

import static streams.RandInts.*;

/**
 * findFirst()：返回一个含有第一个流元素的 Optional，如果流为空返回 Optional.empty。 findAny(：返回含有任意流元素的 Optional，如果流为空返回
 * Optional.empty。
 */
public class SelectElement {

  public static void main(String[] args) {
    System.out.println(rands().findFirst().getAsInt());
    System.out.println(rands().parallel().findFirst().getAsInt());
    System.out.println(rands().findAny().getAsInt());
    System.out.println(rands().parallel().findAny().getAsInt());
  }
  /**
   * findFirst() 无论流是否为并行化的，总是会选择流中的第一个元素。对于非并行流，findAny()会选择流中的第一个元素（即使从定义上来看是选择任意元素）。在这个例子中，我们使用 parallel() 来并行流从而引入 findAny() 选择非第一个流元素的可能性。
   */
}
