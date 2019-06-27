package xyz.quxiao.java8forimpatient.chap5;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 22:20
 */
public class ex4_1 {

  public static void main(String[] args) {
    printCalendar(2019, 5);
  }

  private static void printCalendar(int year, int month) {
    String[] header = {"一", "二", "三", "四", "五", "六", "日"};
    CalenderPrinter printer = new CalenderPrinter();
    // 打印头
    Arrays.stream(header).forEach(printer::print);

    LocalDate firstDay = LocalDate.of(year, month, 1);
    int dayOfWeek = firstDay.getDayOfWeek().getValue();

    Repeater.of(dayOfWeek - 1).repeat(i -> {
      printer.print("");
    });

    int totalDaysOfMonth = firstDay.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    Repeater.of(totalDaysOfMonth).repeat(i -> {
      printer.print(String.valueOf(i + 1));
    });
  }

  private static class CalenderPrinter {

    private int printed;

    void print(String str) {
      System.out.printf("%-10s\t", str);
      ++printed;
      if (printed % 7 == 0) {
        System.out.println("");
      }
    }
  }
}
