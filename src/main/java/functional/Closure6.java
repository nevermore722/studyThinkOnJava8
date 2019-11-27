package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:48
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.function.IntSupplier;

/**
 * 等同 final 效果意味着可以在变量声明前加上 final 关键字而不用更改任何其余代码。 实际上它就是具备 final 效果的，只是没有明确说明。
 * <p>
 * 通过在闭包中使用 final 关键字提前修饰变量 x 和 i ， 我们解决了 Closure5.java 中的问题。代码示例：
 */
// functional/Closure6.java
public class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}
