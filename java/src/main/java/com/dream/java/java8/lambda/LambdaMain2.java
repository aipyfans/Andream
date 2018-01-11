package com.dream.java.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by william on 1/5/18.
 * <p>
 * https://lw900925.github.io/java/java8-lambda-expression.html
 */
public class LambdaMain2 {

    public static void main(String[] args) {

        main1();
    }

    private static void main1() {
        // Comparator排序
        List<Integer> list = Arrays.asList(3, 1, 4, 5, 2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        // 使用Lambda表达式简化
        list.sort((o1, o2) -> o1.compareTo(o2));

        // Lambda 方法引用
        list.sort(Integer::compareTo);

        list.forEach(System.out::println);
    }

}
