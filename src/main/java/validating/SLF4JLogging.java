package validating;
// validating/SLF4JLogging.java

import org.slf4j.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 17:32
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * SLF4J 提供了一个复杂的工具来报告程序的信息，它的效率与前面示例中的技术几乎相同。 对于非常简单的信息日志记录，你可以执行以下操作：
 */
public class SLF4JLogging {

  private static Logger log =
      LoggerFactory.getLogger(SLF4JLogging.class);

  public static void main(String[] args) {
    log.info("hello logging");
  }

}
