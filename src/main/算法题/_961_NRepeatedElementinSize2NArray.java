package main.算法题;

import java.util.HashSet;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */
public class _961_NRepeatedElementinSize2NArray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};

        System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes1(A));
    }

    /**
     * O(N) time, O(N) space
     * <p>
     * 由题意知只有一个数字重复了N次
     * <p>
     * 只要是有1次重复的数据就为最终结果
     *
     * @param A
     * @return
     */
    public int repeatedNTimes0(int[] A) {
        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;
    }

    public int repeatedNTimes1(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A)
            if (!set.add(a))
                return a;
        return 0;
    }

    public int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }


}
