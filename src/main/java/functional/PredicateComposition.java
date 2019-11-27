package functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/27 16:55
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/PredicateComposition.java

/**
 * p4 获取到了所有断言并组合成一个更复杂的断言。解读：如果字符串中不包含 bar 且长度小于 5，或者它包含 foo ，则结果为 true。
 *
 * 正因它产生如此清晰的语法，我在主方法中采用了一些小技巧，并借用了下一章的内容。首先，我创建了一个字符串对象的流，然后将每个对象传递给 filter() 操作。 filter() 使用 p4 的断言来确定对象的去留。最后我们使用 forEach() 将 println 方法引用应用在每个留存的对象上。
 *
 * 从输出结果我们可以看到 p4 的工作流程：任何带有 foo 的东西都会留下，即使它的长度大于 5。 fongopuckey 因长度超出和不包含 bar 而被丢弃。
 */
public class PredicateComposition {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar", "foobar", "foobaz", "fongopuckey")
                .filter(p4)
                .forEach(System.out::println);
    }
}
