package xyz.quxiao.java8forimpatient.chap1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author 作者 :quxiao 创建时间：2019/3/14 13:07
 */
public class Ex9 {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    Collection2<Integer> list2 = (Collection2<Integer>) list;
    list2.forEachIf(System.out::println, i -> i / 2 == 0);
  }

  public interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<T> action, Predicate<T> predicate) {
      this.stream().filter(predicate).forEach(action);
    }
  }
}
