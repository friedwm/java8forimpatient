package xyz.quxiao.java8forimpatient.chap3;

import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

/**
 * @author 作者 :quxiao 创建时间：2019/6/3 15:21
 */
public class Ex1 {

  public static void main(String[] args) {
    LOGGER logger = new LOGGER();
    int i = 14;

    logger.logIf(Level.INFO, () -> i > 16, () -> "hello world");
  }

  static class LOGGER {

    private static final Logger logger = LoggerFactory.getLogger(LOGGER.class);

    public void logIf(Level level, VoidPredicate predicate, Supplier<String> supplier) {
      switch (level) {
        case DEBUG:
          if (!logger.isDebugEnabled()) {
            return;
          }
          break;
        case INFO:
          if (!logger.isInfoEnabled()) {
            return;
          }
          break;
        case WARN:
          if (!logger.isWarnEnabled()) {
            return;
          }
          break;
        case ERROR:
          if (!logger.isErrorEnabled()) {
            return;
          }
          break;
      }
      if (predicate.test()) {
        String msg = supplier.get();
        switch (level) {
          case DEBUG:
            logger.debug(msg);
            break;
          case INFO:
            logger.info(msg);
            break;
          case WARN:
            logger.warn(msg);
            break;
          case ERROR:
            logger.error(msg);
            break;

        }
      }
    }
  }
}
