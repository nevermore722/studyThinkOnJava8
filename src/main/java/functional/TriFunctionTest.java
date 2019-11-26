package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/26 17:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/TriFunctionTest.java
/**
 * 简单测试，验证它是否有效
 */
public class TriFunctionTest {
    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf =
                TriFunctionTest::f;
        tf = (i, l, d) -> 12;
    }
}
