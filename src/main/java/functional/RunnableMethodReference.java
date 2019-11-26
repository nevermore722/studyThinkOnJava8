package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/19 18:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/RunnableMethodReference.java

// 方法引用与 Runnable 接口的结合使用

/**
 * Runnable 接口自 1.0 版以来一直在 Java 中，因此不需要导入。它也符合特殊的单方法接口格式：它的方法 run() 不带参数，也没有返回值。因此，我们可以使用 Lambda 表达式和方法引用作为 Runnable：
 *
 *  Thread 对象将 Runnable 作为其构造函数参数，并具有会调用 run() 的方法 start()。 注意，只有匿名内部类才需要具有名为 run() 的方法。
 */
class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("lambda")
        ).start();

        new Thread(Go::go).start();
    }
}