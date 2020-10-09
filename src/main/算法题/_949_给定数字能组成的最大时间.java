package main.算法题;

import java.util.*;

/**
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * <p>
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * <p>
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 * <p>
 * 输入：[5,5,5,5]
 * 输出：""
 */
public class _949_给定数字能组成的最大时间 {
    public static void main(String[] args) {
        System.out.println(new _949_给定数字能组成的最大时间().largestTimeFromDigits2(new int[]{1, 9, 6, 0}));
        System.out.println(new _949_给定数字能组成的最大时间().largestTimeFromDigits2(new int[]{5, 5, 5, 5}));
    }


    public String largestTimeFromDigits2(int[] A) {
        if (!init(A))
            return "";
        List<Integer> integers = new ArrayList<>();
        fullSort(A, 0, A.length - 1, integers);

        return toDateTime(integers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1));

    }

    public void fullSort(int[] arr, int start, int end, List<Integer> integers) {
        // 递归终止条件
        if (start == end) {
            StringBuilder string = new StringBuilder();
            for (int i : arr) {
                string.append(i);
            }
            if (toInt(string.toString()) != -1)
                integers.add(Integer.parseInt(string.toString()));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end, integers);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public String toDateTime(Integer integer) {
        return integer == -1 ? ""
                : String.format("%02d", Integer.parseInt(String.valueOf(integer / 100)))
                + ":" + String.format("%02d", Integer.parseInt(String.valueOf(integer % 100)));
    }

    public boolean init(int[] ints) {
        int count = 0;
        for (int i : ints) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                    count++;
                    break;
                case 3:
                    count++;
                    break;
                case 4:
                case 5:
                    count++;
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    count++;
                    break;
            }
        }
        return count == 4;
    }

    public int toInt(String ints) {
        int res = Integer.parseInt(ints);
        if (res / 100 > 23)
            return -1;
        if (res % 100 > 59)
            return -1;
        return res;
    }




    public String largestTimeFromDigits(int[] A) {
        if (!init(A))
            return "";
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if ((i != j) &&
                                (i != k) &&
                                (i != l) &&
                                (k != j) &&
                                (k != l) &&
                                (l != j)
                        ) {
                            int a = toInt(A, new int[]{i, j, k, l});
                            if (a != -1)
                                integers.add(a);
                        }
                    }
                }
            }
        }
        return toDateTime(integers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1));
    }

    public int toInt(int[] ints, int[] sort) {
        int res = ints[sort[0]] * 1000
                + ints[sort[1]] * 100
                + ints[sort[2]] * 10
                + ints[sort[3]];
        if (res / 100 > 23)
            return -1;
        if (res % 100 > 59)
            return -1;
        return res;
    }


}
