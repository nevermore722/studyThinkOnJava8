package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/26 17:47
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/TriFunction.java

/**
 * java.util.functional 中的接口是有限的。比如有了 BiFunction，但它不能变化。 如果需要三参数函数的接口怎么办？ 其实这些接口非常简单，很容易查看 Java 库源代码并自行创建。
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 */
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t,U u,V v);
}
