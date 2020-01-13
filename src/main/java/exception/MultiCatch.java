package exception;

// exceptions/MultiCatch.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 14:27
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 通过 Java 7 的多重捕获机制，你可以使用“或”将不同类型的异常组合起来，只需要一行 catch 语句：
 */
public class MultiCatch {

  void x() throws Except1, Except2, Except3, Except4 {
  }

  void process() {
  }

  void f() {
    try {
      x();
    } catch (Except1 | Except2 | Except3 | Except4 e) {
      process();
    }
  }

}
