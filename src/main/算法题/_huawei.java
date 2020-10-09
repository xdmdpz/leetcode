package main.算法题;

import java.util.*;

/**
 * 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 判断牌型:
 * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 * 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 * 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 * 牌型6，三条：三张相同 + 两张单。
 * 牌型7，其他。
 * 说明：
 * 1）五张牌里不会出现牌大小和花色完全相同的牌。
 * 2）前面的牌型比后面的牌型大，如同花顺比四条大，依次类推。
 */
public class _huawei {
    ArrayList<String> colorLsit = new ArrayList<>();
    HashSet<String> colorSet = new HashSet<>();
    HashSet<String> numSet = new HashSet<>();
    ArrayList<String> numList = new ArrayList<>();
    static long begin, end;

    public static void main(String[] args) {
        //H红桃S黑桃C梅花D方片
        List<String> stringList = Arrays.asList("2 H", "3 S", "4 C", "5 H", "6 H");
        _huawei huawei = new _huawei();

        begin();
        System.out.println(huawei.fun(stringList));
        end();
    }

    private static void begin() {
        begin = System.currentTimeMillis();
        System.out.println("开始：" + begin);
    }

    private static void end() {
        end = System.currentTimeMillis();
        System.out.println("结束：" + end);
        System.out.println("耗时" + (end - begin));
    }


    public int fun(List<String> strings) {
        init(strings);
        if (is同花顺())
            return 1;
        if (is四条())
            return 2;
        if (is葫芦())
            return 3;
        if (is同花())
            return 4;
        if (is顺子())
            return 5;
        if (is三条())
            return 6;
        return 7;
    }

    public boolean is同花顺() {
        return is同花() && is顺子();
    }

    public boolean is葫芦() {
        return numSet.size() == 2 &&
                (!numList.get(0).equals(numList.get(1)) ||
                        !numList.get(numList.size() - 1).equals(numList.get(numList.size() - 2)));
    }

    public boolean is三条() {
        return numSet.size() == 3;
    }

    public boolean is同花() {
        return colorSet.size() == 1;
    }

    public boolean is顺子() {
        for (int i = 0; i < numList.size() - 1; i++) {
            if (Integer.parseInt(numList.get(i + 1)) - 1 == Integer.parseInt(numList.get(i))) {
                if (i == numList.size() - 2) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public boolean is四条() {
        return numSet.size() == 2;
    }


    public void init(List<String> strings) {

        for (int i = 0; i < 5; i++) {
            String num = strings.get(i).substring(0, 1);
            numList.add(num);
            numSet.add(num);
            String color = strings.get(i).substring(2);
            colorLsit.add(color);
            colorSet.add(color);

        }
        Collections.sort(numList);

    }
}
