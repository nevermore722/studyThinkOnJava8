package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:29
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure3.java

// {WillNotCompile}

/**
 * 由 makeFun() 返回的 IntSupplier “关闭” i 和 x，因此当你调用返回的函数时两者仍然有效。 但请注意，我没有像 Closure1.java 那样递增 i，因为会产生编译时错误。代码示例：
 */
public class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
/*        // x++ 和 i++ 都会报错
        return () -> x++ + i++;*/
        return null;
    }
}
