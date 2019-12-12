package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/12 17:44
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/FileToWordsTest.java

/**
 * 有了真正的、而非 FileToWordsRegexp.java 中基于集合存储的流，我们每次使用都必须从头创建，因为流并不能被复用：
 */
public class FileToWordsTest {

  public static void main(String[] args) throws Exception {
    FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .limit(7)
        .forEach(s -> System.out.format("%s ", s));
    System.out.println();
    FileToWords.stream("./src/main/java/streams/Cheese.dat")
        .skip(7)
        .limit(2)
        .forEach(s -> System.out.format("%s ", s));
  }

}
