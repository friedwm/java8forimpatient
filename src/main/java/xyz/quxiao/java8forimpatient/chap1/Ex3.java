package xyz.quxiao.java8forimpatient.chap1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 作者 :quxiao
 * 创建时间：2019/3/4 20:30
 */
public class Ex3 {
    static List<String> listFileWithSuffix(String dir, String suffix) {
        File directory = new File(dir);
        return new ArrayList<>(Arrays.asList(directory.list((d, n) -> n.endsWith(suffix))));
    }

    public static void main(String[] args) {
        System.out.println(listFileWithSuffix("D:\\IdeaWorkSpace\\git\\java8forimpatient\\src\\main\\java\\xyz\\quxiao\\java8forimpatient\\chap1", ".java"));
    }
}
