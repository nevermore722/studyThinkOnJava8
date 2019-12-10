package streams;

import static onjava.Repeat.*;
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/10 19:35
 * @description：
 * @modified By：
 * @version: 1.0
 */
// streams/Looping.java

/**
 * 其产生的循环更加清晰：
 *
 * 原则上，在代码中包含并解释 repeat() 并不值得。诚然它是一个相当透明的工具，但结果取决于你的团队和公司的运作方式。
 */
public class Looping {
  static void hi(){
    System.out.println("Hi!");
  }

  public static void main(String[] args) {
    repeat(3,()-> System.out.println("Looping!"));
    repeat(2,Looping::hi);
  }
}
