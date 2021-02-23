package main.算法题;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class _1678_设计Goal解析器 {
    public static void main(String[] args) {
        System.out.println(new _1678_设计Goal解析器().interpret("G()(al)"));
        System.out.println(new _1678_设计Goal解析器().interpret("G()()()()(al)"));
        System.out.println(new _1678_设计Goal解析器().interpret("(al)G(al)()()G"));
    }

    public String interpret(String command) {
//        return command.replace("()","o").replace("(al)","al");
        StringBuilder result = new StringBuilder();
        char[] chars = command.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'G') {
                result.append('G');
                i++;
                continue;
            }
            if (chars[i] == '(') {
                if (chars[i + 1] == ')') {
                    result.append('o');
                    i += 2;
                    continue;
                }
                if (chars[i + 1] == 'a') {
                    result.append('a').append('l');
                    i += 4;
                }
            }
        }
        return result.toString();
    }
}
