package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/19 17:08
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/RecursiveFactorial.java

/**
 * 整数 n 的阶乘将所有小于或等于 n 的正整数相乘。 阶乘函数是一个常见的递归示例：
 */
public class RecursiveFactorial {
    static IntCall fact;
    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for(int i = 0; i <= 10; i++){
            System.out.println(fact.call(i));
        }
    }
}