package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/22 14:32
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/UnboundMethodReference.java

// 没有方法引用的对象

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

/**
 *
 * 未绑定的方法引用是指没有关联对象的普通（非静态）方法。 使用未绑定的引用之前，我们必须先提供对象：
 *
 *
 * 截止目前，我们已经知道了与接口方法同名的方法引用。 在 [1]，我们尝试把 X 的 f() 方法引用赋值给 MakeString。结果：即使 make() 与 f() 具有相同的签名，编译也会报“invalid method reference”（无效方法引用）错误。 这是因为实际上还有另一个隐藏的参数：我们的老朋友 this。 你不能在没有 X 对象的前提下调用 f()。 因此，X :: f 表示未绑定的方法引用，因为它尚未“绑定”到对象。
 *
 * 要解决这个问题，我们需要一个 X 对象，所以我们的接口实际上需要一个额外的参数的接口，如上例中的 TransformX。 如果将 X :: f 赋值给 TransformX，这在 Java 中是允许的。这次我们需要调整下心里预期——使用未绑定的引用时，函数方法的签名（接口中的单个方法）不再与方法引用的签名完全匹配。 理由是：你需要一个对象来调用方法。
 *
 * [2] 的结果有点像脑筋急转弯。 我接受未绑定的引用并对其调用 transform()，将其传递给 X，并以某种方式导致对 x.f() 的调用。 Java 知道它必须采用第一个参数，这实际上就是 this，并在其上调用方法。
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
//        MakeString ms = X::f; //[1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));//[2]
        System.out.println(x.f());//同等效果
    }
}
