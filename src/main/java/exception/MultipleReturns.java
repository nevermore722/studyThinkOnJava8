package exception;

// exceptions/MultipleReturns.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/17 16:59
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class MultipleReturns {

  /**
   * 因为 finally 子句总是会执行，所以可以从一个方法内的多个点返回，仍然能保证重要的清理工作会执行：
   *
   * 从输出中可以看出，从何处返回无关紧要，finally 子句永远会执行。
   * @param i
   */
  public static void f(int i) {
    System.out.println("Initialization that requires cleanup");

    try {
      System.out.println("Point 1");
      if (i == 1) {
        return;
      }
      System.out.println("Point 2");
      if (i == 2) {
        return;
      }
      System.out.println("Point 3");
      if (i == 3) {
        return;
      }
      System.out.println("End");
      return;
    } finally {
      System.out.println("Performing cleanup");
    }
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 4; i++) {
      f(i);
    }
  }

}
