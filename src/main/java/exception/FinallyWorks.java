package exception;
// exceptions/FinallyWorks.java
// The finally clause is always executed

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/16 15:46
 * @description：
 * @modified By：
 * @version: 1.0
 */
class ThreeException extends Exception {

}

public class FinallyWorks {

  static int count = 0;

  public static void main(String[] args) {
    /**
     * 可以从输出中发现，无论异常是否被抛出，finally 子句总能被执行。这个程序也给了我们一些思路，当 Java 中的异常不允许我们回到异常抛出的地点时，那么该如何应对呢？如果把 try 块放在循环里，就建立了一个“程序继续执行之前必须要达到”的条件。还可以加入一个 static 类型的计数器或者别的装置，使循环在放弃以前能尝试一定的次数。这将使程序的健壮性更上一个台阶。
     */
    while (true) {
      try {
        // Post-increment is zero first time:
        if (count++ == 0) {
          throw new ThreeException();
        }
        System.out.println("No exception");
      } catch (ThreeException e) {
        System.out.println("ThreeException");
      } finally {
        System.out.println("In finally clause");
        if (count == 2) {
          // out of "while"
          break;
        }
      }
    }
  }

}
