package streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 15:40
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 这个示例展示了 Optional 的两个基本用法：
 *
 * 当你接收到 Optional 对象时，应首先调用 isPresent() 检查其中是否包含元素。如果存在，可使用 get() 获取。
 */
public class OptionalBasics {

  static void test(Optional<String> optString) {
    if (optString.isPresent()) {
      System.out.println(optString.get());
    } else {
      System.out.println("Nothing inside!");
    }
  }

  public static void main(String[] args) {
    test(Stream.of("Epithets").findFirst());
    test(Stream.<String>empty().findFirst());
  }

}
