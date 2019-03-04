package xyz.quxiao.java8forimpatient.chap1;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 作者 :quxiao
 * 创建时间：2019/3/4 19:35
 */
public class Ex2 {
    public static List<String> listDir(String searchPath) {
        File baseDir = new File(searchPath);
        File[] value = baseDir.listFiles(File::isDirectory);
        File[] files = Optional.ofNullable(value).orElse(new File[]{});
        return Arrays.stream(files).map(File::getName).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String path = "D:\\newdir";
        System.out.println(listDir(path));
    }
}
