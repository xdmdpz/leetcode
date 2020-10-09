package main.JAVA基础;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class _20200720_代理 {
    public static void main(String[] args) {
        //静态代理
        Calculator calculator = new CalculatorImpl();
        CalculatorProxy calculatorProxy = new CalculatorProxy(calculator);
        calculatorProxy.add(1, 2);

        //动态代理
        Calculator calculator1 = new CalculatorImpl();
        LogHandler logHandler = new LogHandler(calculator1);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                calculator1.getClass().getClassLoader(),
                calculator1.getClass().getInterfaces(),
                logHandler);
        proxy.add(1, 3);
    }


}

///////////////////////////////////////////////////////////
interface Calculator {
    int add(int a, int b);
}

class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println(result);
        return result;
    }
}

class CalculatorProxy implements Calculator {
    private Calculator calculator;

    CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {
        before();
        int result = calculator.add(a, b);
        after();
        return result;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}

///////////////////////////////////////////////////////////
class LogHandler implements InvocationHandler {
    Object object;

    LogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object result = method.invoke(object, args);
        this.after();
        return result;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
///////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////