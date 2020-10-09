package main.JAVA基础;

import java.util.Arrays;
import java.util.List;

public class _20200717_回调 {
    public static void main(String[] args) {
        System.out.println("-----同步调用------");
        new _同步调用().b();
        System.out.println("------------------");
        System.out.println();
        System.out.println("-------回调--------");
        new _老师(Arrays.asList(
                new _学生._学生默认实例(),
                callback -> callback.tellAnswer(2),
                callback -> callback.tellAnswer(3),
                callback -> callback.tellAnswer(5),
                callback -> callback.tellAnswer(6),
                callback -> callback.tellAnswer(7)
        )).askQuestion();
        System.out.println("------------------");
    }

}

class _同步调用 {
    public String a() {
        System.out.println("i am a");
        return "a";
    }

    public String b() {
        a();
        System.out.println("i am b");
        return "b";
    }
}

///////////////////////////////////////////////////////////

/**
 * 将问题进行抽象
 * <p>
 * 将问题进行抽象之后，
 * 对于学生来说，就不需要关心到底是哪位老师询问我问题，
 * 只要我根据询问的问题，得出答案，
 * 然后告诉提问的老师就可以了，
 * 即使老师换了一茬又一茬，对我学生而言都是没有任何影响的
 */
interface _问题 {
    public void tellAnswer(int answer);
}

class _老师 implements _问题 {
    private List<_学生> students;

    public _老师(List<_学生> students) {
        this.students = students;
    }
    public void askQuestion() {
        //回调的核心就是回调方将本身即this传递给调用方
        students.forEach(item -> item.resolveQuestion(this));
    }
    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}

interface _学生 {
    void resolveQuestion(_问题 callback);
    class _学生默认实例 implements _学生 {
        @Override
        public void resolveQuestion(_问题 callback) {
            // 模拟解决问题
            callback.tellAnswer(1);
        }
    }
}

