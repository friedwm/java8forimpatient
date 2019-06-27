package xyz.quxiao.java8forimpatient.chap5;

import java.util.function.Consumer;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 22:52
 */
public class Repeater {
  private int count;
  private Repeater(int count) {
    this.count = count;
  }

  static Repeater of(int count) {
    return new Repeater(count);
  }

  public void repeat(Consumer<Integer> consumer) {
    for (int i = 0; i < count; i++) {
      consumer.accept(i);
    }
  }
}
