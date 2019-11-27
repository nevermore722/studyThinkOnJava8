package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:52
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure7.java

// {无法编译成功}

/**
 * 上例中 iFinal 和 xFinal 的值在赋值后并没有改变过，因此在这里使用 final 是多余的。
 * <p>
 * 如果这里是引用的话，需要把 int 型更改为 Integer 型。代码示例：
 */
public class Closure7 {
//    IntSupplier makeFun(int x) {
//        Integer i = 0;
//        i = i + 1;
//        return () -> x + i;
//    }
}
