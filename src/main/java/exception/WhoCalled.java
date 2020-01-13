package exception;

// exceptions/WhoCalled.java
// Programmatic access to stack trace information
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 15:12
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * printStackTrace() 方法所提供的信息可以通过 getStackTrace() 方法来直接访问，这个方法将返回一个由栈轨迹中的元素所构成的数组，其中每一个元素都表示栈中的一桢。元素
 * 0 是栈顶元素，并且是调用序列中的最后一个方法调用（这个 Throwable 被创建和抛出之处）。数组中的最后一个元素和栈底是调用序列中的第一个方法调用。下面的程序是一个简单的演示示例：
 */
public class WhoCalled {

  static void f() {
    // Generate an exception to fill in the stack trace
    try {
      throw new Exception();
    } catch (Exception e) {
      for (StackTraceElement ste : e.getStackTrace()) {
        System.out.println(ste.getMethodName());
      }
    }
  }

  static void g() {
    f();
  }

  static void h() {
    g();
  }

  public static void main(String[] args) {
    f();
    System.out.println("*******");
    g();
    System.out.println("*******");
    h();
  }
  /**
   * 这里，我们只打印了方法名，但实际上还可以打印整个 StackTraceElement，它包含其他附加的信息。
   */
}
