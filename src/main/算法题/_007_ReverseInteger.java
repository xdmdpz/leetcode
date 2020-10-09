package main.算法题;

public class _007_ReverseInteger {


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
