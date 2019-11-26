package streams;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/10/22 17:33
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Bubble {
    public final int i;

    public Bubble(int n) {
        i = n;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")";
    }

    private static int count = 0;
    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}
