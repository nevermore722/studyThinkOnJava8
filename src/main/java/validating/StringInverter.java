package validating;

// validating/StringInverter.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/3/5 10:12
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 之所以可以有测试驱动开发（TDD）这种开发方式，是因为如果你在设计和编写代码时考虑到了测试，那么你不仅可以写出可测试性更好的代码，而且还可以得到更好的代码设计。 一般情况下这个说法都是正确的。 一旦我想到“我将如何测试我的代码？”，这个想法将使我的代码产生变化，并且往往是从“可测试”转变为“可用”。
 *
 * 纯粹的 TDD 主义者会在实现新功能之前就为其编写测试，这称为测试优先的开发。 我们采用一个简易的示例程序来进行说明，它的功能是反转 String 中字符的大小写。 让我们随意添加一些约束：String 必须小于或等于30个字符，并且必须只包含字母，空格，逗号和句号(英文)。
 *
 * 此示例与标准 TDD 不同，因为它的作用在于接收 StringInverter 的不同实现，以便在我们逐步满足测试的过程中来体现类的演变。 为了满足这个要求，将 StringInverter 作为接口：
 */
interface StringInverter {

  String invert(String str);
}
