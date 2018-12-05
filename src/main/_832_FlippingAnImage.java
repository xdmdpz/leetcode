package main;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2:
 * <p>
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class _832_FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] newInts = new int[A[i].length];
            for (int j = 0 ;j<A[i].length;j++){
                newInts[A[i].length-j-1] = A[i][j] ==0 ? 1:0;
            }
            A[i]  = newInts;
        }
        return A;
    }


    public static void main(String[] args) {
        int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        Arrays.stream(input).forEach(ints -> {
                    Arrays.stream(ints).forEach(i ->
                            System.out.printf(i+",")
                    );
                    System.out.println();
                }
        );
        System.out.println("-----------------------");
        Arrays.stream(flipAndInvertImage(input)).forEach(ints -> {
                    Arrays.stream(ints).forEach(i ->
                            System.out.printf(i+",")
                    );
                    System.out.println();
                }
        );
    }
}
