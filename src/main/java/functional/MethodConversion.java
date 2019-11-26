package functional;

import java.util.function.BiConsumer;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/25 15:38
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/MethodConversion.java


class In1 {
}

class In2 {
}

/**
 * 查看 BiConsumer 的文档，你会看到 accept() 方法。 实际上，如果我们将方法命名为 accept()，它就可以作为方法引用。 但是我们也可用不同的名称，比如 someOtherName()。只要参数类型、返回类型与 BiConsumer 的 accept() 相同即可。
 *
 * 因此，在使用函数接口时，名称无关紧要——只要参数类型和返回类型相同。 Java 会将你的方法映射到接口方法。 要调用方法，可以调用接口的函数式方法名（在本例中为 accept()），而不是你的方法名。
 */
public class MethodConversion {
    static void accept(In1 i1, In2 i2) {
        System.out.println("accept()");
    }

    static void someOtherName(In1 i1, In2 i2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        BiConsumer<In1, In2> bic;
        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        bic = MethodConversion::someOtherName;
        //bic.someOtherName(new In1(),new In2()); //Nope
        bic.accept(new In1(), new In2());
    }

}
