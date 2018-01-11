package com.dream.java.java8.optional;

import java.util.Optional;

/**
 * Created by william on 1/11/18.
 * <p>
 * https://lw900925.github.io/java/java8-optional.html
 */
public class OptionalMain {


    public static void main(String[] args) {

        创建Optional对象();
        提取Optional对象中的值();
        使用orElse方法获取值();
        使用filter方法过滤();
    }


    private static void 创建Optional对象() {

        // 空对象
        Optional<String> emptyOpt = Optional.empty();
        emptyOpt.ifPresent(s -> System.out.println(s));
        // 抛出NullPointerException异常
        // emptyOpt.get();


        // of()方法使用一个非空的值创建Optional对象
        Optional<String> notNullOpt = Optional.of("Hello World");
        notNullOpt.ifPresent(s -> System.out.println(s));
        notNullOpt.get();


        // ofNullable()方法接收一个可以为null的值
        Optional<String> nullableOpt = Optional.ofNullable(null);
        nullableOpt.ifPresent(s -> System.out.println(s));
        // 抛出NullPointerException异常
        // nullableOpt.get();

    }


    private static void 提取Optional对象中的值() {

        Optional<User> userOpt = Optional.ofNullable(null);
        Optional<String> roleIdOpt1 = userOpt.map(User::getRoleId);
        roleIdOpt1.ifPresent(roleId -> System.out.println(roleId));

        User user = new User();
        userOpt = Optional.ofNullable(user);
        Optional<String> roleIdOpt2 = userOpt.map(User::getRoleId);
        roleIdOpt2.ifPresent(roleId -> System.out.println(roleId));

        user.setRoleId("5211314");
        userOpt = Optional.ofNullable(user);
        Optional<String> roleIdOpt3 = userOpt.map(User::getRoleId);
        roleIdOpt3.ifPresent(roleId -> System.out.println(roleId));

    }


    private static void 使用orElse方法获取值() {
        String str = "Hello World";
        Optional<String> strOpt = Optional.ofNullable(str);

        String orElseResult = strOpt.orElse("Hello Shanghai");
        System.out.println(orElseResult);

        String orElseGet = strOpt.orElseGet(() -> "Hello Shanghai");
        System.out.println(orElseGet);

        String orElseThrow = strOpt.orElseThrow(() -> new IllegalArgumentException("Argument 'str' cannot be null or blank."));
        System.out.println(orElseThrow);
    }


    private static void 使用filter方法过滤() {
        Optional<String> optional = Optional.of("lw900925@163.com");
        optional = optional.filter(str -> str.contains("163"));
        optional.ifPresent(s -> System.out.println(s));
    }

}
