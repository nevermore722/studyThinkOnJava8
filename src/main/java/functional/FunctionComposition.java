package functional;

import java.util.function.Function;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 15:39
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/FunctionComposition.java

/**
 * 下例使用了 Function 里的 compose()和 andThen()。代码示例：
 * <p>
 * 这里我们重点看正在创建的新函数 f4。它调用 apply() 的方式与常规几乎无异[^8]。
 */
public class FunctionComposition {
    static Function<String, String>
            f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
            f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(
                f4.apply("GO AFTER ALL AMBULANCES"));
    }
}