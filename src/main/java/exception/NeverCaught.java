package exception;

// exceptions/NeverCaught.java
// Ignoring RuntimeExceptions
// {ThrowsException}

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/16 15:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class NeverCaught {

  /**
   * 如果 RuntimeException 没有被捕获而直达 main()，那么在程序退出前将调用异常的 printStackTrace() 方法。
   *
   * 你会发现，RuntimeException（或任何从它继承的异常）是一个特例。对于这种异常类型，编译器不需要异常说明，其输出被报告给了 System.err。
   *
   * 请务必记住：只能在代码中忽略 RuntimeException（及其子类）类型的异常，因为所有受检查类型异常的处理都是由编译器强制实施的。
   *
   * 值得注意的是：不应把 Java 的异常处理机制当成是单一用途的工具。是的，它被设计用来处理一些烦人的运行时错误，这些错误往往是由代码控制能力之外的因素导致的；然而，它对于发现某些编译器无法检测到的编程错误，也是非常重要的。
   */
  static void f() {
    throw new RuntimeException("From f()");
  }

  static void g() {
    f();
  }

  public static void main(String[] args) {
    g();
  }

}
