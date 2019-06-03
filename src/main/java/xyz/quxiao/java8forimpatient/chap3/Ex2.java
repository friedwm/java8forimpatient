package xyz.quxiao.java8forimpatient.chap3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 作者 :quxiao 创建时间：2019/6/3 15:54
 */
public class Ex2 {

  private static final Logger logger = LoggerFactory.getLogger(Ex2.class);

  final static private ReentrantLock lock = new ReentrantLock();

  public static void withLock(ReentrantLock reentrantLock, VoidAction voidAction) {
    reentrantLock.lock();
    try {
      voidAction.doSomething();
    } finally {
      reentrantLock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    int totalThreads = 10;
    assert totalThreads == 2;
    ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);
    CountDownLatch latch = new CountDownLatch(totalThreads);
    for (int i = 0; i < totalThreads; i++) {
      executorService.submit(() -> {
        withLock(Ex2.lock, () -> {
          logger.info("-----------------");
          logger.info("Print log");
          logger.info("Time is:{}", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
          logger.info("+++++++++++++++++");
          latch.countDown();
        });
      });
    }
    executorService.shutdown();
    latch.await();
    logger.info("all finish, main exit");
  }


}
