package exception;
// exceptions/DynamicFields.java
// A Class that dynamically adds fields to itself to
// demonstrate exception chaining
/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/13 17:28
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 常常会想要在捕获一个异常后抛出另一个异常，并且希望把原始异常的信息保存下来，这被称为异常链。在 JDK1.4 以前，程序员必须自己编写代码来保存原始异常的信息。现在所有 Throwable
 * 的子类在构造器中都可以接受一个 cause（因由）对象作为参数。这个 cause 就用来表示原始异常，这样通过把原始异常传递给新的异常，使得即使在当前位置创建并抛出了新的异常，也能通过这个异常链追踪到异常最初发生的位置。
 *
 * 有趣的是，在 Throwable 的子类中，只有三种基本的异常类提供了带 cause 参数的构造器。它们是 Error（用于 Java 虚拟机报告系统错误）、Exception 以及
 * RuntimeException。如果要把其他类型的异常链接起来，应该使用 initCause0 方法而不是构造器。
 *
 * 下面的例子能让你在运行时动态地向 DymamicFields 对象添加字段：
 */

class DynamicFieldsException extends Exception {

}

public class DynamicFields {

  private Object[][] fields;

  public DynamicFields(int initialSize) {
    fields = new Object[initialSize][2];
    for (int i = 0; i < initialSize; i++) {
      fields[i] = new Object[]{
          null, null
      };
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Object[] obj : fields) {
      result.append(obj[0]);
      result.append(": ");
      result.append(obj[1]);
      result.append("\n");
    }
    return result.toString();
  }

  private int hasField(String id) {
    for (int i = 0; i < fields.length; i++) {
      if (id.equals(fields[i][0])) {
        return i;
      }
    }
    return -1;
  }

  private int getFieldNumber(String id) throws NoSuchFieldException {
    int fieldNum = hasField(id);
    if (fieldNum == -1) {
      throw new NoSuchFieldException();
    }
    return fieldNum;
  }

  private int makeField(String id) {
    for (int i = 0; i < fields.length; i++) {
      if (fields[i][0] == null) {
        fields[i][0] = id;
        return i;
      }
    }
    // No empty fields. Add one:
    Object[][] tmp = new Object[fields.length + 1][2];
    for (int i = 0; i < fields.length; i++) {
      tmp[i] = fields[i];
    }
    for (int i = fields.length; i < tmp.length; i++) {
      tmp[i] = new Object[]{
          null, null
      };
    }
    fields = tmp;
    // Recursive call with expanded fields:
    return makeField(id);
  }

  public Object getField(String id) throws NoSuchFieldException {
    return fields[getFieldNumber(id)][1];
  }

  public Object setField(String id, Object value) throws DynamicFieldsException {
    if (value == null) {
      // Most exceptions don't have a "cause"
      // constructor. In these cases you must use
      // initCause(), available in all
      // Throwable subclasses.
      DynamicFieldsException dfe = new DynamicFieldsException();
      dfe.initCause(new NullPointerException());
      throw dfe;
    }
    int fieldnumber = hasField(id);
    if (fieldnumber == -1) {
      fieldnumber = makeField(id);
    }
    Object result = null;
    try {
      //Get old calue
      result = getField(id);
    } catch (NoSuchFieldException e) {
      // Use constructor that takes "cause":
      throw new RuntimeException(e);
    }
    fields[fieldnumber][1] = value;
    return result;
  }

  /**
   * 每个 DynamicFields 对象都含有一个数组，其元素是“成对的对象”。第一个对象表示字段标识符（一个字符串），第二个表示字段值，值的类型可以是除基本类型外的任意类型。当创建对象的时候，要合理估计一下需要多少字段。当调用 setField() 方法的时候，它将试图通过标识修改已有字段值，否则就建一个新的字段，并把值放入。如果空间不够了，将建立一个更长的数组，并把原来数组的元素复制进去。如果你试图为字段设置一个空值，将抛出一个 DynamicFieldsException 异常，它是通过使用 initCause() 方法把 NullPointerException 对象插入而建立的。
   *
   * 至于返回值，setField() 将用 getField() 方法把此位置的旧值取出，这个操作可能会抛出 NoSuchFieldException 异常。如果客户端程序员调用了 getField() 方法，那么他就有责任处理这个可能抛出的 NoSuchFieldException 异常，但如果异常是从 setField0 方法里抛出的，这种情况将被视为编程错误，所以就使用接受 cause 参数的构造器把 NoSuchFieldException 异常转换为 RuntimeException 异常。
   *
   * 你会注意到，toString0 方法使用了一个 StringBuilder 来创建其结果。在 字符串 这章中你将会了解到更多的关于 StringBuilder 的知识，但是只要你编写设计循环的 toString() 方法，通常都会想使用它，就像本例一样。
   *
   * 主方法中的 catch 子句看起来不同 - 它使用相同的子句处理两种不同类型的异常，并结合“或（|）”符号。此 Java 7 功能有助于减少代码重复，并使你更容易指定要捕获的确切类型，而不是简单地捕获基本类型。你可以通过这种方式组合多种异常类型。
   * @param args
   */
  public static void main(String[] args) {
    DynamicFields df = new DynamicFields(3);
    System.out.println(df);
    try {
      df.setField("d", "A value for d");
      df.setField("number", 47);
      df.setField("number2", 48);
      System.out.println(df);
      df.setField("d", "A new value for d");
      df.setField("number3", 11);
      System.out.println("df:" + df);
      System.out.println("df.getField(\"d\"):" + df.getField("d"));
      //Exception
      Object field = df.setField("d", null);
    } catch (NoSuchFieldException | DynamicFieldsException e) {
      e.printStackTrace(System.out);
    }
  }
}
