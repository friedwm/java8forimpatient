package xyz.quxiao.java8forimpatient.chap1;

import java.util.concurrent.TimeUnit;

/**
 * @author 作者 :quxiao 创建时间：2019/3/5 21:07
 */
public class Ex7 {

  public static void main(String[] args) throws InterruptedException {
    new Thread(IEx7.andThen(() -> {
      System.out.println("run1");
    }, () -> {
      System.out.println("run2");
    })).start();

    TimeUnit.SECONDS.sleep(10);
  }

  public interface IEx7 {
    static Runnable andThen(Runnable r1, Runnable r2) {
      return () -> {
        r1.run();
        r2.run();
      };
    }
  }
}
