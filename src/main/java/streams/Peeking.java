package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 17:55
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Peeking.java

/**
 * peek() 操作的目的是帮助调试。它允许你无修改地查看流中的元素。代码示例：
 */
public class Peeking {

  public static void main(String[] args) throws Exception {
    FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .skip(21)
        .limit(4)
        .map(w -> w + " ")
        .peek(System.out::print)
        .map(String::toUpperCase)
        .peek(System.out::print)
        .map(String::toLowerCase)
        .forEach(System.out::print);
  }

}
