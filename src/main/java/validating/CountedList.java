package validating;
// validating/CountedList.java
// Keeps track of how many of itself are created.

import java.util.ArrayList;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/20 18:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CountedList extends ArrayList<String> {

  private static int counter = 0;
  private int id = counter++;

  public CountedList() {
    System.out.println("CountedList #" + id);
  }

  public int getId() {
    return id;
  }

}
