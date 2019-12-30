package streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/30 11:06
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 如果必须选择流中最后一个元素，那就使用 reduce()：
 *
 * reduce() 的参数只是用最后一个元素替换了最后两个元素，最终只生成最后一个元素。如果为数字流，你必须使用相近的数字 Optional 类型（ numeric optional type），否则使用 Optional 类型，就像上例中的 Optional<String>。
 */
public class LastElement {

  public static void main(String[] args) {
    OptionalInt last = IntStream.range(10, 20)
        .reduce((n1, n2) -> n2);
    System.out.println(last.orElse(-1));
    // Non-numeric object
    Optional<String> lastobj = Stream.of("one", "two", "three")
        .reduce((n1, n2) -> n2);
    System.out.println(lastobj.orElse("Nothing there!"));
  }

}
