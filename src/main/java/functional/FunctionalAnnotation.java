package functional;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/11/22 17:43
 * @description：
 * @modified By：
 * @version: 1.0
 */
// functional/FunctionalAnnotation.java

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/
public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye," + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        // Functional fac = fa; // Incompatible
        Functional f1 = a -> "Goodbye," + a;
        FunctionalNoAnn fnal = a -> "Goodbye," + a;
    }
}
