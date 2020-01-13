package exception;

// exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 14:14
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class ExceptionMethods {

  public static void main(String[] args) {
    /**
     * 可以发现每个方法都比前一个提供了更多的信息一一实际上它们每一个都是前一个的超集。
     */
    try {
      throw new Exception("My Exception");
    } catch (Exception e) {
      System.out.println("Caught Exception");
      System.out.println("getMessage():" + e.getMessage());
      System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
      System.out.println("toString():" + e);
      System.out.println("printStackTrace():");
      e.printStackTrace(System.out);
    }
  }

}
