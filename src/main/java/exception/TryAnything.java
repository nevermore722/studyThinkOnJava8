package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 14:22
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/TryAnything.java
// {WillNotCompile}

/**
 * 假设我们在资源规范头中定义了一个不是 AutoCloseable 的对象
 */
class Anything {

}

public class TryAnything {

  /**
   * 正如我们所希望和期望的那样，Java 不会让我们这样做，并且出现编译时错误。
   */
//  public static void main(String[] args) {
//    try (
//        Anything a = new Anything()
//    ) {
//
//    }
//  }
}
