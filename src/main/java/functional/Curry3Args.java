package functional;

import java.util.function.Function;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/4 15:50
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/Curry3Args.java
/**
 * 我们可以通过添加级别来柯里化一个三参数函数
 */
public class Curry3Args {


  public static void main(String[] args) {
    /**
     * 对于每个级别的箭头级联（Arrow-cascading），你在类型声明中包裹了另一个 Function。
     */
    Function<String, Function<String, Function<String, String>>> sum = a -> b -> c -> a + b + c;
    Function<String, Function<String, String>> hi = sum.apply("Hi ");
    Function<String, String> ho = hi.apply("Ho ");
    System.out.println(ho.apply("Hup"));
  }

}
