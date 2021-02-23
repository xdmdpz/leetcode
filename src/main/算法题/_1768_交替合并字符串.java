package main.算法题;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 */
public class _1768_交替合并字符串 {
    public static void main(String[] args) {
        System.out.println(new _1768_交替合并字符串().mergeAlternately("abc", "pqr"));
        System.out.println(new _1768_交替合并字符串().mergeAlternately("ab", "pqrs"));
        System.out.println(new _1768_交替合并字符串().mergeAlternately("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (; i < Math.min(words1.length, words2.length); i++) {
            result.append(words1[i]);
            result.append(words2[i]);
        }
        for (; i < Math.max(words1.length, words2.length); i++) {
            if (i < words1.length) {
                result.append(words1[i]);
                continue;
            }
            result.append(words2[i]);

        }
        return result.toString();
    }
}
