package xyz.quxiao.java8forimpatient.chap5;

import static xyz.quxiao.java8forimpatient.chap5.DateUtil.printDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 14:38
 */
public class ex1 {

  /**
   * 思路：按程序员节的定义：一年中的第256天。因年分闰平，日期相差一天(闰年2月多处一天，因此日期早一天）
   * @param year
   * @return
   */
  public static LocalDate calc(int year) {
    return LocalDate.of(year, 1, 1).withDayOfYear(256);
  }

  public static void main(String[] args) {
    printDate(calc(2020));
    printDate(calc(2019));
  }
}
