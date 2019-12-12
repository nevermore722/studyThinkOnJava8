package streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 17:56
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * stream() 现在是一个静态方法，因为它可以自己完成整个流创建过程。
 *
 * 注意：\\W+ 是一个正则表达式。他表示“非单词字符”，+ 表示“可以出现一次或者多次”。小写形式的 \\w 表示“单词字符”。
 */
public class FileToWords {

  public static Stream<String> stream(String filePath) throws Exception {
    return Files.lines(Paths.get(filePath))
        .skip(1)  // First (comment) line
        .flatMap(line ->
            Pattern.compile("\\W+").splitAsStream(line));
  }

}
