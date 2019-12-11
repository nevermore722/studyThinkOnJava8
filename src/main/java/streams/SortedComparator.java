package streams;

import java.util.Comparator;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 18:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/SortedComparator.java

/**
 * 在 Randoms.java 中，我们熟识了 sorted() 的默认比较器实现。其实它还有另一种形式的实现：传入一个 Comparator 参数。代码示例：
 *
 * sorted() 预设了一些默认的比较器。这里我们使用的是反转“自然排序”。当然你也可以把 Lambda 函数作为参数传递给 sorted()。
 *
 */
public class SortedComparator {

  public static void main(String[] args) throws Exception {
    FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .skip(10)
        .limit(10)
        .sorted(Comparator.reverseOrder())
        .map(w -> w + " ")
        .forEach(System.out::print);
  }
}
