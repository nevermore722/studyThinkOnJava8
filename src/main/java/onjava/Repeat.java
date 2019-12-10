package onjava;

import static java.util.stream.IntStream.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 19:30
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 实用小功能 repeat() 可以用来替换简单的 for 循环。代码示例：
 */
public class Repeat {
  public static void repeat(int n, Runnable action) {
    range(0,n).forEach(i->action.run());
  }
}
