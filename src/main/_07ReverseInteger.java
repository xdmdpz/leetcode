package main;

public class _07ReverseInteger {


    public static void main(String[] args) {
        int i = 123;
        System.out.println(reverse(i));
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}
