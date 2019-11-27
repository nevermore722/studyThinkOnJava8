package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:43
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure5.java

// {无法编译成功}

/**
 * 那么为什么在 Closure2.java 中， x 和 i 非 final 却可以运行呢？
 *
 * 这就叫做等同 final 效果（Effectively Final）。这个术语是在 Java 8 才开始出现的，表示虽然没有明确地声明变量是 final 的，但是因变量值没被改变过而实际有了 final 同等的效果。 如果局部变量的初始值永远不会改变，那么它实际上就是 final 的。
 *
 * 如果 x 和 i 的值在方法中的其他位置发生改变（但不在返回的函数内部），则编译器仍将视其为错误。每个递增操作则会分别产生错误消息。代码示例：
 */
public class Closure5 {
//    IntSupplier makeFun(int x){
//        int i = 0;
//        i++;
//        x++;
//        return () -> x+i;
//    }
}
