package xyz.quxiao.java8forimpatient.chap1;

import java.util.ArrayList;

/**
 * @author 作者 :quxiao 创建时间：2019/3/15 0:18
 */
public class Ex12 {

  public static class Stream<E> {}

  public interface OldStream<E> {

    Stream<E> stream();
  }

  public static class OldColl<E> extends ArrayList<Integer> implements OldStream<E> {

    @Override
    public Stream<E> stream() {
      return new Stream<>();
    }
  }
}
