package validating;

// validating/tests/DynamicStringInverterTests.java

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 10:19
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 现在我们通过可以编写测试来表述我们的要求。 以下所述通常不是你编写测试的方式，但由于我们在此处有一个特殊的约束：我们要对 **StringInverter **多个版本的实现进行测试，为此，我们利用了 JUnit5 中最复杂的新功能之一：动态测试生成。 顾名思义，通过它你可以使你所编写的代码在运行时生成测试，而不需要你对每个测试显式编码。 这带来了许多新的可能性，特别是在明确地需要编写一整套测试而令人望而却步的情况下。
 *
 * JUnit5 提供了几种动态生成测试的方法，但这里使用的方法可能是最复杂的。 **DynamicTest.stream() **方法采用了：
 *
 * 对象集合上的迭代器 (versions) ，这个迭代器在不同组的测试中是不同的。 迭代器生成的对象可以是任何类型，但是只能有一种对象生成，因此对于存在多个不同的对象类型时，必须人为地将它们打包成单个类型。
 * Function，它从迭代器获取对象并生成描述测试的 String 。
 * Consumer，它从迭代器获取对象并包含基于该对象的测试代码。
 * 在此示例中，所有代码将在 testVersions() 中进行组合以防止代码重复。 迭代器生成的对象是对 DynamicTest 的不同实现，这些对象体现了对接口不同版本的实现：
 */
//你将从测试输出中看到，每个版本的 Inverter 都几乎能通过所有测试。 当你在进行测试优先的开发时会有相同的体验。
class DynamicStringInverterTests {

  // Combine operations to prevent code duplication:
  Stream<DynamicTest> testVersions(String id, Function<StringInverter, String> test) {
    List<StringInverter> versions = Arrays.asList(
        new Inverter1(), new Inverter2(), new Inverter3(), new Inverter4()
    );
    return DynamicTest.stream(
        versions.iterator(),
        inverter -> inverter.getClass().getSimpleName(),
        inverter -> {
          System.out.println(inverter.getClass().getSimpleName() + ": " + id);
          try {
            if (test.apply(inverter) != "fail") {
              System.out.println("Success");
            }
          } catch (Exception | Error e) {
            System.out.println("Exception: " + e.getMessage());
          }
        }
    );
  }

  String isEqual(String lval, String rval) {
    if (lval.equals(rval)) {
      return "success";
    }
    System.out.println("FAIL:" + lval + " != " + rval);
    return "fail";
  }

  @BeforeAll
  static void startMsg() {
    System.out.println(">>> Starting DynamicStringInverterTests <<<");
  }

  @AfterAll
  static void endMsg() {
    System.out.println(">>> Finished DynamicStringInverterTests <<<");
  }

  @TestFactory
  Stream<DynamicTest> basicInversion1() {
    String in = "Exit, Pursued by a Bear.";
    String out = "eXIT, pURSUED BY A bEAR.";
    return testVersions(
        "Basic inversion (should succeed)",
        inverter -> isEqual(inverter.invert(in), out)
    );
  }

  @TestFactory
  Stream<DynamicTest> basicInversion2() {
    return testVersions("Basic inversion(should fail)",
        inverter -> isEqual(inverter.invert("x"), "x"));
  }

  @TestFactory
  Stream<DynamicTest> disallowedCharacters() {
    String disallowed = ";-_()*&^%$#@!~`0123456789";
    return testVersions(
        "Disallowed characters",
        inverter -> {
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
          if (result.length() == 0) {
            return "success";
          }
          System.out.println("Bad characters: " + result);
          return "fail";
        }
    );
  }

  @TestFactory
  Stream<DynamicTest> allowedCharacters() {
    String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
    String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
    return testVersions("Allowed characters (should succeed)",
        inverter -> {
          assertEquals(inverter.invert(lowcase), upcase);
          assertEquals(inverter.invert(upcase), lowcase);
          return "success";
        });
  }

  @TestFactory
  Stream<DynamicTest> lengthNoGreaterThan30() {
    String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    assertTrue(str.length() > 30);
    return testVersions("Length must be less than 31 (throws exception)",
        inverter -> inverter.invert(str));
  }

  @TestFactory
  Stream<DynamicTest> lengthLessThan31() {
    String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    assertTrue(str.length() < 31);
    return testVersions(
        "Length must be less than 31 (should succeed)",
        inverter -> inverter.invert(str)
    );
  }

}
