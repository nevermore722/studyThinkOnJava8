package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/31 15:46
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/FullConstructors.java

/**
 * 你也可以为异常类创建一个接受字符串参数的构造器：
 */

class MyException extends Exception {

  MyException() {
  }

  MyException(String msg) {
    super(msg);
  }
}

public class FullConstructors {

  public static void f() throws MyException {
    System.out.println("Throwing MyException from f()");
    throw new MyException();
  }

  public static void g() throws MyException {
    System.out.println("Throwing MyException from g()");
    throw new MyException("Originated in g()");
  }

  public static void main(String[] args) {
    try {
      f();
    } catch (MyException e) {
      e.printStackTrace(System.out);
    }
    try {
      g();
    } catch (MyException e) {
      e.printStackTrace(System.out);
    }
  }
  /**
   * 新增的代码非常简短：两个构造器定义了 MyException 类型对象的创建方式。对于第二个构造器，使用 super 关键宇明确调用了其基类构造器，它接受一个字符串作为参数。
   *
   * 在异常处理程序中，调用了在 Throwable 类声明（Exception 即从此类继承）的 printStackTrace() 方法。就像从输出中看到的，它将打印“从方法调用处直到异常抛出处”的方法调用序列。这里，信息被发送到了 System.out，并自动地被捕获和显示在输出中。但是，如果调用默认版本：
   *
   * e.printStackTrace();
   * 信息就会被输出到标准错误流。
   */

}
