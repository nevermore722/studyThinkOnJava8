package validating;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/20 18:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CountedListTest {

  /**
   * @BeforeAll 注解是在任何其他测试操作之前运行一次的方法。
   * @AfterAll 是所有其他测试操作之后只运行一次的方法。两个方法都必须是静态的。
   *
   * @BeforeEach注解是通常用于创建和初始化公共对象的方法，并在每次测试前运行。可以将所有这样的初始化放在测试类的构造函数中，尽管我认为 @BeforeEach 更加清晰。JUnit为每个测试创建一个对象，确保测试运行之间没有副作用。然而，所有测试的所有对象都是同时创建的(而不是在测试之前创建对象)，所以使用 @BeforeEach 和构造函数之间的唯一区别是 @BeforeEach 在测试前直接调用。在大多数情况下，这不是问题，如果你愿意，可以使用构造函数方法。
   *
   * 如果你必须在每次测试后执行清理（如果修改了需要恢复的静态文件，打开文件需要关闭，打开数据库或者网络连接，etc），那就用注解 @AfterEach。
   *
   * 每个测试创建一个新的 CountedListTest 对象，任何非静态成员变量也会在同一时间创建。然后为每个测试调用 initialize() ，于是 list 被赋值为一个新的用字符串“0”、“1” 和 “2” 初始化的 CountedList 对象。观察 @BeforeEach 和 @AfterEach 的行为，这些方法在初始化和清理测试时显示有关测试的信息。
   *
   * insert() 和 replace() 演示了典型的测试方法。JUnit 使用 @Test 注解发现这些方法，并将每个方法作为测试运行。在方法内部，你可以执行任何所需的操作并使用 JUnit 断言方法（以"assert"开头）验证测试的正确性（更全面的"assert"说明可以在 Junit 文档里找到）。如果断言失败，将显示导致失败的表达式和值。这通常就足够了，但是你也可以使用每个 JUnit 断言语句的重载版本，它包含一个字符串，以便在断言失败时显示。
   *
   * 断言语句不是必须的；你可以在没有断言的情况下运行测试，如果没有异常，则认为测试是成功的。
   *
   * compare() 是“helper方法”的一个例子，它不是由 JUnit 执行的，而是被类中的其他测试使用。只要没有 @Test 注解，JUnit 就不会运行它，也不需要特定的签名。在这里，compare() 是私有方法 ，表示仅在测试类中使用，但他同样可以是 public 。其余的测试方法通过将其重构为 compare() 方法来消除重复的代码。
   *
   * 本书使用 build.gradle 控制测试，运行本章节的测试，使用命令：gradlew validating:test，Gradle 不会运行已经运行过的测试，所以如果你没有得到测试结果，得先运行：gradlew validating:clean。
   *
   * 可以用下面这个命令运行本书的所有测试：
   *
   * gradlew test
   *
   * 尽管可以用最简单的方法，如 CountedListTest.java 所示没那样，JUnit 还包括大量的测试结构，你可以到官网上学习它们。
   *
   * JUnit 是 Java 最流行的单元测试框架，但也有其它可以替代的。你可以通过互联网发现更适合的那一个。
   */

  private CountedList list;

  @BeforeAll
  static void beforeAllMsg() {
    System.out.println(">>> Starting CountedListTest");
  }

  @AfterAll
  static void afterAllMsg() {
    System.out.println(">>> Finished CountedListTest");
  }

  @BeforeEach
  public void initialize() {
    list = new CountedList();
    System.out.println("Set up for " + list.getId());
    for (int i = 0; i < 3; i++) {
      list.add(Integer.toString(i));
    }
  }

  @AfterEach
  public void cleanup() {
    System.out.println("Cleaning up " + list.getId());
  }

  @Test
  public void insert() {
    System.out.println("Running testInsert()");
    Assertions.assertEquals(list.size(), 3);
    list.add(1, "Insert");
    Assertions.assertEquals(list.size(), 4);
    Assertions.assertEquals(list.get(1), "Insert");
  }

  @Test
  public void replace() {
    System.out.println("Running testReplace()");
    Assertions.assertEquals(list.size(), 3);
    list.set(1, "Replace");
    Assertions.assertEquals(list.size(), 3);
    Assertions.assertEquals(list.get(1), "Replace");
  }

  // A helper method to simplify the code. As
  // long as it's not annotated with @Test, it will
  // not be automatically executed by JUnit.
  private void compare(List<String> lst, String[] strs) {
    Assertions.assertArrayEquals(lst.toArray(new String[0]), strs);
  }

  @Test
  public void order() {
    System.out.println("Running testOrder()");
    compare(list, new String[]{"0", "1", "2"});
  }

  @Test
  public void remove() {
    System.out.println("Running testRemove()");
    Assertions.assertEquals(list.size(), 3);
    list.remove(1);
    Assertions.assertEquals(list.size(), 2);
    compare(list, new String[]{"0", "2"});
  }

  @Test
  public void addAll() {
    System.out.println("Running testAddAll()");
    list.addAll(Arrays.asList(new String[]{
        "An", "African", "Swallow"
    }));
    Assertions.assertEquals(list.size(), 6);
    compare(list, new String[]{"0", "1", "2",
        "An", "African", "Swallow"});
  }
}
