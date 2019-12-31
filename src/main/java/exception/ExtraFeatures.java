package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/31 16:22
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/ExtraFeatures.java
// Further embellishment of exception classes

class MyException2 extends Exception {

  private int x;

  MyException2() {
  }

  MyException2(String msg) {
    super(msg);
  }

  MyException2(String msg, int x) {
    super(msg);
    this.x = x;
  }

  public int val() {
    return x;
  }

  @Override
  public String getMessage() {
    return "Detail Message: " + x
        + " " + super.getMessage();
  }
}

public class ExtraFeatures {

  public static void f() throws MyException2 {
    System.out.println(
        "Throwing MyException2 from f()");
    throw new MyException2();
  }

  public static void g() throws MyException2 {
    System.out.println(
        "Throwing MyException2 from g()");
    throw new MyException2("Originated in g()");
  }

  public static void h() throws MyException2 {
    System.out.println(
        "Throwing MyException2 from h()");
    throw new MyException2("Originated in h()", 47);
  }

  public static void main(String[] args) {
    try {
      f();
    } catch (MyException2 e) {
      e.printStackTrace(System.out);
    }
    try {
      g();
    } catch (MyException2 e) {
      e.printStackTrace(System.out);
    }
    try {
      h();
    } catch (MyException2 e) {
      e.printStackTrace(System.out);
      System.out.println("e.val() = " + e.val());
    }
  }
  /**
   * 新的异常添加了字段 x 以及设定 x 值的构造器和读取数据的方法。此外，还覆盖了 Throwable. getMessage() 方法，以产生更详细的信息。对于异常类来说，getMessage() 方法有点类似于 toString() 方法。
   *
   * 既然异常也是对象的一种，所以可以继续修改这个异常类，以得到更强的功能。但要记住，使用程序包的客户端程序员可能仅仅只是查看一下抛出的异常类型，其他的就不管了（大多数 Java 库里的异常都是这么用的），所以对异常所添加的其他功能也许根本用不上。
   */
}
