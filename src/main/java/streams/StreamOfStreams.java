package streams;

import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 17:28
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/StreamOfStreams.java
public class StreamOfStreams {

  public static void main(String[] args) {
    Stream.of(1, 2, 3)
        .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
        .map(e -> e.getClass().getName())
        .forEach(System.out::println);
  }

}
