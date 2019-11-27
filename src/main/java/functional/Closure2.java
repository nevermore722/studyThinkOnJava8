package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:27
 * @description：
 * @modified By：
 * @version: 1.0
 */

// functional/Closure2.java

/**
 * 每次调用 getAsInt() 都会增加 i，表明存储是共享的。
 * <p>
 * 如果 i 是 makeFun() 的局部变量怎么办？ 在正常情况下，当 makeFun() 完成时 i 就消失。 但它仍可以编译：
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}
