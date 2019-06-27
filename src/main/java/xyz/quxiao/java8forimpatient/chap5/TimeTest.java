package xyz.quxiao.java8forimpatient.chap5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 11:10
 */
public class TimeTest {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(now));
  }
}
