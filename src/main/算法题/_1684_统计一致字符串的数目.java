package main.算法题;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 */
public class _1684_统计一致字符串的数目 {
    public static void main(String[] args) {
        //2
        System.out.println(new _1684_统计一致字符串的数目()
                .countConsistentStrings("ab",
                        new String[]{"ad", "bd", "aaab", "baa", "badab"}
                ));
        //7
        System.out.println(new _1684_统计一致字符串的数目()
                .countConsistentStrings("abc",
                        new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}
                ));
        //4
        System.out.println(new _1684_统计一致字符串的数目()
                .countConsistentStrings("cad",
                        new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}
                ));

    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        int[] allow = new int['z' - 'a' + 1];
        char[] allowedChars = allowed.toCharArray();
        for (char ch : allowedChars)
            allow[ch - 'a']++;

        for (String word : words) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (allow[arr[i] - 'a'] == 0)
                    break;
                if (i == arr.length-1) {
                    count++;
                }
            }
        }
        return count;
    }
}