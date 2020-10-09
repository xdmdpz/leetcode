package main.算法题;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class _922_SortArrayByParityII {
    public static void main(String[] args) {
        int[] ints = {4, 2, 5, 7};
        Arrays.stream(new Solution().sortArrayByParityII(ints))
                .forEach(i -> System.out.print(i));
        System.out.println();
    }
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int a = 1, t = 0;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {

            if (A[i] % 2 == 0) {
                res[t] = A[i];
                t += 2;
            } else {
                res[a] = A[i];
                a += 2;
            }
        }
        return res;
    }
}