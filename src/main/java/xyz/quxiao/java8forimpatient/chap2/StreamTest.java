package xyz.quxiao.java8forimpatient.chap2;

import java.util.stream.Stream;

/**
 * @author 作者 :quxiao 创建时间：2019/4/9 23:14
 */
public class StreamTest {

  public static void main(String[] args) {
    Stream.iterate(1, s -> s+1).limit(10).forEach(System.out::println);
  }
}
