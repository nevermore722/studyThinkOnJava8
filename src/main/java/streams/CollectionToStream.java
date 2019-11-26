package streams;

import java.util.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/10/22 17:43
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 在创建 List<Bubble> 对象之后，我们只需要简单地调用所有集合中都有的 stream()。中间操作 map() 会获取流中的所有元素，并且对流中元素应用操作从而产生新的元素，并将其传递到后续的流中。通常 map() 会获取对象并产生新的对象，但在这里产生了特殊的用于数值类型的流。例如，mapToInt() 方法将一个对象流（object stream）转换成为包含整型数字的 IntStream。同样，针对 Float 和 Double 也有类似名字的操作。
 * <p>
 * 我们通过调用字符串的 split()（该方法会根据参数来拆分字符串）来获取元素用于定义变量 w。稍后你会知道 split() 参数可以是十分复杂，但在这里我们只是根据空格来分割字符串。
 * <p>
 * 为了从 Map 集合中产生流数据，我们首先调用 entrySet() 产生一个对象流，每个对象都包含一个 key 键以及与其相关联的 value 值。然后分别调用 getKey() 和 getValue() 获取值。
 */
public class CollectionToStream {
    public static void main(String[] args) {
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(bubbles.stream()
                .mapToInt(b -> b.i)
                .sum());

        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + "")
                .forEach(System.out::print);
        System.out.println();

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue())
                .forEach(System.out::println);

    }
}
