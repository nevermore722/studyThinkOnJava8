package onjava;
// onjava/Timer.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import static java.util.concurrent.TimeUnit.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/5/20 9:07
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Timer {

  private long start = System.nanoTime();

  public long duration() {
    return NANOSECONDS.toMillis(
        System.nanoTime() - start);
  }

  public static long duration(Runnable test) {
    Timer timer = new Timer();
    test.run();
    return timer.duration();
  }
}
