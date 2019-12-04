package functional;

import java.util.function.Function;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/4 15:20
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/CurryingAndPartials.java
public class CurryingAndPartials {

  // 未柯里化：
  static String uncurried(String a, String b) {
    return a + b;
  }

  /**
   * 柯里化（Currying）的名称来自于其发明者之一 Haskell Curry。他可能是计算机领域唯一名字被命名重要概念的人（另外就是 Haskell 编程语言）。
   * 柯里化意为：将一个多参数的函数，转换为一系列单参数函数。
   */
  public static void main(String[] args) {
    // 柯里化的函数：
    Function<String, Function<String, String>> sum = a -> b -> a + b; // [1]

    System.out.println(uncurried("Hi", "Ho"));

    Function<String, String> hi = sum.apply("Hi"); // [2]
    System.out.println(hi.apply("Ho"));

    //部分应用：
    Function<String, String> sumHi = sum.apply("Hup ");
    System.out.println(sumHi.apply("Ho"));
    System.out.println(sumHi.apply("Hey"));
  }
  /**
   * [1] 这一连串的箭头很巧妙。注意，在函数接口声明中，第二个参数是另一个函数。
   *
   * [2] 柯里化的目的是能够通过提供一个参数来创建一个新函数，所以现在有了一个“带参函数”和剩下的 “无参函数” 。实际上，你从一个双参数函数开始，最后得到一个单参数函数。
   */
}
