package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 11:11
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.function.IntSupplier;

/**
 * 在上一节的 ProduceFunction.java 中，我们从方法中返回 Lambda 函数。 虽然过程简单，但是有些问题必须再回过头来探讨一下。
 * <p>
 * 闭包（Closure）一词总结了这些问题。 它非常重要，利用闭包可以轻松生成函数。
 * <p>
 * 考虑一个更复杂的 Lambda，它使用函数作用域之外的变量。 返回该函数会发生什么？ 也就是说，当你调用函数时，它对那些 “外部 ”变量引用了什么? 如果语言不能自动解决这个问题，那将变得非常具有挑战性。 能够解决这个问题的语言被称为支持闭包，或者叫作在词法上限定范围( 也使用术语变量捕获 )。Java 8 提供了有限但合理的闭包支持，我们将用一些简单的例子来研究它。
 * <p>
 * 首先，下例函数中，方法返回访问对象字段和方法参数。代码示例：
 */
public class Closure1 {
    int i;

    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}
