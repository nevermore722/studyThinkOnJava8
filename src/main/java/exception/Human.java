package exception;
// exceptions/Human.java
// Catching exception hierarchies

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/20 14:47
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 抛出异常的时候，异常处理系统会按照代码的书写顺序找出“最近”的处理程序。找到匹配的处理程序之后，它就认为异常将得到处理，然后就不再继续查找。
 *
 * 查找的时候并不要求抛出的异常同处理程序所声明的异常完全匹配。派生类的对象也可以匹配其基类的处理程序，就像这样：
 *
 * Sneeze 异常会被第一个匹配的 catch 子句捕获，也就是程序里的第一个。然而如果将这个 catch 子句删掉，只留下 Annoyance 的 catch 子句，该程序仍然能运行，因为这次捕获的是 Sneeze 的基类。换句话说，catch（Annoyance a）会捕获 Annoyance 以及所有从它派生的异常。这一点非常有用，因为如果决定在方法里加上更多派生异常的话，只要客户程序员捕获的是基类异常，那么它们的代码就无需更改。
 */
class Annoyance extends Exception {

}

class Sneeze extends Annoyance {

}

public class Human {

  public static void main(String[] args) {
    //Catch the exact type
    try {
      throw new Sneeze();
    } catch (Sneeze s) {
      System.out.println("Caught Sneeze");
    } catch (Annoyance a) {
      System.out.println("Caught Annoyance");
    }
    //Catch the base type
    try {
      throw new Sneeze();
    } catch (Annoyance a) {
      System.out.println("Caught Annoyance");
    }
    /*
    如果把捕获基类的 catch 子句放在最前面，以此想把派生类的异常全给“屏蔽”掉，就像这样：
    try {
      throw new Sneeze();
    } catch(Annoyance a) {
      // ...
    } catch(Sneeze s) {
      // ...
    }
    此时，编译器会发现 Sneeze 的 catch 子句永远得不到执行，因此它会向你报告错误。
    */
  }

}
