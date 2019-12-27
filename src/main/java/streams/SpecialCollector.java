package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 16:27
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 在大多数情况下，你可以在 java.util.stream.Collectors寻找到你想要的预先定义好的 Collector。在少数情况下当你找不到想要的时候，你可以使用第二种形式的
 * collect()。 我基本上把它留作更高级的练习，但是这里有一个例子给出了基本想法：
 */
public class SpecialCollector {

  public static void main(String[] args) throws Exception {
    ArrayList<String> words = FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    words.stream()
        .filter(s -> s.equals("cheese"))
        .forEach(System.out::println);
  }
  /**
   * 在这里， ArrayList 的方法已经执行了你所需要的操作，但是似乎更有可能的是，如果你必须使用这种形式的 collect()，则必须自己创建特殊的定义。
   */
}
