package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 15:23
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 我们可以使用匿名内部类重写之前的例子:
 * <p>
 * 实际上只要有内部类，就会有闭包（Java 8 只是简化了闭包操作）。在 Java 8 之前，变量 x 和 i 必须被明确声明为 final。在 Java 8 中，内部类的规则放宽，包括等同 final 效果。
 */
public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        //同样规则的应用
        //i++; //非等同 final 效果
        // x++; //同上
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
