package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/31 16:18
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/LoggingExceptions2.java
// Logging caught exceptions
// {ErrorOutputExpected}
public class LoggingExceptions2 {

  private static Logger logger = Logger.getLogger("LoggingExceptions2");

  static void logException(Exception e) {
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }

  public static void main(String[] args) {
    try {
      throw new NullPointerException();
    } catch (NullPointerException e) {
      logException(e);
    }
  }

}
