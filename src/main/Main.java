package main;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer x = 123;
        System.out.println(x);
        pass();
        System.out.println(x);
    }

    public static void pass() throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(123,456);
    }

}
