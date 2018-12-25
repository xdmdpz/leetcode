package main;

/**
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class _557_ReverseWordsinaStringIII {
//    用 344解法 将 split后的词组倒叙
//    public String reverseWords(String s) {
//        String[] words = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (String word : words) {
//            sb.append(" ").append(reverseString(word));
//        }
//        return sb.toString().substring(1);
//    }
//
//    public String reverseString(String s) {
//        char[] array = s.toCharArray();
//        int len = array.length;
//        int middle = len / 2;
//
//        for (int i = 0; i < middle; i++) {
//            char tmp = array[i];
//            array[i] = array[len - 1 - i];
//            array[len - 1 - i] = tmp;
//        }
//
//        return new String(array);
//    }
    public String reverseWords(String s ){
        char[] cl = s.toCharArray();
        int start = 0;
        int nextSpace = s.indexOf(' ',start);
        while(nextSpace != -1) {
            reverse(cl,start,nextSpace - 1);
            start = ++nextSpace;
            nextSpace = s.indexOf(' ',start);
        }
        reverse(cl,start,cl.length - 1);
        return new String(cl);
    }

    public void reverse(char[] cl,int start,int end){
        while(start < end){
            char temp = cl[start];
            cl[start] = cl[end];
            cl[end] = temp;
            start ++;
            end --;
        }
    }
    public static void main(String[] args) {
        System.out.println(new _557_ReverseWordsinaStringIII()
                .reverseWords("Let's take LeetCode contest"));
    }

}
