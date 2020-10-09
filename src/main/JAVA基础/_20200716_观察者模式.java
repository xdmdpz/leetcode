package main.JAVA基础;

import java.util.Vector;

public class _20200716_观察者模式  {
    public static void main(String[] args) {
        /**
         * 张三是被观察者
         */
        ObserveredUsing zhangsan = new ObserveredUsing("张三",32);
        /**
         * 李四，王五是观察者
         * 当张三做出动作，李四王五会做出相应的动作
         */
        ObserverUsingEat lisi = new ObserverUsingEat("李四",20);
        ObserverUsingEat wangwu = new ObserverUsingEat("王五",80);
        /**
         * 添加到广播对象中
         */
        ObserverUsingPlay no1 = new ObserverUsingPlay("1号", "跑步");
        ObserverUsingPlay no2 = new ObserverUsingPlay("2号", "跳");
        zhangsan.addObserver(lisi);
        zhangsan.addObserver(wangwu);
        zhangsan.addObserver(no1);
        zhangsan.addObserver(no2);


        zhangsan.setChanged();
        zhangsan.setData("吃饭");

    }
}

interface IObservered {

    boolean addObserver(IObserver o);

    void modifyObserver(Object arg);

    boolean delObserver(IObserver o);
}

interface IObserver {

    void update(ObserveredPeople o, Object arg);
}

class ObserveredPeople implements IObservered {

    private boolean changed;//通知标志，true才通知
    private Vector vector;//观察者广播范围

    public void setChanged() {
        changed = true;
    }

    public ObserveredPeople() {
        //构造方法中进行实例化和初始化
        changed = false;
        vector = new Vector();
    }

    @Override
    public boolean addObserver(IObserver o) {
        //如果传入对象为空，或者广播范围内已存在
        //那么就会抛出空指针异常
        //可以在外层捕获这个异常
        if (o != null && !vector.contains(o)) {
            vector.addElement(o);
            return true;
        } else {
            throw new NullPointerException("传入的观察者对象空");
        }
    }

    @Override
    public void modifyObserver(Object arg) {
        //如果有效，使用增强for语句循环调用update方法
        if (changed) {
            for (Object o : vector) {
                if (o instanceof IObserver) {
                    ((IObserver) o).update(this, arg);
                }
            }
        }
        changed = false;
    }

    @Override
    public boolean delObserver(IObserver o) {
        if (o != null && vector.contains(o)) {
            vector.remove(o);
            return true;
        } else {
            throw new NullPointerException("传入的观察者不存在或者不在广播范围内");
        }
    }

}

class ObserveredUsing extends ObserveredPeople {

    private String name;
    private int age;

    public ObserveredUsing(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setData(Object arg) {
        System.out.println("推送的数据： name:" + name + "  " + "age:" + age + "   " + "arg:" + arg.toString());
        System.out.println();
        modifyObserver(arg);
    }
}

class ObserverUsingEat implements IObserver {

    private String name;
    private int age;

    public ObserverUsingEat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void update(ObserveredPeople o, Object arg) {
        System.out.println();
        System.out.println("ObserverUsingEat");
        System.out.println("name:" + name + "  " + "age:" + age + "   " + "arg:" + arg.toString());
    }

}

class ObserverUsingPlay implements IObserver {

    private String name;
    private String play;

    public ObserverUsingPlay(String name, String play) {
        this.name = name;
        this.play = play;
    }

    private void doPlay() {
        System.out.println("开始运动");
        System.out.println("name:" + name);
        System.out.print("   我做" + play + "运动");
    }

    @Override
    public void update(ObserveredPeople o, Object arg) {
        System.out.println();
        System.out.println("ObserverUsingPlay");
        doPlay();
        System.out.println(arg.toString());
    }

}