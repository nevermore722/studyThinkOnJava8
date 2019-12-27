package streams;
// streams/TreeSetOfWords.java

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/27 15:28
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * collect(Collector)：使用 Collector 收集流元素到结果集合中。 collect(Supplier, BiConsumer, BiConsumer)：同上，第一个参数
 * Supplier 创建了一个新结果集合，第二个参数 BiConsumer 将下一个元素包含到结果中，第三个参数 BiConsumer 用于将两个值组合起来。 在这里我们只是简单介绍了几个
 * Collectors 的运用示例。实际上，它还有一些非常复杂的操作实现，可通过查看 java.util.stream.Collectors 的 API
 * 文档了解。例如，我们可以将元素收集到任意一种特定的集合中。
 *
 * 假设我们现在为了保证元素有序，将元素存储在 TreeSet 中。Collectors 里面没有特定的 toTreeSet()，但是我们可以通过将集合的构造函数引用传递给
 * Collectors.toCollection()，从而构建任何类型的集合。下面我们来将一个文件中的单词收集到 TreeSet 集合中。代码示例：
 */
public class TreeSetOfWords {

  public static void main(String[] args) throws Exception {
    Set<String> words2 = Files.lines(Paths.get("src/main/java/streams/TreeSetOfWords.java"))
        .flatMap(s -> Arrays.stream(s.split("\\W+")))
        .filter(s -> !s.matches("\\d+"))  //No numbers
        .map(String::trim)
        .filter(s -> s.length() > 2)
        .limit(100)
        .collect(Collectors.toCollection(TreeSet::new));
    System.out.println(words2);
  }
  /**
   * Files.lines() 打开 Path 并将其转换成为行流。下一行代码将匹配一个或多个非单词字符（\\w+）行进行分割，然后使用 Arrays.stream() 将其转化成为流，并将结果扁平映射成为单词流。使用 matches(\\d+) 查找并移除全数字字符串（注意,words2 是通过的）。接下来我们使用 String.trim() 去除单词两边的空白，filter() 过滤所有长度小于3的单词，紧接着只获取100个单词，最后将其保存到 TreeSet 中。
   */
  //注意运行情况和书本里面不一样，因为这份代码里面加了注释
}
