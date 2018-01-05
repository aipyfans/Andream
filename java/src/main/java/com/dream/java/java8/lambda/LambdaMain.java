package com.dream.java.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by william on 1/5/18.
 * <p>
 * https://luyiisme.github.io/2017/01/21/java8-lambda/
 * <p>
 * Lambda 表达式是一个匿名函数，源于数学λ演算。是闭包函数，但闭包并不一定是Lambda 函数。
 * 它可以赋值给变量，作为函数参数，作为函数返回值。
 */
public class LambdaMain {

    public static void main(String[] args) {

        Lambda的语法();

        方法引用();
    }


    private static void Lambda的语法() {
        List<Integer> integers = Arrays.asList(2, 4, 6, 8);

        //老的方式
        for (Integer x : integers) {
            System.out.println(x);
        }

        //1.8 非lambda
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.print(x);
            }
        });


        //1.8 lambda
        integers.forEach((x) -> System.out.println(x));
        integers.forEach(x -> System.out.println(x));
        //可以赘述其参数类型
        integers.forEach((Integer x) -> System.out.println(x));


        //多行实现
        integers.forEach((x) -> {
            x = x * 10;
            System.out.println(x);
        });

        // 本地变量
        integers.forEach((x) -> {
            int y = x + 10;
            System.out.println(y);
        });
    }


    private static void 方法引用() {
        引用一个静态方法();
        引用一个构造函数();
        引用一个实例方法();
    }

    private static void 引用一个静态方法() {
        System.out.println("-------------------------------------");
        List<Integer> integers = Arrays.asList(2, 4, 6, 8);
        integers.forEach(x -> {
            // old style
            //System.out.println(String.valueOf(x));

            Function<Integer, String> i2s = String::valueOf;
            System.out.println(i2s.apply(x));
        });
    }

    private static void 引用一个构造函数() {
        System.out.println("-------------------------------------");
        Function<String, Integer> s2i = Integer::new;
        System.out.println(s2i.apply("521"));

    }

    private static void 引用一个实例方法() {
        System.out.println("-------------------------------------");
        Consumer<Object> sysout = System.out::println;
        sysout.accept("hello world");

        Objects.requireNonNull(null);
    }

}
