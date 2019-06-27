package xyz.quxiao.java8forimpatient.chap6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author 作者 :quxiao 创建时间：2019/6/27 23:21
 */
public class AtomicTest {
  static private AtomicLong atomicLong = new AtomicLong(1);

  static private LongAdder longAdder = new LongAdder();

  public static void main(String[] args) {
    atomicLong.accumulateAndGet(10, (x,y)->{
      System.out.println("x:"+x);
      System.out.println("y:"+y);
      return x + y;
    });

    System.out.println(atomicLong.get());


    longAdder.add(1);
    longAdder.sum();

  }
}
