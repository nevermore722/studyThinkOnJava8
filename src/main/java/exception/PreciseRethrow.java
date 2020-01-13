package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 17:24
 * @description：
 * @modified By：
 * @version: 1.0
 */
class BaseException extends Exception {

}

class DerivedException extends BaseException {

}

public class PreciseRethrow {

  /**
   * 在 Java 7 之前，如果遇到异常，则只能重新抛出该类型的异常。这导致在 Java 7 中修复的代码不精确。所以在 Java 7 之前，这无法编译：
   *
   * 因为 catch 捕获了一个 BaseException，编译器强迫你声明 catcher() 抛出 BaseException，即使它实际上抛出了更具体的 DerivedException。从 Java 7 开始，这段代码就可以编译，这是一个很小但很有用的修复。
   * @throws DerivedException
   */
  void catcher() throws DerivedException {
    try {
      throw new DerivedException();
    } catch (BaseException e) {
      throw e;
    }
  }

}
