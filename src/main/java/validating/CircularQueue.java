package validating;

import java.util.*;

// validating/CircularQueue.java
// Demonstration of Design by Contract (DbC)
/**
 * 我们可以对这个队列做一些契约定义:
 *
 * 1. 前置条件(用于put())：不允许将空元素添加到队列中。
 *
 * 2. 前置条件(用于put())：将元素放入完整队列是非法的。
 *
 * 3. 前置条件(用于get())：试图从空队列中获取元素是非法的。
 *
 * 4. 后置条件用于get())：不能从数组中生成空元素。
 *
 * 5. 不变性：包含对象的区域不能包含任何空元素。
 *
 * 6. 不变性：不包含对象的区域必须只有空值。
 *
 * 下面是实现这些规则的一种方式，为每个 DbC 元素类型使用显式的方法调用。
 *
 * in 计数器指示数组中下一个对象所在的位置。out 计数器指示下一个对象来自何处。wrapped 的flag表示 in 已经“绕着圆圈”走了，现在从后面出来了。当in和 out 重合时，队列为空(如果包装为 false )或满(如果 wrapped 为 true )。
 *
 * put() 和 get() 方法调用 precondition() ，postcondition(), 和 invariant()，这些都是在类中定义的私有方法。前置precondition() 和 postcondition() 是用来阐明代码的辅助方法。
 *
 * 注意，precondition() 返回 void , 因为它不与断言一起使用。按照之前所说的，通常你会在代码中保留前置条件。通过将它们封装在 precondition() 方法调用中，如果你不得不做出关掉它们的可怕举动，你会有更好的选择。
 *
 * postcondition() 和 constant() 都返回一个布尔值，因此可以在 assert 语句中使用它们。此外，如果出于性能考虑禁用断言，则根本不存在方法调用。invariant() 对对象执行内部有效性检查，如果你在每个方法调用的开始和结束都这样做，这是一个花销巨大的操作，就像 Meyer 建议的那样。所以， 用代码清晰地表明是有帮助的，它帮助我调试了实现。此外，如果你对代码实现做任何更改，那么 invariant() 将确保你没有破坏代码，将不变性测试从方法调用移到单元测试代码中是相当简单的。如果你的单元测试是足够的，那么你应当对不变性保持一定的信心。
 *
 * dump() 帮助方法返回一个包含所有数据的字符串，而不是直接打印数据。这允许我们用这部分信息做更多事。
 */

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 15:41
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CircularQueue {

  private Object[] data;
  private int in = 0,// Next available storage space
      out = 0;// Next gettable object
  // Has it wrapped around the circular queue?
  private boolean wrapped = false;

  public CircularQueue(int size) {
    data = new Object[size];
    // Must be true after construction:
    assert invariant();
  }

  public boolean empty() {
    return !wrapped && in == out;
  }

  public boolean full() {
    return wrapped && in == out;
  }

  public boolean isWrapped() {
    return wrapped;
  }

  public void put(Object item) {
    precondition(item != null, "put() null item");
    precondition(!full(), "put() into full CircularQueue");
    assert invariant();
    data[in++] = item;
    if (in >= data.length) {
      in = 0;
      wrapped = true;
    }
    assert invariant();
  }

  public Object get() {
    precondition(!empty(), "get() from empty CircularQueue");
    assert invariant();
    Object returnVal = data[out];
    data[out] = null;
    out++;
    if (out >= data.length) {
      out = 0;
      wrapped = false;
    }
    assert postcondition(returnVal != null, "Null item in CircularQueue");
    assert invariant();
    return returnVal;
  }

  // Design-by-contract support methods:
  private static void precondition(boolean cond, String msg) {
    if (!cond) {
      throw new CircularQueueException(msg);
    }
  }

  private static boolean postcondition(boolean cond, String msg) {
    if (!cond) {
      throw new CircularQueueException(msg);
    }
    return true;
  }

  private boolean invariant() {
    // Guarantee that no null values are in the
    // region of 'data' that holds objects:
    for (int i = out; i != in; i = (i + 1) % data.length) {
      if (data[i] == null) {
        throw new CircularQueueException("null in CircularQueue");
        // Guarantee that only null values are outside the
        // region of 'data' that holds objects:
      }
    }
    if (full()) {
      return true;
    }
    for (int i = in; i != out; i = (i + 1) % data.length) {
      if (data[i] != null) {
        throw new CircularQueueException("non-null outside of CircularQueue range: " + dump());
      }
    }
    return true;
  }

  public String dump() {
    return "in = " + in +
        ", out = " + out +
        ", full() = " + full() +
        ", empty() = " + empty() +
        ", CircularQueue = " + Arrays.asList(data);
  }
}
