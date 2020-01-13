package exception;

// exceptions/MultiCatch2.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 14:35
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class MultiCatch2 {

  void x() throws Except1, Except2, Except3, Except4 {
  }

  void process1() {
  }

  void process2() {
  }

  /**
   * 或者以其他的组合方式：
   *
   * 这对书写更整洁的代码很有帮助。
   */
  void f() {
    try {
      x();
    } catch (Except1 | Except2 e) {
      process1();
    } catch (Except3 | Except4 e) {
      process2();
    }
  }

}
