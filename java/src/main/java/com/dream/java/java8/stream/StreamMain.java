package com.dream.java.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 中的 Streams API 详解.
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 *
 * https://github.com/aNNiMON/Lightweight-Stream-API
 *
 * Created by william on 1/4/18.
 */

public class StreamMain {

    public static void main(String[] args) {

//        构造流的几种常见方法();
//        数值流的构造();
//        流转换为其它数据结构();

        流的操作();
    }

    private static void 构造流的几种常见方法() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

    private static void 数值流的构造() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }


    private static void 流转换为其它数据结构() {
        String[] strArray = new String[]{"a", "b", "c"};
        Stream<String> stream = Stream.of(strArray);

        // 1. Array
        String[] strArray1 = stream.toArray(String[]::new);

        // 2. Collection
//        List<String> list1 = stream.collect(Collectors.toList());
//        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));

//        Set set1 = stream.collect(Collectors.toSet());
//        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));

        // 3. String
//        String str = stream.collect(Collectors.joining()).toString();
    }


    private static void 流的操作() {
        String[] strArray = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(strArray);
        System.out.println("------------------------");

        // map 把所有的单词转换为大写
        List<String> listStream = list.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("map操作 : 把所有的单词转换为大写");
        System.out.println(listStream);
        System.out.println("------------------------");

        // 平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());

        System.out.println("map操作 : 平方数");
        System.out.println(squareNums);
        System.out.println("------------------------");

        // flatMap
        // 一对多
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        List<Integer> integerList = inputStream.flatMap((childList) -> childList.stream()).collect(Collectors.toList());

        System.out.println("flatMap操作 : 一对多");
        System.out.println(integerList);
        System.out.println("------------------------");

        // filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
        //  留下偶数
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        List<String> evens = Stream.of(sixNums).filter(n -> n % 2 == 0).map(integer -> String.valueOf(integer)).collect(Collectors.toList());

        System.out.println("filterp操作 : 留下偶数");
        System.out.println(evens);
        System.out.println("------------------------");

        // 把单词挑出来
        // List<String> output = reader.lines().flatMap(line -> Stream.of(line.split(REGEXP))).filter(word -> word.length() > 0).collect(Collectors.toList());


    }


}
