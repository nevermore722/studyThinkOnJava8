package exception;
// exceptions/AutoCloseableDetails.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 11:45
 * @description：
 * @modified By：
 * @version: 1.0
 */
class Reporter implements AutoCloseable {

  String name = getClass().getSimpleName();

  Reporter() {
    System.out.println("Creating " + name);
  }

  @Override
  public void close() {
    System.out.println("Closing " + name);
  }
}

class First extends Reporter {

}

class Second extends Reporter {

}

public class AutoCloseableDetails {

  public static void main(String[] args) {
    try (
        First f = new First();
        Second s = new Second()
    ) {

    }
  }

}
