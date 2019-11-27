package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 15:06
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Closure9.java

// {无法编译成功}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 下面我们来看看 Closure7.java 和 Closure8.java 之间的区别。我们看到：在 Closure7.java 中变量 i 有过重新赋值。 也许这就是等同 final 效果错误消息的触发点。
 */
public class Closure9 {
//    Supplier<List<Integer>> makeFun() {
//        List<Integer> ai = new ArrayList<>();
//        ai = new ArrayList<>(); //Reassignment
//        return () -> ai;
//    }
    /**
     * 上例，重新赋值引用会触发错误消息。如果只修改指向的对象则没问题，只要没有其他人获得对该对象的引用（这意味着你有多个实体可以修改对象，此时事情会变得非常混乱），基本上就是安全的[^6]。
     *
     * 让我们回顾一下 Closure1.java。那么现在问题来了：为什么变量 i 被修改编译器却没有报错呢。 它既不是 final 的，也不是等同 final 效果的。因为 i 是外围类的成员，所以这样做肯定是安全的（除非你正在创建共享可变内存的多个函数）。是的，你可以辩称在这种情况下不会发生变量捕获（Variable Capture）。但可以肯定的是，Closure3.java 的错误消息是专门针对局部变量的。因此，规则并非只是“在 Lambda 之外定义的任何变量必须是 final 的或等同 final 效果那么简单。相反，你必须考虑捕获的变量是否是等同 final 效果的。 如果它是对象中的字段，那么它拥有独立的生存周期，并且不需要任何特殊的捕获，以便稍后在调用 Lambda 时存在。
     */
}
