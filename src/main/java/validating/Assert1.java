package validating;


// validating/Assert1.java

// Non-informative style of assert
// Must run using -ea flag:
// {java -ea Assert1}
// {ThrowsException}

/**
 * 你可以通过其它程序设计架构来模拟断言的效果，因此，在 Java 中包含断言的意义在于它们易于编写。断言语句有两种形式 :
 *
 * assert boolean-expression；
 *
 * assert boolean-expression: information-expression;
 *
 * 两者似乎告诉我们 “我断言这个布尔表达式会产生 true”， 否则，将抛出 AssertionError 异常。
 *
 * AssertionError 是 Throwable 的派生类，因此不需要异常说明。
 *
 * 不幸的是，第一种断言形式的异常不会生成包含布尔表达式的任何信息（与大多数其他语言的断言机制相反）。
 *
 * 下面是第一种形式的例子：
 */
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 11:27
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Assert1 {

  public static void main(String[] args) {
    assert false;
  }
  /**
   * 如果你正常运行程序，没有任何特殊的断言标志，则不会发生任何事情。你需要在运行程序时显式启用断言。一种简单的方法是使用 -ea 标志， 它也可以表示为: -enableassertion， 这将运行程序并执行任何断言语句。
   */

}