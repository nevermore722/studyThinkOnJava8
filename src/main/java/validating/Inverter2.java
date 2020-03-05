package validating;

import static java.lang.Character.*;

// validating/Inverter2.java
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 14:59
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 接下来我们实现反转操作：
 */
public class Inverter2 implements StringInverter {


  @Override
  public String invert(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
    }
    return result;
  }
}
