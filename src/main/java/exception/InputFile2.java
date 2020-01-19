package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 11:17
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 上一节的内容可能让你有些头疼。在考虑所有可能失败的方法时，找出放置所有 try-catch-finally 块的位置变得令人生畏。确保没有任何故障路径，使系统远离不稳定状态，这非常具有挑战性。
 *
 * InputFile.java 是一个特别棘手的情况，因为文件被打开（包含所有可能的异常），然后它在对象的生命周期中保持打开状态。每次调用 getLine() 都会导致异常，因此可以调用
 * dispose() 方法。这是一个很好的例子，因为它显示了事物的混乱程度。它还表明你应该尝试最好不要那样设计代码（当然，你经常会遇到这种你无法选择的代码设计的情况，因此你必须仍然理解它）。
 *
 * InputFile.java 一个更好的实现方式是如果构造函数读取文件并在内部缓冲它 —— 这样，文件的打开，读取和关闭都发生在构造函数中。或者，如果读取和存储文件不切实际，你可以改为生成
 * Stream。理想情况下，你可以设计成如下的样子：
 */
public class InputFile2 {

  private String fname;

  public InputFile2(String fname) {
    this.fname = fname;
  }

  public Stream<String> getLines() throws IOException {
    return Files.lines(Paths.get(fname));
  }

  public static void main(String[] args) throws IOException {
    new InputFile2("src/main/java/exception/InputFile2.java").getLines()
        .skip(37)
        .limit(1)
        .forEach(System.out::println);
  }

}
