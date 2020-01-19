package exception;
// exceptions/Cleanup.java
// Guaranteeing proper cleanup of a resource

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 10:32
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * InputFile 的构造器接受字符串作为参数，该字符串表示所要打开的文件名。在 try 块中，会使用此文件名建立 FileReader 对象。FileReader 对象本身用处并不大，但可以用它来建立 BufferedReader 对象。注意，使用 InputFile 的好处之一是把两步操作合而为一。
 *
 * 如果 FileReader 的构造器失败了，将抛出 FileNotFoundException 异常。对于这个异常，并不需要关闭文件，因为这个文件还没有被打开。而任何其他捕获异常的 catch 子句必须关闭文件，因为在它们捕获到异常之时，文件已经打开了（当然，如果还有其他方法能抛出 FileNotFoundException，这个方法就显得有些投机取巧了。这时，通常必须把这些方法分别放到各自的 try 块里），close() 方法也可能会抛出异常，所以尽管它已经在另一个 catch 子句块里了，还是要再用一层 try-catch，这对 Java 编译器而言只不过是多了一对花括号。在本地做完处理之后，异常被重新抛出，对于构造器而言这么做是很合适的，因为你总不希望去误导调用方，让他认为“这个对象已经创建完毕，可以使用了”。
 *
 * 在本例中，由于 finally 会在每次完成构造器之后都执行一遍，因此它实在不该是调用 close() 关闭文件的地方。我们希望文件在 InputFlle 对象的整个生命周期内都处于打开状态。
 *
 * getLine() 方法会返回表示文件下一行内容的字符串。它调用了能抛出异常的 readLine()，但是这个异常已经在方法内得到处理，因此 getLine() 不会抛出任何异常。在设计异常时有一个问题：应该把异常全部放在这一层处理；还是先处理一部分，然后再向上层抛出相同的（或新的）异常；又或者是不做任何处理直接向上层抛出。如果用法恰当的话，直接向上层抛出的确能简化编程。在这里，getLine() 方法将异常转换为 RuntimeException，表示一个编程错误。
 *
 * 用户在不再需要 InputFile 对象时，就必须调用 dispose() 方法，这将释放 BufferedReader 和/或 FileReader 对象所占用的系统资源（比如文件句柄），在使用完 InputFile 对象之前是不会调用它的。可能你会考虑把上述功能放到 finalize() 里面，但我在 封装 讲过，你不知道 finalize() 会不会被调用（即使能确定它将被调用，也不知道在什么时候调用），这也是 Java 的缺陷：除了内存的清理之外，所有的清理都不会自动发生。所以必须告诉客户端程序员，这是他们的责任。
 *
 * 对于在构造阶段可能会抛出异常，并且要求清理的类，最安全的使用方式是使用嵌套的 try 子句：
 */
public class Cleanup {

  /**
   * 请仔细观察这里的逻辑：对 InputFile 对象的构造在其自己的 try 语句块中有效，如果构造失败，将进入外部的 catch 子句，而 dispose() 方法不会被调用。但是，如果构造成功，我们肯定想确保对象能够被清理，因此在构造之后立即创建了一个新的 try 语句块。执行清理的 finally 与内部的 try 语句块相关联。在这种方式中，finally 子句在构造失败时是不会执行的，而在构造成功时将总是执行。
   */

  public static void main(String[] args) {
    try {
      InputFile in = new InputFile("src/main/java/exception/Cleanup.java");
      try {
        String s;
        int i = 1;
        while ((s = in.getLine()) != null) {

        }
        ; // Perform line-by-line processing here...
      } catch (Exception e) {
        System.out.println("Caught Exception in main");
        e.printStackTrace(System.out);
      } finally {
        in.dispose();
      }
    } catch (Exception e) {
      System.out.println("InputFile construction failed");
    }
  }

}
