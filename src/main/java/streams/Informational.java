package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/30 11:15
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * count()：流中的元素个数。
 * max(Comparator)：根据所传入的 Comparator 所决定的“最大”元素。
 * min(Comparator)：根据所传入的 Comparator 所决定的“最小”元素。
 * 字符串类型有预先定义好的 Comparator，这简化了我们的示例：
 *
 * min() 和 max() 的返回类型为 Optional，这需要我们使用 orElse()来解包。
 */
public class Informational {

  public static void main(String[] args) throws Exception {
    System.out.println(FileToWords.stream("./src/main/java/streams/Cheese.dat").count());
    System.out.println(FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .min(String.CASE_INSENSITIVE_ORDER)
        .orElse("NONE"));
    System.out.println(FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .max(String.CASE_INSENSITIVE_ORDER)
        .orElse("NONE"));
  }

}
