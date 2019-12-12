package streams;

import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 17:32
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/FlatMap.java

/**
 * 我们天真地希望能够得到字符串流，但实际得到的却是“Head”流的流。我们可以使用 flatMap() 解决这个问题：
 *
 * 从映射返回的每个流都会自动扁平为组成它的字符串。
 */
public class FlatMap {

  public static void main(String[] args) {
    Stream.of(1, 2, 3)
        .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
        .forEach(System.out::println);
  }
}
