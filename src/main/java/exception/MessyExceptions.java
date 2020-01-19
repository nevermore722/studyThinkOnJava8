package exception;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 11:24
 * @description：
 * @modified By：
 * @version: 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 你不能总是轻易地回避这个问题。有时会有以下问题：
 *
 * 需要资源清理 需要在特定的时刻进行资源清理，比如你离开作用域的时候（在通常情况下意味着通过异常进行清理）。 一个常见的例子是 jav.io.FileInputstream（将会在 附录：I/O
 * 流 中提到）。要正确使用它，你必须编写一些棘手的样板代码：
 */
public class MessyExceptions {

  public static void main(String[] args) {
    InputStream in = null;
    try {
      in = new FileInputStream(new File("src/main/java/exception/MessyException.java"));
      int contents = in.read();
      // Process contents
    } catch (IOException e) {
      // Handle the error
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          // Handle the close() error
        }
      }
    }
  }

}
