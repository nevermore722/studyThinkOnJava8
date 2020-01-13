package exception;

// exceptions/Rethrowing.java
// Demonstrating fillInStackTrace()
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 15:17
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 重抛异常会把异常抛给上一级环境中的异常处理程序，同一个 try 块的后续 catch 子句将被忽略。此外，异常对象的所有信息都得以保持，所以高一级环境中捕获此异常的处理程序可以从这个异常对象中得到所有信息。
 *
 * 如果只是把当前异常对象重新抛出，那么 printStackTrace() 方法显示的将是原来异常抛出点的调用栈信息，而并非重新抛出点的信息。要想更新这个信息，可以调用
 * filInStackTrace() 方法，这将返回一个 Throwable 对象，它是通过把当前调用栈信息填入原来那个异常对象而建立的，就像这样：
 */
public class Rethrowing {

  public static void f() throws Exception {
    System.out.println("originating the exception in f()");
    throw new Exception("thrown from f()");
  }

  public static void g() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Inside g(),e.printStackTrace()");
      e.printStackTrace(System.out);
      throw e;
    }
  }

  public static void h() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Inside h(),e.printStackTrace()");
      e.printStackTrace(System.out);
      throw (Exception) e.fillInStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      g();
    } catch (Exception e) {
      System.out.println("main:printStackTrace()");
      e.printStackTrace(System.out);
    }

    try {
      h();
    } catch (Exception e) {
      System.out.println("main:printStackTrace()");
      e.printStackTrace(System.out);
    }
  }

}
