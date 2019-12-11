package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 15:10
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/FileToWordsRegexp.java

/**
 * Java 的正则表达式将在字符串这一章节详细介绍。Java 8 在 java.util.regex.Pattern 中增加了一个新的方法 splitAsStream()。这个方法可以根据传入的公式将字符序列转化为流。但是有一个限制，输入只能是 CharSequence，因此不能将流作为 splitAsStream() 的参数。
 *
 * 我们再一次查看将文件处理为单词流的过程。这一次，我们使用流将文件分割为单独的字符串，接着使用正则表达式将字符串转化为单词流。
 *
 * 在构造器中我们读取了文件中的所有内容（跳过第一行注释，并将其转化成为单行字符串）。现在，当你调用 stream() 的时候，可以像往常一样获取一个流，但这次你可以多次调用 stream() 在已存储的字符串中创建一个新的流。这里有个限制，整个文件必须存储在内存中；在大多数情况下这并不是什么问题，但是这损失了流操作非常重要的优势：
 *
 * 流“不需要存储”。当然它们需要一些内部存储，但是这只是序列的一小部分，和持有整个序列并不相同。
 * 它们是懒加载计算的。
 * 幸运的是，我们稍后就会知道如何解决这个问题。
 */
public class FileToWordsRegexp {

  private String all;

  public FileToWordsRegexp(String filePath) throws Exception {
    all = Files.lines(Paths.get(filePath))
        .skip(1) // First (comment) line
        .collect(Collectors.joining(" "));
  }

  public Stream<String> stream() {
    // idea提示“在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。”
    return Pattern
        .compile("[ .,?]+").splitAsStream(all);
  }

  public static void
  main(String[] args) throws Exception {
    FileToWordsRegexp fw = new FileToWordsRegexp("./src/main/java/streams/Cheese.dat");
    fw.stream()
        .limit(7)
        .map(w -> w + " ")
        .forEach(System.out::print);
    fw.stream()
        .skip(7)
        .limit(2)
        .map(w -> w + " ")
        .forEach(System.out::print);
  }
}
