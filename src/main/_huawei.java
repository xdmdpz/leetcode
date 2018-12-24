package main;

import java.util.Arrays;

/**
 * 判断牌型
 * 五张牌,每张牌由牌大小和花色组成,牌大小2~10、J、Q、K、A,牌花色为红桃、黑桃、
 */
public class _huawei {
    int[] Hs = new int[13];
    int[] Ss = new int[13];
    int[] Cs = new int[13];
    int[] Ds = new int[13];
    int[] nums = new int[13];

    public static void main(String[] args) {
        //H红桃S黑桃C梅花D方片
        String[] strings = {"2H", "3S", "4C", "5D", "6A"};

        System.out.println(new _huawei().fun(strings));
    }

    public int fun(String[] strings) {
        init(strings);
        if (is同花顺())
            return 1;
        if (is四条())
            return 2;
        if (is葫芦())
            return 3;
        if (is同花())
            return 4;
        if (is顺子())
            return 5;
        if (is三条())
            return 6;
        return 7;
    }

    public boolean is同花顺() {
        return is同花() && is顺子();
    }

    public boolean is葫芦() {
        return max(nums) == 3 && is对(nums);
    }

    public boolean is三条() {
        return max(nums) == 3 && is单(nums);
    }

    public boolean is同花() {
        return sum(Hs) == 5 || sum(Ss) == 5 || sum(Cs) == 5 || sum(Ds) == 5;
    }

    public boolean is顺子() {
        for (int i = 0; i < 8; i++) {
            if (sum(nums, i) == 5)
                return true;
        }
        return false;
    }

    public boolean is四条() {
        return max(nums) == 4;
    }

    public int sum(int[] ints) {
        return Arrays.stream(ints).sum();
    }

    public int max(int[] ints) {
        return Arrays.stream(ints).max().getAsInt();
    }

    public boolean is对(int[] ints) {
        return Arrays.stream(ints).filter(i -> i == 2).count() > 0;
    }

    public boolean is单(int[] ints) {
        return Arrays.stream(ints).filter(i -> i == 1).count() > 0;
    }

    public int sum(int[] ints, int begin) {
        int[] ints1 = new int[5];
        System.arraycopy(ints, begin, ints1, 0, 5);
        return Arrays.stream(ints1).filter(i -> i == 1).sum();
    }

    public void init(String[] strings) {

        for (String str : strings) {
            String num = str.substring(0, 1);
            int n;
            String color = str.substring(1);
            switch (num.toUpperCase()) {
                case "J":
                    n = 11 - 2;
                    break;
                case "Q":
                    n = 12 - 2;
                    break;
                case "K":
                    n = 13 - 2;
                    break;
                case "A":
                    n = 14 - 2;
                    break;
                default:
                    n = Integer.parseInt(num) - 2;
            }
            nums[n]++;
            switch (color.toUpperCase()) {
                case "H":
                    Hs[n]++;
                    break;
                case "S":
                    Ss[n]++;
                    break;
                case "C":
                    Cs[n]++;
                    break;
                case "D":
                    Ds[n]++;
                    break;
            }
        }

    }
}
