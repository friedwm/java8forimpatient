package xyz.quxiao.java8forimpatient.other;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.quxiao.java8forimpatient.chap1.Ex6;

/**
 * Object的notifyAll和wait的用法。代码证明了notifyAll并不会立即让wait的方法全部运行起来，而是会等待当前线程释放monitor。唤醒的线程也需要竞争monitor，成功的线程才能运行，此时其余线程仍在等待获取monitor
 *
 * @author 作者 :quxiao 创建时间：2019/3/5 12:55
 */
public class NotifyTest {

  private static final Logger logger = LoggerFactory.getLogger(NotifyTest.class);

  public static void main(String[] args) throws InterruptedException {
    Student student = new Student();
    for (int i = 0; i < 4; i++) {
      new Thread(Ex6.uncheck(student::waiting)).start();
    }
    TimeUnit.SECONDS.sleep(5);
    student.wakeSomeone();
    TimeUnit.SECONDS.sleep(60);
  }

  public static class Student {

    synchronized void waiting() throws InterruptedException {
      this.wait();
      String name = Thread.currentThread().getName();
      logger.info("{} wakeup, working...", name);
      TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
      logger.info("{} done, exiting", name);
    }

    synchronized void wakeSomeone() throws InterruptedException {
      this.notifyAll();
      logger.info("call notify, but not release lock, sleeping 5 secs");
      TimeUnit.SECONDS.sleep(5);
      logger.info("about to release monitor lock");
    }
  }

  @AllArgsConstructor
  @Data
  public static class Hobby {

    private String hobby;
  }
}
