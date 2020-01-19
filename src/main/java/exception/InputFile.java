package exception;

// exceptions/InputFile.java
// Paying attention to exceptions in constructors

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 10:01
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 有一点很重要，即你要时刻询问自己“如果异常发生了，所有东西能被正确的清理吗？"尽管大多数情况下是非常安全的，但涉及构造器时，问题就出现了。构造器会把对象设置成安全的初始状态，但还会有别的动作，比如打开一个文件，这样的动作只有在对象使用完毕并且用户调用了特殊的清理方法之后才能得以清理。如果在构造器内抛出了异常，这些清理行为也许就不能正常工作了。这意味着在编写构造器时要格外细心。
 *
 * 你也许会认为使用 finally 就可以解决问题。但问题并非如此简单，因为 finally 会每次都执行清理代码。如果构造器在其执行过程中半途而废，也许该对象的某些部分还没有被成功创建，而这些部分在 finaly 子句中却是要被清理的。
 *
 * 在下面的例子中，建立了一个 InputFile 类，它能打开一个文件并且每次读取其中的一行。这里使用了 Java 标准输入/输出库中的 FileReader 和 BufferedReader 类（将在 附录：I/O 流 中讨论），这些类的基本用法很简单，你应该很容易明白：
 */
public class InputFile {

  private BufferedReader in;

  public InputFile(String fname) throws Exception {
    try {
      in = new BufferedReader(new FileReader(fname));
      // Other code that might throw exceptions
    } catch (FileNotFoundException e) {
      System.out.println("Could bot open " + fname);
      // Wasn't open, so don't close it
      throw e;
    } catch (Exception e) {
      // All other exceptions must close it
      try {
        in.close();
      } catch (IOException e2) {
        System.out.println("in.close() unsuccessful");
      }
      // Rethrow
      throw e;
    } finally {
      // Don't close it here!!!
    }
  }

  public String getLine() {
    String s;
    try {
      s = in.readLine();
    } catch (IOException e) {
      throw new RuntimeException("readLine() failed");
    }
    return s;
  }

  public void dispose() {
    try {
      in.close();
      System.out.println("dispose() successful");
    } catch (IOException e2) {
      throw new RuntimeException("io.close() failed");
    }
  }
}
