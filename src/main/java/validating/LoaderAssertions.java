package validating;

// validating/LoaderAssertions.java
// Using the class loader to enable assertions
// {ThrowsException}
/**
 * 你还可以通过编程的方式通过链接到类加载器对象（ClassLoader）来控制断言。类加载器中有几种方法允许动态启用和禁用断言，其中 setDefaultAssertionStatus ()
 * ,它为之后加载的所有类设置断言状态。因此，你可以像下面这样悄悄地开启断言：
 */

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 11:33
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class LoaderAssertions {

  public static void main(String[] args) {
    ClassLoader.getSystemClassLoader().
        setDefaultAssertionStatus(true);
    new Loaded().go();
  }

}

class Loaded {

  public void go() {
    assert false : "Loaded.go()";
  }
}
/*
这消除了在运行程序时在命令行上使用 -ea 标志的需要，使用 -ea 标志启用断言可能同样简单。当交付独立产品时，可能必须设置一个执行脚本让用户能够启动程序，配置其他启动参数，这么做是有意义的。然而，决定在程序运行时启用断言可以使用下面的 static 块来实现这一点，该语句位于系统的主类中：

static {
    boolean assertionsEnabled = false;
    // Note intentional side effect of assignment:
    assert assertionsEnabled = true;
    if(!assertionsEnabled)
        throw new RuntimeException("Assertions disabled");
}
如果启用断言，然后执行 assert 语句，assertionsEnabled 变为 true 。断言不会失败，因为分配的返回值是赋值的值。如果不启用断言，assert 语句不执行，assertionsEnabled 保持false，将导致异常。
*/

