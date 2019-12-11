package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 11:20
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 在建造者设计模式（也称构造器模式）中，首先创建一个 builder 对象，传递给它多个构造器信息，最后执行“构造”。Stream 库提供了这样的 Builder。在这里，我们重新审视文件读取并将其转换成为单词流的过程。代码示例：
 *
 * 注意，构造器会添加文件中的所有单词（除了第一行，它是包含文件路径信息的注释），但是其并没有调用 build()。只要你不调用 stream() 方法，就可以继续向 builder 对象中添加单词。
 *
 * 在该类的更完整形式中，你可以添加一个标志位用于查看 build() 是否被调用，并且可能的话增加一个可以添加更多单词的方法。在 Stream.Builder 调用 build() 方法后继续尝试添加单词会产生一个异常。
 */
public class FileToWordsBuilder {

  Stream.Builder<String> builder = Stream.builder();

  public FileToWordsBuilder(String filePath) throws Exception {
    Files.lines(Paths.get(filePath))
        .skip(1) // 略过开头的注释行
        .forEach(line -> {
          for (String w : line.split("[ .?,]+")) {
            builder.add(w);
          }
        });
  }

  Stream<String> stream() {
    return builder.build();
  }

  public static void main(String[] args) throws Exception {
    //书上为  new FileToWordsBuilder("Cheese.dat")    目前采用的是相对于工程的相对路径，应该与编译路径有关
    new FileToWordsBuilder("./src/main/java/streams/Cheese.dat")
        .stream()
        .limit(7)
        .map(w -> w + " ")
        .forEach(System.out::print);
  }
}
