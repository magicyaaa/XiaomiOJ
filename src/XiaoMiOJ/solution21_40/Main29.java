package XiaoMiOJ.solution21_40;


import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 扑克游戏
 * @author: Ya
 * @create: 2019-05-25 10:38
 **/
public class Main29 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 比较规则是 ： 顺子 > 4条 > 葫芦 > 3条 > 2对 > 1对 > 单张
     * 没有joke,没有花色
     */
    private static String method(String line) {
        String[] ss = line.split(",");
        String[] ss1 = ss[0].split(" ");
        String[] ss2 = ss[1].split(" ");

        int[] p1 = new int[5];
        int[] p2 = new int[5];

        for (int i = 0; i < p1.length; i++) {
            p1[i] = rankPoke(ss1[i]);
            p2[i] = rankPoke(ss2[i]);
        }

        Arrays.sort(p1);
        Arrays.sort(p2);

        long rand1 = rankPoke(p1);
        long rand2 = rankPoke(p2);
        System.out.println("System.out...... -> " + rand1);
        System.out.println("System.out...... -> " + rand2);

        if (rand1 == rand2) {
            return "draw";
        } else if (rand1 > rand2) {
            return "win";
        } else {
            return "lose";
        }

    }

    /**
     * 获取排面renk值
     */
    private static int rankPoke(String s) {
        char c = s.charAt(0);
        switch (c) {
            case '1':
                return 10;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return 0;
        }
    }

    /**
     * 不考虑花色,获取排面rank
     */
    private static long rankPoke(int[] pokes) {
        // 顺子 1+1+1+1+1
        // 4条  4+1
        // 葫芦 3+2
        // 3条  3+1+1
        // 2对  2+2+1
        // 1对  2+1+1+1+1
        // 单张 1+1+1+1+1
        //  5 4 3 2 1. 1 2 3 4 5
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pokes.length; i++) {
            if (map.containsKey(pokes[i])) {
                map.put(pokes[i], map.get(pokes[i]) + 1);
            } else {
                map.put(pokes[i], 1);
            }
        }

        int size = map.size();
        switch (size) {
            case 2:    //4+1 3+2
                return is2(map);
            case 3:    // 3+1+1 2+2+1
                return is3(map);
            case 4:    // 2+1+1+1
                return is4(map);
            case 5:    //1+1+1+1+1
                return is5(pokes);
            default:
                return 0;
        }
    }

    //四条 或 葫芦 4+1 3+2
    private static long is2(HashMap<Integer, Integer> map) {
        int four = 0;
        int one = 0;
        int three = 0;
        int two = 0;
        long res = 0;

        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value == 4) {
                four = key;
            } else if (value == 3) {
                three = key;
            } else if (value == 2) {
                two = key;
            } else if (value == 1) {
                one = key;
            }
        }

        if (four == 0) { //葫芦
            res += three * Math.pow(10, 8);
            res += two * Math.pow(10, 5);
        } else { //四条
            res += four * Math.pow(10, 9);
            res += one;
        }
        return res;
    }

    //三条或两对 3+1+1  2+2+1
    private static long is3(HashMap<Integer, Integer> map) {
        long res = 0;
        int three = 0;
        int single1 = 0;
        int single2 = 0;
        int duizi1 = 0;
        int duizi2 = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value == 3) {
                three = key;
            } else if (value == 2) {
                if (duizi1 == 0) {
                    duizi1 = key;
                } else {
                    duizi2 = key;
                }
            } else if (value == 1) {
                if (single1 == 0) {
                    single1 = key;
                } else {
                    single2 = key;
                }
            }
        }

        if (three == 0) { //两对 2+2+1
            res += Math.max(duizi1, duizi2) * Math.pow(10, 6);
            res += Math.min(duizi1, duizi2) * Math.pow(10, 5);
            res += single1;
        } else { //三条 3+1+1
            res += three * Math.pow(10, 7);
            res += Math.max(single1, single2) * 10;
            res += Math.min(single1, single2);
        }
        return res;
    }

    //对子 2+1+1+1
    private static long is4(HashMap<Integer, Integer> map) {
        long res = 0;
        int duizi = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value == 2) {
                duizi = key;
            } else {
                list.add(key);
            }
        }
        Collections.sort(list);
        res += duizi * Math.pow(10, 5);

        for (int i = 0; i < list.size(); i++) {
            res += list.get(i) * Math.pow(10, i);
        }
        return res;
    }

    //单 或 顺子
    private static long is5(int[] a) {
        long res = isShunzi(a);
        if (res != 0) {
            return res;
        }

        for (int i = 0; i < 5; i++) {
            res += a[i] * Math.pow(i, 10);
        }
        return res;
    }

    private static long isShunzi(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i] + 1) {
                continue;
            } else {
                return 0;
            }
        }
        return (long) (a[4] * Math.pow(10, 10));
    }
}
