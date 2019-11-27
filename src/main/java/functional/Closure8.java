package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:59
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure8.java

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 编译器非常智能，它能识别变量 i 的值被更改过了。 对于包装类型的处理可能比较特殊，因此我们尝试下 List：
 */

/**
 * 可以看到，这次一切正常。我们改变了 List 的值却没产生编译时错误。通过观察本例的输出结果，我们发现这看起来非常安全。这是因为每次调用 makeFun() 时，其实都会创建并返回一个全新的 ArrayList。 也就是说，每个闭包都有自己独立的 ArrayList， 它们之间互不干扰。
 *
 * 请注意我已经声明 ai 是 final 的了。尽管在这个例子中你可以去掉 final 并得到相同的结果（试试吧！）。 应用于对象引用的 final 关键字仅表示不会重新赋值引用。 它并不代表你不能修改对象本身。
 */
public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }


    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer>
                l1 = c7.makeFun().get(),
                l2 = c7.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
