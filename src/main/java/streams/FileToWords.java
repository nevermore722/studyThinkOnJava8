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
public class FileToWords {

  public static Stream<String> stream(String filePath) throws Exception {
    return Files.lines(Paths.get(filePath))
        .skip(1)  // First (comment) line
        .flatMap(line ->
            Pattern.compile("\\W+").splitAsStream(line));
  }

}
