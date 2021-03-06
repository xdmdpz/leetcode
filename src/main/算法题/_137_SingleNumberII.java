package main.算法题;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class _137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res |=i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {2,2,1,2};
        System.out.println(new _137_SingleNumberII().singleNumber(ints));
    }
}
