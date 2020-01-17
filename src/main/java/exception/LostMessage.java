package exception;

// exceptions/LostMessage.java
// How an exception can be lost

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/17 17:06
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 遗憾的是，Java 的异常实现也有瑕疵。异常作为程序出错的标志，决不应该被忽略，但它还是有可能被轻易地忽略。用某些特殊的方式使用 finally 子句，就会发生这种情况：
 *
 * 从输出中可以看到，VeryImportantException 不见了，它被 finally 子句里的 HoHumException 所取代。这是相当严重的缺陷，因为异常可能会以一种比前面例子所示更微妙和难以察党的方式完全丢失。相比之下，C++把“前一个异常还没处理就抛出下一个异常”的情形看成是糟糕的编程错误。也许在 Java 的未来版本中会修正这个问题（另一方面，要把所有抛出异常的方法，如上例中的 dispose() 方法，全部打包放到 try-catch 子句里面）。
 */
class VeryImportantException extends Exception {

  @Override
  public String toString() {
    return "A very important exception!";
  }
}

class HoHumException extends Exception {

  @Override
  public String toString() {
    return "A trivial exception";
  }
}

public class LostMessage {

  void f() throws VeryImportantException {
    throw new VeryImportantException();
  }

  void dispose() throws HoHumException {
    throw new HoHumException();
  }

  public static void main(String[] args) {
    try {
      LostMessage lm = new LostMessage();
      try {
        lm.f();
      } finally {
        lm.dispose();
      }
    } catch (VeryImportantException | HoHumException e) {
      System.out.println(e);
    }
  }

}
