package functional;

import java.util.function.IntSupplier;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 14:24
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 但是，仔细考虑一下，i 的这种用法并非是个大难题，因为对象很可能在你调用 makeFun() 之后就存在了——实际上，垃圾收集器几乎肯定会保留一个对象，并将现有的函数以这种方式绑定到该对象上[^5]。当然，如果你对同一个对象多次调用 makeFun() ，你最终会得到多个函数，它们共享 i 的存储空间：
 */
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}
