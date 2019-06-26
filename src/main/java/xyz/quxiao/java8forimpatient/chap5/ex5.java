package xyz.quxiao.java8forimpatient.chap5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 23:29
 */
public class ex5 {

  private static long getLiveDays(int year, int month, int day) {
    LocalDate birthday = LocalDate.of(year, month, day);
    LocalDate now = LocalDate.now();
    Period period = Period.between(birthday, now);
//    return birthday.until(now, ChronoUnit.DAYS);
    return period.get(ChronoUnit.DAYS);
  }

  public static void main(String[] args) {
    System.out.println(getLiveDays(1987, 12, 27));
  }
}
