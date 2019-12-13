package streams;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
import lombok.Getter;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/13 17:32
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Signal.java

/**
 * 假设你的生成器可能产生 null 值，那么当用它来创建流时，你会自然地想到用 Optional 来包装元素。如下是它的样子，代码示例：
 */
public class Signal {

  @Getter
  private final String msg;

  public Signal(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "Signal{" +
        "msg='" + msg + '\'' +
        '}';
  }

  static Random rand = new Random(47);

  public static Signal morse() {
    switch (rand.nextInt(4)) {
      case 1:
        return new Signal("dot");
      case 2:
        return new Signal("dash");
      default:
        return null;
    }
  }

  public static Stream<Optional<Signal>> stream() {
    return Stream.generate(Signal::morse)
        .map(signal -> Optional.ofNullable(signal));
  }
}
