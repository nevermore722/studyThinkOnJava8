package exception;

// exceptions/SameHandler.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 14:22
 * @description：
 * @modified By：
 * @version: 1.0
 */
class EBase1 extends Exception {

}

class Except1 extends EBase1 {

}

class EBase2 extends Exception {

}

class Except2 extends EBase2 {

}

class EBase3 extends Exception {

}

class Except3 extends EBase3 {

}

class EBase4 extends Exception {

}

class Except4 extends EBase4 {

}

/**
 * 如果有一组具有相同基类的异常，你想使用同一方式进行捕获，那你直接 catch 它们的基类型。但是，如果这些异常没有共同的基类型，在 Java 7 之前，你必须为每一个类型编写一个 catch：
 */
public class SameHandler {

  void x() throws Except1, Except2, Except3, Except4 {
  }

  void process() {
  }

  void f() {
    try {
      x();
    } catch (Except1 e) {
      process();
    } catch (Except2 e) {
      process();
    } catch (Except4 e) {
      process();
    } catch (Except3 e) {
      process();
    }
  }

}
