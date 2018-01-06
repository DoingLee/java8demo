package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author：ldy on 07/01/2018 00:16
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 数据准备：插入8条数据
         */
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        /**
         * Filter 接受一个Predicate接口
         */
        long count1 = stringCollection.stream().filter(string -> string.startsWith("a")).count();
        System.out.println("filter count : " + count1); //2

        /**
         * ﻿ForEach ﻿接受一个Consumer接口
         */
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        /**
         * ﻿Sorted﻿ 返回一个排过序的流对象的视图。但﻿不会改变原来集合中元素的顺序
         */
        stringCollection.stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
        // "aaa1", "aaa2"
        System.out.println(stringCollection);
        // ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1

        /**
         * ﻿Map ﻿映射每个元素到对应的结果
         */
        stringCollection.stream().map(String::toUpperCase).sorted((a,
                                                                   b) -> b.compareTo(a)).forEach(System.out::println);
        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

        /**
         * ﻿Match ﻿判断某一种规则是否与流对象相互吻合
         */
        boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA); // true

        boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA); // false

        boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ); // true

        /**
         * ﻿limit ﻿获取指定数量的流
         */
        stringCollection.stream().sorted((a, b) -> b.compareTo(a)).limit(2).forEach(System.out::println);
        // "DDD2", "DDD1"

        /**
         * ﻿Count ﻿返回﻿当前流对象中包含的元素数量
         */
        long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
        System.out.println(startsWithB); // 3

        /**
         * ﻿Reduce ﻿通过某一个方法，﻿对元素进行削减操作。操作的结果会放在一个Optional变量里返回
         */
        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

        /**
         * ﻿Collectors ﻿归约操作，例如将流转换成集合和聚合元素
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        //筛选列表: [abc, bc, efg, abcd, jkl]

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串：" + mergedString);
        //合并字符串：abc, bc, efg, abcd, jkl
    }
}
