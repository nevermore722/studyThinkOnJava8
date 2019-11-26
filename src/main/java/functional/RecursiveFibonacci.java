package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/19 17:29
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/RecursiveFibonacci.java

/**
 * 我们可以将 Fibonacci 序列改为使用递归 Lambda 表达式来实现，这次使用实例变量：
 */
public class RecursiveFibonacci {
    IntCall fib;

    /**
     * 将 Fibonacci 序列中的最后两个元素求和来产生下一个元素。
     *
     */
    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) { return fib.call(n); }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for(int i = 0; i <= 10; i++){
            System.out.println(rf.fibonacci(i));
        }
    }
}
