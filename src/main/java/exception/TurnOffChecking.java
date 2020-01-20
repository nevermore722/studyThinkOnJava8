package exception;
// exceptions/TurnOffChecking.java
// "Turning off" Checked exceptions

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/20 16:49
 * @description：
 * @modified By：
 * @version: 1.0
 */
class WrapCheckedException {

  void throwRuntimeException(int type) {
    try {
      switch (type) {
        case 0:
          throw new FileNotFoundException();
        case 1:
          throw new IOException();
        case 2:
          throw new RuntimeException("Where am I?");
        default:
          return;
      }
    } catch (IOException | RuntimeException e) {
      // Adapt to unchecked:
      throw new RuntimeException(e);
    }
  }
}

class SomeOtherException extends Exception {

}

public class TurnOffChecking {

  public static void main(String[] args) {
    WrapCheckedException wce = new WrapCheckedException();
    // You can call throwRuntimeException() without
    // a try block, and let RuntimeExceptions
    // leave the method:
    wce.throwRuntimeException(3);
    // Or you can choose to catch exceptions:
    for (int i = 0; i < 4; i++) {
      try {
        if (i < 3) {
          wce.throwRuntimeException(i);
        } else {
          throw new SomeOtherException();
        }
      } catch (SomeOtherException e) {
        System.out.println("SomeOtherException: " + e);
      } catch (RuntimeException re) {
        try {
          throw re.getCause();
        } catch (FileNotFoundException e) {
          System.out.println("FileNotFoundException: " + e);
        } catch (IOException e) {
          System.out.println("IOException: " + e);
        } catch (Throwable e) {
          System.out.println("Throwable: " + e);
        }
      }
    }

  }
}
