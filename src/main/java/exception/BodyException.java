package exception;
// exceptions/BodyException.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 14:31
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 如果没有构造函数抛出异常，但你可能会在 try 的主体中获取它们，则再次强制你实现 catch 子句：
 *
 * 请注意，第 3 个对象永远不会被清除。那是因为它不是在资源规范头中创建的，所以它没有被保护。这很重要，因为 Java 在这里没有以警告或错误的形式提供指导，因此像这样的错误很容易漏掉。实际上，如果依赖某些集成开发环境来自动重写代码，以使用 try-with-resources 特性，那么它们（在撰写本文时）通常只会保护它们遇到的第一个对象，而忽略其余的对象。
 */
class Third extends Reporter {

}

public class BodyException {

  public static void main(String[] args) {
    try (
        First f = new First();
        Second s2 = new Second()
    ) {
      System.out.println("In body");
      Third t = new Third();
      new SecondExcept();
      System.out.println("End of body");
    } catch (CE e) {
      System.out.println("Caught: " + e);
    }
  }
}
