package main.算法题;

/**
 *
 */
public class _303_RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        int i=0,j =2;
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(i, j));

    }
}

class NumArray {
    private int[] sum;


    /**
     *  sum[i]表示到0到i的元素和，
     *  所以nums中i到j的元素和就可以转换为
     *  sum中sum[j]与sum[i-1]的差。
     * @param nums
     */
    public NumArray(int[] nums) {
        sum  = new int[nums.length];
        if(sum.length == 0)
            return;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = nums[i]+sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if(0 ==i )
            return sum[j];
        return sum[j]-sum[i-1];
    }
}