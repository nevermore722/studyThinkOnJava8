package validating;

import static com.google.common.base.Preconditions.*;
// validating/NonNullConstruction.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/30 22:50
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 每个前置条件都有三种不同的重载形式：一个什么都没有，一个带有简单字符串消息，以及带有一个字符串和替换值。为了提高效率，只允许 %s (字符串类型)替换标记。在上面的例子中，演示了checkNotNull() 和 checkArgument() 这两种形式。但是它们对于所有前置条件方法都是相同的。注意 checkNotNull() 的返回参数， 所以你可以在表达式中内联使用它。下面是如何在构造函数中使用它来防止包含 Null 值的对象构造：
 *
 * checkArgument() 接受布尔表达式来对参数进行更具体的测试， 失败时抛出 IllegalArgumentException，checkState() 用于测试对象的状态（例如，不变性检查），而不是检查参数，并在失败时抛出 IllegalStateException 。
 *
 * 最后三个方法在失败时抛出 IndexOutOfBoundsException。checkElementIndex() 确保其第一个参数是列表、字符串或数组的有效元素索引，其大小由第二个参数指定。checkPositionIndex() 确保它的第一个参数在 0 到第二个参数(包括第二个参数)的范围内。 checkPositionIndexes() 检查 [first_arg, second_arg] 是一个列表的有效子列表，由第三个参数指定大小的字符串或数组。
 *
 * 所有的 Guava 前置条件对于基本类型和对象都有必要的重载。
 */
public class NonNullConstruction {

  private Integer n;
  private String s;

  NonNullConstruction(Integer n, String s) {
    this.n = checkNotNull(n);
    this.s = checkNotNull(s);
  }

  public static void main(String[] args) {
    NonNullConstruction nnc =
        new NonNullConstruction(3, "Trousers");
  }
}
