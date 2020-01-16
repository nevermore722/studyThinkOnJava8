package exception;

// exceptions/AlwaysFinally.java
// Finally is always executed

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/16 17:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
class FourException extends Exception {

}

public class AlwaysFinally {

  public static void main(String[] args) {
    /**
     * 当涉及 break 和 continue 语句的时候，finally 子句也会得到执行。请注意，如果把 finally 子句和带标签的 break 及 continue 配合使用，在 Java 里就没必要使用 goto 语句了。
     */
    System.out.println("Entering first try block");
    try{
      System.out.println("Entering second try block");
      try {
        throw new FourException();
      }finally {
        System.out.println("finally in 2nd try block");
      }
    }catch (FourException e){
      System.out.println("Caught FourException in 1st try block");
    }finally {
      System.out.println("finally in 1st try block");
    }
  }

}
