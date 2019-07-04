package xyz.quxiao.java8forimpatient.chap6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 作者 :quxiao 创建时间：2019/7/3 22:11
 */
public class StreamInternal {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("alpha", "beta", "charlie", "delta", "eagle");
    Optional<Integer> first = list.stream().filter(s -> {
      return s.length() > 1;
    }).map(String::length).sorted().findFirst();
    System.out.println(first.orElse(null));
  }
}
