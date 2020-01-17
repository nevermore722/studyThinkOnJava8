package exception;
// exceptions/StormyInning.java
// Overridden methods can throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/17 17:19
 * @description：
 * @modified By：
 * @version: 1.0
 */
class BaseballException extends Exception {

}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

abstract class Inning {

  Inning() throws BaseballException {

  }

  public void event() throws BaseballException {
    // Doesn't actually have to throw anything
  }

  public abstract void atBat() throws Strike, Foul;

  // Throws no checked exceptions
  public void walk() {

  }
}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

class PopFoul extends Foul {

}

interface Storm {

  void event() throws RainedOut;

  void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

  // OK to add new exceptions for constructors, but you
  // must deal with the base constructor exceptions:
  public StormyInning() throws RainedOut, BaseballException {
  }

  public StormyInning(String s) throws BaseballException {
  }

  // Regular methods must conform to base class:
  //- void walk() throws PopFoul {} //Compile error
  // Interface CANNOT add exceptions to existing
  // methods from the base class:
  //- public void event() throws RainedOut {}
  // If the method doesn't already exist in the
  // base class, the exception is OK:
  @Override
  public void rainHard() throws RainedOut {

  }

  // You can choose to not throw any exceptions,
  // even if the base version does:
  @Override
  public void event() {

  }

  // Overridden methods can throw inherited exceptions:

  /**
   * 当覆盖方法的时候，只能抛出在基类方法的异常说明里列出的那些异常。这个限制很有用，因为这意味着，若当基类使用的代码应用到其派生类对象的时候，一样能够工作（当然，这是面向对象的基本概念），异常也不例外。
   *
   * 下面例子演示了这种（在编译时）施加在异常上面的限制：
   */
  @Override
  public void atBat() throws PopFoul {
    try {
      StormyInning si = new StormyInning();
      si.atBat();
    } catch (PopFoul e) {
      System.out.println("Pop foul");
    } catch (RainedOut e) {
      System.out.println("Rained out");
    } catch (BaseballException e) {
      System.out.println("Generic baseball exception");
    }
    // Strike not thrown in derived version.
    try {
      // What happens if you upcast?
      Inning i = new StormyInning();
      i.atBat();
      // You must catch the exceptions from the
      // base-class version of the method:
    } catch (Strike e) {
      System.out.println("Strike");
    } catch (Foul e) {
      System.out.println("Foul");
    } catch (RainedOut e) {
      System.out.println("Rained out");
    } catch (BaseballException e) {
      System.out.println("Generic baseball exception");
    }
  }
  /**
   * 在 Inning 类中，可以看到构造器和 event() 方法都声明将抛出异常，但实际上没有抛出。这种方式使你能强制用户去捕获可能在覆盖后的 event() 版本中增加的异常，所以它很合理。这对于抽象方法同样成立，比如 atBat()。
   *
   * 接口 Storm 包含了一个在 Inning 中定义的方法 event() 和一个不在 Inning 中定义的方法 rainHard()。这两个方法都抛出新的异常 RainedOut，如果 StormyInning 类在扩展 Inning 类的同时又实现了 Storm 接口，那么 Storm 里的 event() 方法就不能改变在 Inning 中的 event（方法的异常接口。否则的话，在使用基类的时候就不能判断是否捕获了正确的异常，所以这也很合理。当然，如果接口里定义的方法不是来自于基类，比如 rainHard()，那么此方法抛出什么样的异常都没有问题。
   *
   * 异常限制对构造器不起作用。你会发现 StormyInning 的构造器可以抛出任何异常，而不必理会基类构造器所抛出的异常。然而，因为基类构造器必须以这样或那样的方式被调用（这里默认构造器将自动被调用），派生类构造器的异常说明必须包含基类构造器的异常说明。
   *
   * 派生类构造器不能捕获基类构造器抛出的异常。
   *
   * StormyInning.walk() 不能通过编译是因为它抛出了异常，而 Inning.walk() 并没有声明此异常。如果编译器允许这么做的话，就可以在调用 Inning.walk() 的时候不用做异常处理了，而且当把它替换成 Inning 的派生类的对象时，这个方法就有可能会抛出异常，于是程序就失灵了。通过强制派生类遵守基类方法的异常说明，对象的可替换性得到了保证。
   *
   * 覆盖后的 event() 方法表明，派生类方法可以不抛出任何异常，即使它是基类所定义的异常。同样这是因为，假使基类的方法会抛出异常，这样做也不会破坏已有的程序，所以也没有问题。类似的情况出现在 atBat() 身上，它抛出的是 PopFoul，这个异常是继承自“会被基类的 atBat() 抛出”的 Foul，这样，如果你写的代码是同 Inning 打交道，并且调用了它的 atBat() 的话，那么肯定能捕获 Foul，而 PopFoul 是由 Foul 派生出来的，因此异常处理程序也能捕获 PopFoul。
   *
   * 最后一个值得注意的地方是 main()。这里可以看到，如果处理的刚好是 Stormylnning 对象的话，编译器只会强制要求你捕获这个类所抛出的异常。但是如果将它向上转型成基类型，那么编译器就会（正确地）要求你捕获基类的异常。所有这些限制都是为了能产生更为强壮的异常处理代码。
   *
   * 尽管在继承过程中，编译器会对异常说明做强制要求，但异常说明本身并不属于方法类型的一部分，方法类型是由方法的名字与参数的类型组成的。因此，不能基于异常说明来重载方法。此外，一个出现在基类方法的异常说明中的异常，不一定会出现在派生类方法的异常说明里。这点同继承的规则明显不同，在继承中，基类的方法必须出现在派生类里，换句话说，在继承和覆盖的过程中，某个特定方法的“异常说明的接口”不是变大了而是变小了——这恰好和类接口在继承时的情形相反。
   */
}


