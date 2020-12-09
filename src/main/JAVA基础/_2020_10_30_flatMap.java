package main.JAVA基础;

import java.util.Arrays;

public class _2020_10_30_flatMap {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World"};

        Arrays.stream(strings)
                .flatMap(word -> Arrays.stream(word.split("")))
                .forEach(System.out::print);
        System.out.println();
        Arrays.stream(strings)
                .map(word -> word.split(""))
                .forEach( arr -> {
                    System.out.println();
                    Arrays.stream(arr).forEach(System.out::print);
                });
        System.out.println();
    }
}
