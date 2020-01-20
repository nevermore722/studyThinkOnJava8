package exception;
// exceptions/ConstructorException.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 14:24
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 如果其中一个构造函数抛出异常怎么办？
 *
 * 现在资源规范头中定义了 3 个对象，中间的对象抛出异常。因此，编译器强制我们使用 catch 子句来捕获构造函数异常。这意味着资源规范头实际上被 try 块包围。
 *
 * 正如预期的那样，First 创建时没有发生意外，SecondExcept 在创建期间抛出异常。请注意，不会为 SecondExcept 调用
 * close()，因为如果构造函数失败，则无法假设你可以安全地对该对象执行任何操作，包括关闭它。由于 SecondExcept 的异常，Second 对象实例 s2
 * 不会被创建，因此也不会有清除事件发生。
 */
class CE extends Exception {

}

class SecondExcept extends Reporter {

  SecondExcept() throws CE {
    super();
    throw new CE();
  }
}

public class ConstructorException {

  public static void main(String[] args) {
    try (
        First f = new First();
        SecondExcept s = new SecondExcept();
        Second s2 = new Second()
    ) {
      System.out.println("In body");
    } catch (CE e) {
      System.out.println("Caught " + e);
    }
  }
}
