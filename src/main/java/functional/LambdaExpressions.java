package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/19 16:57
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/LambdaExpressions.java

/**
 * Lambda 表达式是使用最小可能语法编写的函数定义：
 *
 * Lambda 表达式产生函数，而不是类。 在 JVM（Java Virtual Machine，Java 虚拟机）上，一切都是一个类，因此在幕后执行各种操作使 Lambda 看起来像函数 —— 但作为程序员，你可以高兴地假装它们“只是函数”。
 *
 * Lambda 语法尽可能少，这正是为了使 Lambda 易于编写和使用。
 *
 * 我们在 Strategize.java 中看到了一个 Lambda 表达式，但还有其他语法变体：
 */
interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LambdaExpressions {

    static Body bod = h -> h + " No Parens!"; // [1]

    static Body bod2 = (h) -> h + " More details"; // [2]

    static Description desc = () -> "Short info"; // [3]

    static Multi mult = (h, n) -> h + n; // [4]

    static Description moreLines = () -> { // [5]
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
/**
 我们从三个接口开始，每个接口都有一个单独的方法（很快就会理解它的重要性）。但是，每个方法都有不同数量的参数，以便演示 Lambda 表达式语法。

 任何 Lambda 表达式的基本语法是：

 参数。

 接着 ->，可视为“产出”。

 -> 之后的内容都是方法体。

 [1] 当只用一个参数，可以不需要括号 ()。 然而，这是一个特例。

 [2] 正常情况使用括号 () 包裹参数。 为了保持一致性，也可以使用括号 () 包裹单个参数，虽然这种情况并不常见。

 [3] 如果没有参数，则必须使用括号 () 表示空参数列表。

 [4] 对于多个参数，将参数列表放在括号 () 中。

 到目前为止，所有 Lambda 表达式方法体都是单行。 该表达式的结果自动成为 Lambda 表达式的返回值，在此处使用 return 关键字是非法的。 这是 Lambda 表达式缩写用于描述功能的语法的另一种方式。

 [5] 如果在 Lambda 表达式中确实需要多行，则必须将这些行放在花括号中。 在这种情况下，就需要使用 return。

 Lambda 表达式通常比匿名内部类产生更易读的代码，因此我们将在本书中尽可能使用它们。
 */