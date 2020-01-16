package exception;
// exceptions/WithFinally.java
// Finally Guarantees cleanup

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/16 17:31
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class WithFinally {

  static Switch sw = new Switch();

  public static void main(String[] args) {
    try {
      sw.on();
      // Code that can throw exceptions...
      OnOffSwitch.f();
    } catch (OnOffException1 e) {
      System.out.println("OnOffException1");
    } catch (OnOffException2 e) {
      System.out.println("OnOffException2");
    } finally {
      sw.off();
    }
  }

}
