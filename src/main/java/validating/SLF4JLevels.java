// validating/SLF4JLevels.java
package validating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/5/13 22:12
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class SLF4JLevels {
  private static Logger log = LoggerFactory.getLogger(SLF4JLogging.class);

  public static void main(String[] args) {
    log.trace("Hello");
    log.debug("Logging");
    log.info("Using");
    log.warn("the SLF4J");
    log.error("Facade");
  }

}
