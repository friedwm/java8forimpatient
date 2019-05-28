package xyz.quxiao.java8forimpatient.chap1;

/**
 * @author 作者 :quxiao 创建时间：2019/3/14 23:47
 */
public class Ex11 {

  public interface I {

    default void f() {
      System.out.println("I");
    }
  }

  public interface J {

    default int f() {
      return 1;
    }
  }

  public interface K {
    void f();
  }

  public static class Clz implements I,J {

    @Override
    public void f() {

    }
  }
}
