package xyz.quxiao.java8forimpatient.chap1;

import java.util.concurrent.Callable;

/**
 * 为什么不能用Callable<Void>代替？因为Void无法实例化
 * @author 作者 :quxiao 创建时间：2019/3/4 20:40
 */
public class Ex6 {

  public static Runnable uncheck(final RunnableEx runnableEx) {
    return () -> {
      try {
        runnableEx.run();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }

  public static Runnable uncheck2(final Callable<Void> callable) {
    return () -> {
      try {
        callable.call();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };
  }


  public static void main(String[] args) {
    new Thread(uncheck2(() -> {
      System.out.println("hello");
      Thread.sleep(1000);
      Class<Void> type = Void.TYPE;
      return type.newInstance();
    })).start();
  }

  public interface RunnableEx {
    void run() throws Exception;
  }
}
