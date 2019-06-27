package xyz.quxiao.java8forimpatient.chap5;

import static xyz.quxiao.java8forimpatient.chap5.DateUtil.printDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 15:18
 */
public class ex3 {

  public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
    return TemporalAdjusters.ofDateAdjuster(d -> {
      while (!predicate.test(d)) {
        d = d.plusDays(1);
      }
      return d;
    });
  }

  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    LocalDate date = now.with(next(d -> d.getDayOfWeek().equals(DayOfWeek.MONDAY)));
    printDate(date);
  }
}
