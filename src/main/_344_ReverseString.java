package main;

/**
 * 344. Reverse String 翻转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class _344_ReverseString {
    public String reverseString(String s) {
//        char[] chars = s.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < chars.length; i++) {
//            sb.append(chars[chars.length - 1 - i]);
//        }
//        return sb.toString();
        char[] array = s.toCharArray();
        int len = array.length;
        int middle = len / 2;

        for (int i = 0; i < middle; i++) {
            char tmp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = tmp;
        }
        return new String(array);
    }



    public static void main(String[] args) {
        _344_ReverseString a = new _344_ReverseString() {
        };

        System.out.println(a.reverseString("hello"));
        System.out.println(a.reverseString("A man, a plan, a canal: Panama"));
    }
}
