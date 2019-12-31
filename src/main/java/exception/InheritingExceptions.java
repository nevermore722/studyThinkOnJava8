package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/31 15:41
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/InheritingExceptions.java
// Creating your own exceptions

/**
 * 不必拘泥于 Java 中已有的异常类型。Java 提供的异常体系不可能预见所有的希望加以报告的错误，所以可以自己定义异常类来表示程序中可能会遇到的特定问题。
 *
 * 要自己定义异常类，必须从已有的异常类继承，最好是选择意思相近的异常类继承（不过这样的异常并不容易找）。建立新的异常类型最简单的方法就是让编译器为你产生无参构造器，所以这几乎不用写多少代码：
 *
 * 编译器创建了无参构造器，它将自动调用基类的无参构造器。本例中不会得到像 SimpleException(String) 这样的构造器，这种构造器也不实用。你将看到，对异常来说，最重要的部分就是类名，所以本例中建立的异常类在大多数情况下已经够用了。
 *
 * 本例的结果被打印到了控制台上，本书的输出显示系统正是在控制台上自动地捕获和测试这些结果的。但是，你也许想通过写入 System.err 而将错误发送给标准错误流。通常这比把错误信息输出到 System.out 要好，因为 System.out 也许会被重定向。如果把结果送到 System.err，它就不会随 System.out 一起被重定向，这样更容易被用户注意。
 */
class SimpleException extends Exception {

}

public class InheritingExceptions extends Exception {

  public void f() throws SimpleException {
    System.out.println("Throw SimpleException from f()");
    throw new SimpleException();
  }

  public static void main(String[] args) {
    InheritingExceptions sed = new InheritingExceptions();
    try {
      sed.f();
    } catch (SimpleException e) {
      System.out.println("Caught it!");
    }
  }


}
