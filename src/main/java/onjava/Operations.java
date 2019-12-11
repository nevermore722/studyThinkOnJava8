package onjava;
// onjava/Operations.java
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/12/11 14:59
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface Operations {
  void execute();
  static void runOps(Operations... ops) {
    for(Operations op : ops){
      op.execute();
    }
  }
  static void show(String msg) {
    System.out.println(msg);
  }
}