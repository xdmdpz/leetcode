package main;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class _977_有序数组的平方 {
    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};

        Arrays.stream(new _977_有序数组的平方().sortedSquares(A))
                .forEach(i -> System.out.print(i));
        System.out.println();
    }

    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(a -> a*=a).sorted().toArray();
    }

    public int[] sortedSquares1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);

        return ans;
    }

    /**
     *  官方双指针解法
     *
     * 思路
     *
     * 因为数组 A 已经排好序了， 所以可以说数组中的负数已经按照平方值降序排好了，数组中的非负数已经按照平方值升序排好了。
     *
     * 举一个例子，若给定数组为 [-3, -2, -1, 4, 5, 6]，数组中负数部分 [-3, -2, -1] 的平方为 [9, 4, 1]，数组中非负部分 [4, 5, 6] 的平方为 [16, 25, 36]。我们的策略就是从前向后遍历数组中的非负数部分，并且反向遍历数组中的负数部分。
     *
     *
     *
     * @param A
     * @return
     */
    public int[] sortedSquares2(int[] A) {
        //数组长度
        int N = A.length;

        //正向读取证书部分
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        //反向读取负数部分
        int i = j-1;


        //平方数组
        int[] ans = new int[N];
        int t = 0;

        //双指针同时移动
        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        //剩余i移动
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        //剩余j移动
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

}
