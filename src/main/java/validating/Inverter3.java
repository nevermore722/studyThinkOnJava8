package validating;
// validating/Inverter3.java

import static java.lang.Character.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 15:03
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 现在添加代码以确保输入不超过30个字符：
 */
public class Inverter3 implements StringInverter {

  @Override
  public String invert(String str) {
    if (str.length() > 30) {
      throw new RuntimeException("argument too long!");
    }
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
    }
    return result;
  }
}
