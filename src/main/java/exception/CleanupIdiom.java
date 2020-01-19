package exception;

// exceptions/CleanupIdiom.java
// Disposable objects must be followed by a try-finally

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/19 10:55
 * @description：
 * @modified By：
 * @version: 1.0
 */
// Construction can't fail

/**
 * 请仔细观察这里的逻辑：对 InputFile 对象的构造在其自己的 try 语句块中有效，如果构造失败，将进入外部的 catch 子句，而 dispose() 方法不会被调用。但是，如果构造成功，我们肯定想确保对象能够被清理，因此在构造之后立即创建了一个新的 try 语句块。执行清理的 finally 与内部的 try 语句块相关联。在这种方式中，finally 子句在构造失败时是不会执行的，而在构造成功时将总是执行。
 *
 * 这种通用的清理惯用法在构造器不抛出任何异常时也应该运用，其基本规则是：在创建需要清理的对象之后，立即进入一个 try-finally 语句块：
 *
 * [1] 相当简单，遵循了在可去除对象之后紧跟 try-finally 的原则。如果对象构造不会失败，就不需要任何 catch。
 * [2] 为了构造和清理，可以看到将具有不能失败的构造器的对象分组在一起。
 * [3] 展示了如何处理那些具有可以失败的构造器，且需要清理的对象。为了正确处理这种情况，事情变得很棘手，因为对于每一个构造，都必须包含在其自己的 try-finally 语句块中，并且每一个对象构造必须都跟随一个 try-finally 语句块以确保清理。
 * 本例中的异常处理的棘手程度，对于应该创建不能失败的构造器是一个有力的论据，尽管这么做并非总是可行。
 *
 * 注意，如果 dispose() 可以抛出异常，那么你可能需要额外的 try 语句块。基本上，你应该仔细考虑所有的可能性，并确保正确处理每一种情况。
 */
class NeedsCleanup {

  private static long counter = 1;
  private final long id = counter++;

  public void dispose() {
    System.out.println("NeedsCleanup " + id + " disposed");
  }
}

class ConstructionException extends Exception {

}

class NeedsCleanup2 extends NeedsCleanup {

  // Construction can fail:
  NeedsCleanup2() throws ConstructionException {
  }
}

public class CleanupIdiom {

  public static void main(String[] args) {
    //[1]
    NeedsCleanup nc1 = new NeedsCleanup();
    try {
      //...
    } finally {
      nc1.dispose();
    }
    //[2]
    //If construction cannot fail,
    //you can group objects:
    NeedsCleanup nc2 = new NeedsCleanup();
    NeedsCleanup nc3 = new NeedsCleanup();
    try {
      //...
    } finally {
      //Reverse order of construction
      nc3.dispose();
      nc2.dispose();
    }

    //[3]
    //If construction can fail you must guard each one:
    try {
      NeedsCleanup2 nc4 = new NeedsCleanup2();
      try {
        NeedsCleanup2 nc5 = new NeedsCleanup2();
        try {
          //...
        } finally {
          nc5.dispose();
        }
      } catch (ConstructionException e) {
        // nc5 const.
        System.out.println(e);
      } finally {
        nc4.dispose();
      }
    } catch (ConstructionException e) {
      // nc4 const.
      System.out.println(e);
    }
  }
}
