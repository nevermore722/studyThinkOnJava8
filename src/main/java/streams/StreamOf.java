package streams;

// streams/StreamOf.java
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/10/22 17:30
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 你可以通过 Stream.of() 很容易地将一组元素转化成为流
 */
public class StreamOf {
    public static void main(String[] args) {
        Stream.of(new Bubble(1),new Bubble(2),new Bubble(3))
                .forEach(System.out::println);
        Stream.of("It's ","a ","wonderful ","day ","for ","pie!")
                .forEach(System.out::print);
        System.out.println();
        Stream.of(3.14159,2.718,1.618)
                .forEach(System.out::println);
    }
}
