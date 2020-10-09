package main.JAVA基础;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class _20200720_反射 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        TestClass testClass = new TestClass();

        Class clazz = testClass.getClass();
        //获取类名 TestClass
        String className = clazz.getName();
        //获取方法
        //...
        //public void TestClass.setA(int)
        //...
        Method[] methods = clazz.getDeclaredMethods();
        //获取字段名
        //private int TestClass.a
        Field[] fields = clazz.getDeclaredFields();
        //获取私有字段
        Field field = fields[0];
        //设置为可访问
        field.setAccessible(true);
        //修改私有字段
        field.set(testClass,100);

        //实例化对象
        Class.forName("TestClass").newInstance();
        //动态调用方法
        System.out.println(clazz
                .getDeclaredMethod("add", int.class, int.class)
                .invoke(testClass, 1, 2));
        System.out.println(clazz
                .getDeclaredMethod("getA")
                .invoke(testClass));

        TestSingletonClass singletonClass = TestSingletonClass.instance;
        Class singletonClazz = singletonClass.getClass();
        Arrays.stream(singletonClazz.getDeclaredConstructors()).forEach(System.out::println);
        //  cannot access a member of class TestSingletonClass with modifiers "private"
        // 报错无法实例化私有构造函数
        // TestSingletonClass singletonClass1 = (TestSingletonClass) Class.forName("TestSingletonClass").newInstance();

        // 实例化私有构造函数
        Constructor constructor = singletonClazz.getDeclaredConstructors()[0];
        //设置为可访问
        constructor.setAccessible(true);
        //  使用刚才修改后的构造函数实例化对象
        TestSingletonClass singletonClass1 = (TestSingletonClass) constructor.newInstance();
        System.out.println(singletonClass1.add(1, 3));

    }


}

///////////////////////////////////////////////////////////
class TestClass {
    private int a = 10;
    private int b;

    public int add(int a, int b) {
        return a + b;
    }
    public int getA(){
        return a;
    }
}

interface TestInterface {
    public int aaa();

    public void bbb();
}

class TestSingletonClass {
    public final static TestSingletonClass instance = new TestSingletonClass();

    private TestSingletonClass() {

    }

    public int add(int a, int b) {
        return a + b;
    }
}
///////////////////////////////////////////////////////////