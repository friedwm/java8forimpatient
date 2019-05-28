package xyz.quxiao.java8forimpatient.chap1;

import java.util.concurrent.TimeUnit;

/**
 * @author 作者 :quxiao 创建时间：2019/3/8 23:20
 */
public class Ex8 {


  public static void main(String[] args) throws InterruptedException {
    String[] names = {"qx", "gg", "bd"};
    for (int i = 0; i < names.length;i++) {
      int index = i;
      new Thread(() -> System.out.println(names[index])).start();
    }
    TimeUnit.SECONDS.sleep(10);
  }
}
