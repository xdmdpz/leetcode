package main.算法题;

import java.lang.reflect.Field;

public class Main {


    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);

        i1 = 1000;
        i2 = 1000;
        System.out.println(i1 == i2);

        i1 = 100;
        i2 = 100;
        System.out.println(i1 == i2);

        Long L1 = 1L;
        Long L2 = 1L;
        System.out.println(L1 == L2);

        L1 = 1000L;
        L2 = 1000L;
        System.out.println(L1 == L2);

        L1 = 100L;
        L2 = 100L;
        System.out.println(L1 == L2);
    }

//
//    public static void main(String[] args) throws Exception{
//        Integer x = 123;
//        System.out.println(x);
//        pass();
//        System.out.println(x);
//
//        x=1234;
//        System.out.println(x);
//        pass();
//        System.out.println(x);
//    }

    public static void pass() throws Exception {
        Field field = Integer.class.getDeclaredField("value");

        field.setAccessible(true);
        field.setInt(123, 456);
        field.setInt(1234, 4567);

    }

}
