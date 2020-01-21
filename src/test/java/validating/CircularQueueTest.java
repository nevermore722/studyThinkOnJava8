package validating;
// validating/tests/CircularQueueTest.java

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2020/1/21 16:07
 * @description：
 * @modified By：
 * @version: 1.0
 */

/**
 * 现在我们可以为类创建 JUnit 测试:
 *
 * initialize() 添加了一些数据，因此每个测试的 CircularQueue 都是部分满的。showFullness() 和 showempty() 表明 CircularQueue 是满的还是空的，这四种测试方法中的每一种都确保了 CircularQueue 功能在不同的地方正确运行。
 *
 * 通过将 Dbc 和单元测试结合起来，你不仅可以同时使用这两种方法，还可以有一个迁移路径—你可以将一些 Dbc 测试迁移到单元测试中，而不是简单地禁用它们，这样你仍然有一定程度的测试。
 */
public class CircularQueueTest {

  private CircularQueue queue = new CircularQueue(10);
  private int i = 0;

  @BeforeEach
  public void initialize() {
    while (i < 5) { // Pre-load with some data
      queue.put(Integer.toString(i++));
    }
  }

  // Support methods:
  private void showFullness() {
    assertTrue(queue.full());
    assertFalse(queue.empty());
    System.out.println(queue.dump());
  }

  private void showEmptiness() {
    assertFalse(queue.full());
    assertTrue(queue.empty());
    System.out.println(queue.dump());
  }

  @Test
  public void full() {
    System.out.println("testFull");
    System.out.println(queue.dump());
    System.out.println(queue.get());
    System.out.println(queue.get());
    while (!queue.full()) {
      queue.put(Integer.toString(i++));
    }
    String msg = "";
    try {
      queue.put("");
    } catch (CircularQueueException e) {
      msg = e.getMessage();
      System.out.println(msg);
    }
    assertEquals(msg, "put() into full CircularQueue");
    showFullness();
  }

  @Test
  public void empty() {
    System.out.println("testEmpty");
    while (!queue.empty()) {
      System.out.println(queue.get());
    }
    String msg = "";
    try {
      queue.get();
    } catch (CircularQueueException e) {
      msg = e.getMessage();
      System.out.println(msg);
    }
    assertEquals(msg, "get() from empty CircularQueue");
    showEmptiness();
  }

  @Test
  public void nullPut() {
    System.out.println("testNullPut");
    String msg = "";
    try {
      queue.put(null);
    } catch (CircularQueueException e) {
      msg = e.getMessage();
      System.out.println(msg);
    }
    assertEquals(msg, "put() null item");
  }

  @Test
  public void circularity() {
    System.out.println("testCircularity");
    while (!queue.full()) {
      queue.put(Integer.toString(i++));
    }
    showFullness();
    assertTrue(queue.isWrapped());
    while (!queue.empty()) {
      System.out.println(queue.get());
    }
    showEmptiness();
    while (!queue.full()) {
      queue.put(Integer.toString(i++));
    }
    showFullness();
    while (!queue.empty()) {
      System.out.println(queue.get());
    }
    showEmptiness();
  }
}
