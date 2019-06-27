package xyz.quxiao.java8forimpatient.chap5;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 14:49
 */
public class DateUtil {

  public static void printDate(TemporalAccessor temporalAccessor) {
    System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(temporalAccessor));
  }

  public static void printDateTime(TemporalAccessor temporalAccessor) {
    System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(temporalAccessor));
  }
}
