package main.算法题;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class _461_HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(111, 222));
        System.out.println(hammingDistance2(111, 222));
        System.out.println(hammingDistance3(111, 222));
    }

    /**
     * x与y异或 然后统计1的个数
     */
    public static int hammingDistance(int x, int y) {
        int res = 0, exc = x ^ y;
        for (int i = 31; i >= 0; i--) {
            res += (exc >> i) & 1;
        }
        return res;
    }

    /**
     * 递归解法
     */
    public static int hammingDistance2(int x, int y) {
        if ((x ^ y) == 0) return 0;
        return (x ^ y) % 2 + hammingDistance2(x / 2, y / 2);
    }

    /**
     *  网上看到的  循环次数为异或后1的个数
     */
    public static  int hammingDistance3(int x, int y) {
        int res = 0, exc = x ^ y;
        while (exc!= 0) {
            ++res;
            exc &= (exc - 1);
        }
        return res;
    }
    public static String toBinary2(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 31; i >= 0; i--)
            str.append(n >>> i & 1);
        return str.toString();
    }


}
