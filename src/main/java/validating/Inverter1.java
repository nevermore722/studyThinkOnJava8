package validating;
// validating/Inverter1.java
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 14:57
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 在一般的测试中，你可能认为在进行一个结果为失败的测试时应该停止代码构建。 但是在这里，我们只希望系统报告问题，但仍然继续运行，以便你可以看到不同版本的 StringInverter 的效果。
 *
 * 每个使用 @TestFactory 注释的方法都会生成一个 DynamicTest 对象的 Stream（通过 testVersions() ），每个 JUnit 都像常规的 @Test 方法一样执行。
 *
 * 现在测试都已经准备好了，我们就可以开始实现 **StringInverter **了。 我们从一个仅返回其参数的假的实现类开始：
 */
public class Inverter1 implements StringInverter {

  @Override
  public String invert(String str) {
    return str;
  }
}
