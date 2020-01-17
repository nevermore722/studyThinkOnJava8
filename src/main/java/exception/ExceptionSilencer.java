package exception;
// exceptions/ExceptionSilencer.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/17 17:11
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 一种更加简单的丢失异常的方式是从 finally 子句中返回：
 *
 * 如果运行这个程序，就会看到即使方法里抛出了异常，它也不会产生任何输出。
 */
public class ExceptionSilencer {

  public static void main(String[] args) {
    try {
      throw new RuntimeException();
    } finally {
      // Using 'return' inside the finally block
      // will silence any thrown exception.
      return;
    }
  }

}
