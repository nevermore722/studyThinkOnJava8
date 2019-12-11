package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 14:54
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Machine2.java

import java.util.Arrays;
import onjava.Operations;

/**
 * Arrays 类中含有一个名为 stream() 的静态方法用于把数组转换成为流。我们可以重写 interfaces/Machine.java 中的主方法用于创建一个流，并将 execute()
 * 应用于每一个元素。代码示例：
 *
 * new Operations[] 表达式动态创建了 Operations 对象的数组。
 */
public class Machine2 {

  public static void main(String[] args) {
    Arrays.stream(new Operations[]{
        () -> Operations.show("Bing"),
        () -> Operations.show("Crack"),
        () -> Operations.show("Twist"),
        () -> Operations.show("Pop")
    }).forEach(Operations::execute);
  }

}
