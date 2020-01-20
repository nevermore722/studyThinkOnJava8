package exception;
// exceptions/CloseExceptions.java

import lombok.SneakyThrows;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 14:38
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 最后，让我们看一下抛出异常的 close() 方法：
 *
 * 从技术上讲，我们并没有被迫在这里提供一个 catch 子句；你可以通过 main() throws CloseException 的方式来报告异常。但 catch 子句是放置错误处理代码的典型位置。
 *
 * 请注意，因为所有三个对象都已创建，所以它们都以相反的顺序关闭 - 即使 Closer 也是如此。 close() 抛出异常。当你想到它时，这就是你想要发生的事情，但是如果你必须自己编写所有这些逻辑，那么你可能会错过一些错误。想象一下所有代码都在那里，程序员没有考虑清理的所有含义，并且做错了。因此，应始终尽可能使用 try-with-resources。它有助于实现该功能，使得生成的代码更清晰，更易于理解。
 */
class CloseException extends Exception {

}

class Reporter2 implements AutoCloseable {

  String name = getClass().getSimpleName();

  Reporter2() {
    System.out.println("Creating " + name);
  }

  @Override
  public void close() throws Exception {
    System.out.println("Closing " + name);
  }
}

class Closer extends Reporter2 {

  @SneakyThrows
  @Override
  public void close() throws CloseException {
    super.close();
    throw new CloseException();
  }
}

public class CloseExceptions {

  public static void main(String[] args) {
    try (
        First f = new First();
        Closer c = new Closer();
        Second s = new Second()
    ) {
      System.out.println("In body");
    } catch (CloseException e) {
      System.out.println("Caught: " + e);
    }
  }

}
