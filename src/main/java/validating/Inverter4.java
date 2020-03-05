package validating;
// validating/Inverter4.java

import static java.lang.Character.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 15:10
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Inverter4 implements StringInverter {

  static final String ALLOWED = "abcdefghijklmnopqrstuvwxyz ,." + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  @Override
  public String invert(String str) {
    if (str.length() > 30) {
      throw new RuntimeException("argument too long!");
    }
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (ALLOWED.indexOf(c) == -1) {
        throw new RuntimeException(c + " Not allowed");
      }
      result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
    }
    return result;
  }
}
