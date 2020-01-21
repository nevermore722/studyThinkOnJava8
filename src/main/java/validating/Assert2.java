package validating;

// validating/Assert2.java
// Assert with an information-expression
// {java Assert2 -ea}
// {ThrowsException}
/**
 * 输出中并没有包含多少有用的信息。另一方面，如果你使用 information-expression ， 将生成一条有用的消息作为异常堆栈跟踪的一部分。最有用的
 * information-expression 通常是一串针对程序员的文本：
 */

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 11:30
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Assert2 {

  public static void main(String[] args) {
    assert false :
        "Here's a message saying what happened";
  }
  /**
   * information-expression 可以产生任何类型的对象，因此，通常将构造一个包含对象值的更复杂的字符串，它包含失败的断言。
   *
   * 你还可以基于类名或包名打开或关闭断言；也就是说，你可以对整个包启用或禁用断言。实现这一点的详细信息在 JDK 的断言文档中。此特性对于使用断言的大型项目来说很有用当你想打开或关闭某些断言时。但是，日志记录（Logging）或者调试（Debugging）,可能是捕获这类信息的更好工具。
   */

}
