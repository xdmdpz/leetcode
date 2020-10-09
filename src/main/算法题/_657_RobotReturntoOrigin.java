package main.算法题;

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 */
public class _657_RobotReturntoOrigin {
    public static void main(String[] args) {
        System.out.println('R' + 0);
        System.out.println('L' + 0);
        System.out.println('U' + 0);
        System.out.println('D' + 0);
    }

    /**
     * 神仙解法，R(82) L(76) U(85) D(68)
     * -68    R(14) L(8)  U(17) D(0)
     */
    public boolean judgeCircle2(String moves) {
        char[] ch = moves.toCharArray();
        int[] a = new int[18];
        for (int i = 0; i < ch.length; i++) {
            a[ch[i] - 68]++;
        }

        return a[0] == a[17] && a[8] == a[14];
    }

    /**
     * 由于没有方向问题不存在，所以直接
     */
    public boolean judgeCircle(String moves) {

        int x = 0, y = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                x++;
                continue;
            }
            if (ch == 'D') {
                x--;
                continue;
            }
            if (ch == 'L') {
                y++;
                continue;
            }
            if (ch == 'R') {
                y--;
                continue;
            }
        }
        return x == 0 && y == 0;
    }

}
