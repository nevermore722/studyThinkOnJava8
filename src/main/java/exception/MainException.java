package exception;
// exceptions/MainException.java

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/20 16:01
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class MainException {

  /**
   * 对于简单的程序，比如本书中的许多例子，最简单而又不用写多少代码就能保护异常信息的方法，就是把它们从 main() 传递到控制台。例如，为了读取信息而打开一个文件（在第 12
   * 章将详细介绍），必须对 FilelnputStream 进行打开和关闭操作，这就可能会产生异常。对于简单的程序，可以像这样做（本书中很多地方采用了这种方法）：
   *
   *
   * 注意，main() 作为一个方法也可以有异常说明，这里异常的类型是 Exception，它也是所有“被检查的异常”的基类。通过把它传递到控制台，就不必在 main() 里写
   * try-catch 子句了。（不过，实际的文件输人输出操作比这个例子要复杂得多。你将会在 文件 和 附录：I/O 流 章节中学到更多）
   */
  // Pass exceptions to the console:
  public static void main(String[] args) throws Exception {
    // Open the file:
    List<String> lines = Files
        .readAllLines(Paths.get("src/main/java/exception/MainException.java"));
    // Use the file ...
  }

}
