package xyz.quxiao.java8forimpatient.chap5;

import static xyz.quxiao.java8forimpatient.chap5.DateUtil.printDate;

import java.time.LocalDate;

/**
 * @author 作者 :quxiao 创建时间：2019/6/26 14:52
 */
public class ex2 {

  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2000, 2, 29);
    System.out.println("date.isLeapYear() = " + date.isLeapYear());
    LocalDate newDate = date.plusYears(1);
    printDate(date);
    printDate(newDate);
  }
}
