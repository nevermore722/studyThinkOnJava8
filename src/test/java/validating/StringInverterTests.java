package validating;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 15:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
//TODO 找不到expectThrows方法，不知道为啥，先放着以后排查

/**
 *DynamicStringInverterTests.java 仅是为了显示 TDD 过程中不同 StringInverter 实现的开发。 通常，你只需编写一组如下所示的测试，并修改单个 StringInverter 类直到它满足所有测试：
 *
 * 你可以通过这种方式进行开发：一开始在测试中建立你期望程序应有的所有特性，然后你就能在实现中一步步添加功能，直到所有测试通过。 完成后，你还可以在将来通过这些测试来得知（或让其他任何人得知）当修复错误或添加功能时，代码是否被破坏了。 TDD的目标是产生更好，更周全的测试，因为在完全实现之后尝试实现完整的测试覆盖通常会产生匆忙或无意义的测试。
 */
/*
public class StringInverterTests {

  StringInverter inverter = new Inverter4();

  @BeforeAll
  static void startMsg() {
    System.out.println(">>> StringInverterTests <<<");
  }

  @Test
  void basicInversion1() {
    String in = "Exit, Pursued by a Bear.";
    String out = "eXIT, pURSUED BY A bEAR.";
    assertEquals(inverter.invert(in), out);
  }

  @Test
  void basicInversion2() {
    expectThrows(Error.class, () -> {
      assertEquals(inverter.invert("X"), "X");
    });
  }

  @Test
  void disallowedCharacters() {
    String disallowed = ";-_()*&^%$#@!~`0123456789";
    String result = disallowed.chars()
        .mapToObj(c -> {
          String cc = Character.toString((char) c);
          try {
            inverter.invert(cc);
            return "";
          } catch (RuntimeException e) {
            return cc;
          }
        }).collect(Collectors.joining(""));
    assertEquals(result, disallowed);
  }

  @Test
  void allowedCharacters() {
    String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
    String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
    assertEquals(inverter.invert(lowcase), upcase);
    assertEquals(inverter.invert(upcase), lowcase);
  }

  @Test
  void lengthNoGreaterThan30() {
    String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    assertTrue(str.length() > 30);
    expectThrows(RuntimeException.class, () -> {
      inverter.invert(str);
    });
  }

  @Test
  void lengthLessThan31() {
    String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    assertTrue(str.length() < 31);
    inverter.invert(str);
  }
}*/
