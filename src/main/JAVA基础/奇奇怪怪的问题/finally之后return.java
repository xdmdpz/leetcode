package main.JAVA基础.奇奇怪怪的问题;

public class finally之后return {

    public static void main(String[] args) {
        System.out.println(aaa());//finally

    }

    public static String aaa() {
        try{
            return "try";
        }
        finally {
            return "finally";
        }

    }
}
