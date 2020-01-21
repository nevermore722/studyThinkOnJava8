package validating;
// validating/CircularQueueException.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 15:39
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CircularQueueException extends RuntimeException {

  public CircularQueueException(String why) {
    super(why);
  }

}
