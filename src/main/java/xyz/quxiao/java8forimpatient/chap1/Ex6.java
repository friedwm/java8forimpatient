package xyz.quxiao.java8forimpatient.chap1;

/**
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


  public static void main(String[] args) {
    new Thread(uncheck(() -> {
      System.out.println("hello");
      Thread.sleep(1000);
    })).start();
  }

  public interface RunnableEx {

    void run() throws Exception;
  }
}
