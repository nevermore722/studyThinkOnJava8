package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 10:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/ProduceFunction.java

import java.util.function.Function;

/**
 * 这个名字可能听起来令人生畏，但是：高阶函数（Higher-order Function）只是一个消费或产生函数的函数。
 * <p>
 * 我们先来看看如何产生一个函数：
 */

interface FuncSS extends Function<String, String> {
}//[1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); //[2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
    /**
     * 这里，produce() 是高阶函数。
     *
     * [1] 使用继承，可以轻松地为专用接口创建别名。
     *
     * [2] 使用 Lambda 表达式，可以轻松地在方法中创建和返回一个函数。
     */
}
