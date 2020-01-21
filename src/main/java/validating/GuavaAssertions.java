package validating;

// validating/GuavaAssertions.java
// Assertions that are always enabled.

import com.google.common.base.*;

import static com.google.common.base.Verify.*;

/**
 * 因为启用 Java 本地断言很麻烦，Guava 团队添加一个始终启用的用来替换断言的 Verify 类。他们建议静态导入 Verify 方法：
 *
 * 这里有两个方法，使用变量 verify() 和 verifyNotNull() 来支持有用的错误消息。注意，verifyNotNull() 内置的错误消息通常就足够了，而 verify() 太一般，没有有用的默认错误消息。
 */

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 11:43
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class GuavaAssertions {

  public static void main(String[] args) {
    verify(2 + 2 == 4);
    try {
      verify(1 + 2 == 4);
    } catch (VerifyException e) {
      System.out.println(e);
    }
    try {
      verify(1 + 2 == 4, "Bad math");
    } catch (VerifyException e) {
      System.out.println(e.getMessage());
    }
    try {
      verify(1 + 2 == 4, "Bad math: %s", "not 4");
    } catch (VerifyException e) {
      System.out.println(e.getMessage());
    }
    String s = "";
    s = verifyNotNull(s);
    s = null;
    try {
      verifyNotNull(s);
    } catch (VerifyException e) {
      System.out.println(e.getMessage());
    }
    try {
      verifyNotNull(s, "Shouldn't be null:%s", "arg s");
    } catch (VerifyException e) {
      System.out.println(e.getMessage());
    }
  }

}
