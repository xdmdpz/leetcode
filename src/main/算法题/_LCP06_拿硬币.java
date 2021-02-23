package main.算法题;

/**
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 * 通过次数32,000提交次数38,156
 */
public class _LCP06_拿硬币 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            if (coin == 1 || coin == 2) {
                result++;
                continue;
            }
            if (coin % 2 == 1)
                result += coin / 2 + 1;
            else
                result += coin / 2;
        }
        return result;
    }
}
