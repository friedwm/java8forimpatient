package xyz.quxiao.java8forimpatient.chap6;

import java.util.Arrays;
import java.util.List;

/**
 * @author 作者 :quxiao 创建时间：2019/7/3 22:11
 */
public class StreamInternal {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("alpha", "beta", "charlie", "delta", "eagle");
    long count = list.stream().filter(s -> {
      return s.length() == 5;
    }).count();
    System.out.println(count);
  }
}
