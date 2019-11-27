package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:41
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure4.java

/**
 * x 和 i 的操作都犯了同样的错误：从 Lambda 表达式引用的局部变量必须是 final 或者是等同 final 效果的。
 *
 * 如果使用 final 修饰 x和 i，就不能再递增它们的值了。代码示例：
 */
public class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}
