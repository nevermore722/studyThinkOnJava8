package exception;

// exceptions/Switch.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/16 17:19
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Switch {

  /**
   * 对于没有垃圾回收和析构函数自动调用机制的语言来说，finally 非常重要。它能使程序员保证：无论 try 块里发生了什么，内存总能得到释放。但 Java 有垃圾回收机制，所以内存释放不再是问题。而且，Java 也没有析构函数可供调用。那么，Java 在什么情况下才能用到 finally 呢？
   *
   * 当要把除内存之外的资源恢复到它们的初始状态时，就要用到 finally 子句。这种需要清理的资源包括：已经打开的文件或网络连接，在屏幕上画的图形，甚至可以是外部世界的某个开关，如下面例子所示：
   */
  private boolean state = false;

  public boolean read() {
    return state;
  }

  public void on() {
    state = true;
    System.out.println(this);
  }

  public void off() {
    state = false;
    System.out.println(this);
  }

  @Override
  public String toString() {
    return state ? "on" : "off";
  }
}
