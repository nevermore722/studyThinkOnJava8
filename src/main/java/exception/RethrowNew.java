package exception;

// exceptions/RethrowNew.java
// Rethrow a different object from the one you caught
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 16:58
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 有可能在捕获异常之后抛出另一种异常。这么做的话，得到的效果类似于使用 filInStackTrace()，有关原来异常发生点的信息会丢失，剩下的是与新的抛出点有关的信息：
 */
class OneException extends Exception {

  OneException(String s) {
    super(s);
  }
}

class TwoException extends Exception {

  TwoException(String s) {
    super(s);
  }
}

public class RethrowNew {

  public static void f() throws OneException {
    System.out.println("originating the exception in f()");
    throw new OneException("thrown from f()");
  }


  public static void main(String[] args) {
    /**
     * 最后那个异常仅知道自己来自 main()，而对 f() 一无所知。
     *
     * 永远不必为清理前一个异常对象而担心，或者说为异常对象的清理而担心。它们都是用 new 在堆上创建的对象，所以垃圾回收器会自动把它们清理掉。
     */
    try {
      try {
        f();
      } catch (OneException e) {
        System.out.println("Caught in inner try,e.printStackTrace()");
        e.printStackTrace(System.out);
        throw new TwoException("from inner try");
      }
    } catch (TwoException e) {
      System.out.println("Caught in outer try,e.printStackTrace()");
      e.printStackTrace(System.out);
    }

  }

}
