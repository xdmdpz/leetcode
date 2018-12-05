package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class _905_SortArrayByParity {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        for (int i : sortArrayByParity2(A)) {
            System.out.println(i);
        }
    }
    public static int[] sortArrayByParity(int[] A) {
        List<Integer> _246 = new ArrayList<>();
        List<Integer> _135 = new ArrayList<>();

        for (int i : A)
            if (i % 2 == 0)
                _246.add(i);
            else
                _135.add(i);
        _246.addAll(_135);
        return _246.stream().mapToInt(Integer::valueOf).toArray();

    }
    public static int[] sortArrayByParity2(int[] A) {
        int _2431[]=new int[A.length];
        int count=0;
        for (int i:A)
            if (i%2==0)
                _2431[count++]=i;
        for (int i:A)
            if (i%2==1)
                _2431[count++]=i;
        return _2431;

    }


}
