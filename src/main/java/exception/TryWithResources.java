package exception;
// exceptions/TryWithResources.java

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 11:33
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 幸运的是，Java 7 引入了 try-with-resources 语法，它可以非常清楚地简化上面的代码：
 *
 * 在 Java 7 之前，try 总是后面跟着一个 {，但是现在可以跟一个带括号的定义 - 这里是我们创建的 FileInputStream 对象。括号内的部分称为资源规范头（resource
 * specification header）。现在可用于整个 try 块的其余部分。更重要的是，无论你如何退出 try 块（正常或异常），都会执行前一个 finally
 * 子句的等价物，但不会编写那些杂乱而棘手的代码。这是一项重要的改进。
 */
public class TryWithResources {

  public static void main(String[] args) {
    try (InputStream in = new FileInputStream(
        new File("src/maim/java/exception/TryWithResources.java"))
    ) {
      int contents = in.read();
      //Process contents
    } catch (IOException e) {
      //Handle the error
    }
  }

}
