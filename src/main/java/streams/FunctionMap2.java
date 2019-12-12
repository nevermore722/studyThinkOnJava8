package streams;

import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 16:53
 * @description：
 * @modified By：
 * @version: 1.0
 */

class Numbered {

  final int n;

  Numbered(int n) {
    this.n = n;
  }

  @Override
  public String toString() {
    return "Numbered(" + n + ")";
  }
}

public class FunctionMap2 {

  public static void main(String[] args) {
    Stream.of(1, 5, 7, 9, 11, 13)
        .map(Numbered::new)
        .forEach(System.out::println);
  }

}
