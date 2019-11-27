package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 10:33
 * @description：
 * @modified By：
 * @version: 1.0
 */

// functional/ConsumeFunction.java

import java.util.function.Function;

/**
 * 要消费一个函数，消费函数需要在参数列表正确地描述函数类型。代码示例：
 */
class One {
}

class Two {
}

public class ConsumeFunction {
    static Two consume(Function<One, Two> onetwo) {
        return onetwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
