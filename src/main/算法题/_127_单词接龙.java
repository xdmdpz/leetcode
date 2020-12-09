package main.算法题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _127_单词接龙 {
    public static void main(String[] args) {
        new _127_单词接龙().tryExample();


    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String cur = beginWord;
        ArrayList<String> curWordList = new ArrayList<>(wordList) ;
        int count = 0;
        if (isDiff1(cur, endWord))
            return 2;
        while (true) {
            if (isDiff1(cur, endWord)) {
                return count + 2;
            } else {
                int tmp = 0;
                for (String word : curWordList) {
                    if (isDiff1(cur, word)) {
                        cur = word;
                        count++;
                        tmp++;
                        curWordList.remove(word);
                        break;
                    }
                }
                if (tmp == 0)
                    return 0;
            }
        }
    }

    private boolean isDiff1(String word, String diffWord) {
        int[] arr = new int[word.length()];
        char[] words = word.toCharArray();
        char[] diffWords = diffWord.toCharArray();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            arr[i] = words[i];
            arr[i] ^= diffWords[i];
            if (arr[i] != 0)
                count++;
        }
        return count == 1;
    }

    public void tryExample() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        //5
        System.out.println(ladderLength(beginWord, endWord, wordList));


        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");

        //0
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


}
