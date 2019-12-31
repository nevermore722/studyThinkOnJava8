package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/31 16:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
// exceptions/LoggingExceptions.java
// An exception that reports through a Logger
// {ErrorOutputExpected}

/**
 * 你可能还想使用 java.util.logging 工具将输出记录到日志中。基本的日志记录功能还是相当简单易懂的：
 *
 * 静态的 Logger.getLogger() 方法创建了一个 String 参数相关联的 Logger 对象（通常与错误相关的包名和类名），这个 Logger 对象会将其输出发送到 System.err。向 Logger 写入的最简单方式就是直接调用与日志记录消息的级别相关联的方法，这里使用的是 severe()。为了产生日志记录消息，我们欲获取异常抛出处的栈轨迹，但是 printStackTrace() 不会默认地产生字符串。为了获取字符串，我们需要使用重载的 printStackTrace() 方法，它接受一个 java.io.PrintWriter 对象作为参数（PrintWriter 会在 附录：I/O 流 一章详细介绍）。如果我们将一个 java.io.StringWriter 对象传递给这个 PrintWriter 的构造器，那么通过调用 toString() 方法，就可以将输出抽取为一个 String。
 *
 * 尽管由于 LoggingException 将所有记录日志的基础设施都构建在异常自身中，使得它所使用的方式非常方便，并因此不需要客户端程序员的干预就可以自动运行，但是更常见的情形是我们需要捕获和记录其他人编写的异常，因此我们必须在异常处理程序中生成日志消息；
 */
class LoggingException extends Exception {

  private static Logger logger = Logger.getLogger("LoggingException");

  LoggingException() {
    StringWriter trace = new StringWriter();
    printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }
}

public class LoggingExceptions {

  public static void main(String[] args) {
    try {
      throw new LoggingException();
    } catch (LoggingException e) {
      System.err.println("Caught " + e);
    }
    try {
      throw new LoggingException();
    } catch (LoggingException e) {
      System.err.println("Caught " + e);
    }
  }

}
