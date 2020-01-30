package validating;
// validating/GuavaPreconditions.java
// Demonstrating Guava Preconditions

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.*;


/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/30 22:25
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 在非严格的 DbC 中，前置条件是 DbC 中你不想删除的那一部分，因为它可以检查方法参数的有效性。那是你没有办法控制的事情，所以你需要对其检查。因为 Java 在默认情况下禁用断言，所以通常最好使用另外一个始终验证方法参数的库。
 *
 * 谷歌的 Guava 库包含了一组很好的前置条件测试，这些测试不仅易于使用，而且命名也足够好。在这里你可以看到它们的简单用法。库的设计人员建议静态导入前置条件:
 *
 * 虽然 Guava 的前置条件适用于所有类型，但我这里只演示 字符串（String） 类型。test() 方法需要一个Consumer，因此我们可以传递一个 lambda 表达式作为第一个参数，传递给 lambda 表达式的字符串作为第二个参数。它显示字符串，以便在查看输出时确定方向，然后将字符串传递给 lambda 表达式。try 块中的第二个 println() 仅在 lambda 表达式成功时才显示; 否则 catch 块将捕获并显示错误信息。注意 test() 方法消除了多少重复的代码。
 */
public class GuavaPreconditions {

  static void test(Consumer<String> c, String s) {
    try {
      System.out.println(s);
      c.accept(s);
      System.out.println("Success");
    } catch (Exception e) {
      String type = e.getClass().getSimpleName();
      String msg = e.getMessage();
      System.out.println(type +
          (msg == null ? "" : ": " + msg));
    }
  }

  public static void main(String[] args) {
    test(s -> s = checkNotNull(s), "X");
    test(s -> s = checkNotNull(s), null);
    test(s -> s = checkNotNull(s, "s was null"), null);
    test(s -> s = checkNotNull(
        s, "s was null, %s %s", "arg2", "arg3"), null);
    test(s -> checkArgument(s == "Fozzie"), "Fozzie");
    test(s -> checkArgument(s == "Fozzie"), "X");
    test(s -> checkArgument(s == "Fozzie"), null);
    test(s -> checkArgument(
        s == "Fozzie", "Bear Left!"), null);
    test(s -> checkArgument(
        s == "Fozzie", "Bear Left! %s Right!", "Frog"),
        null);
    test(s -> checkState(s.length() > 6), "Mortimer");
    test(s -> checkState(s.length() > 6), "Mort");
    test(s -> checkState(s.length() > 6), null);
    test(s ->
        checkElementIndex(6, s.length()), "Robert");
    test(s ->
        checkElementIndex(6, s.length()), "Bob");
    test(s ->
        checkElementIndex(6, s.length()), null);
    test(s ->
        checkPositionIndex(6, s.length()), "Robert");
    test(s ->
        checkPositionIndex(6, s.length()), "Bob");
    test(s ->
        checkPositionIndex(6, s.length()), null);
    test(s -> checkPositionIndexes(
        0, 6, s.length()), "Hieronymus");
    test(s -> checkPositionIndexes(
        0, 10, s.length()), "Hieronymus");
    test(s -> checkPositionIndexes(
        0, 11, s.length()), "Hieronymus");
    test(s -> checkPositionIndexes(
        -1, 6, s.length()), "Hieronymus");
    test(s -> checkPositionIndexes(
        7, 6, s.length()), "Hieronymus");
    test(s -> checkPositionIndexes(
        0, 6, s.length()), null);
  }
}
