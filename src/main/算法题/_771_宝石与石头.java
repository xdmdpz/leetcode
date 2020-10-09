package main.算法题;

import java.util.HashSet;
import java.util.Set;

public class _771_宝石与石头 {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

    }

    public int numJewelsInStones1(String J, String S) {
        if (J.length() > 50 || S.length() > 50) {
            return 0;
        }
        char[] Js = J.toCharArray();
        char[] Ss = S.toCharArray();
        int result = 0;
        for (int i = 0; i < Js.length; i++) {
            for (int j = 0; j < Ss.length; j++) {
                if (Js[i] == Ss[j])
                    result++;
            }
        }
        return result;
    }
    public int numJewelsInStones2(String J, String S) {
        if (J.length() > 50 || S.length() > 50) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add((int) j);
        }
        int result = 0;
        for (char s : S.toCharArray()) {
            if (set.contains((int)s)) result++;
        }
        return result;
    }

    public int numJewelsInStones_网上的(String J, String S) {
        if (J.length() > 50 || S.length() > 50) {
            return 0;
        }
        int[] count = new int[64];
        for (char c : J.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (count[c - 'A'] >= 1) ans++;
        }
        return ans;
    }
}
