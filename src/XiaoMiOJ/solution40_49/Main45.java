package XiaoMiOJ.solution40_49;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 德州扑克
 * @author: Ya
 * @create: 2019-06-11 20:06
 **/
public class Main45 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method1(line));
        }
    }

    private static String method1(String line) {
        String[] ss = line.split(" ");
        // String[] pokes = new String[5];
        int num_m = 0;
        List<Integer> list = new ArrayList<>();
        for (String s : ss) {
            if (s.equals("M")) {
                num_m++;
            } else {
                list.add(reverse(s.substring(1, s.length())));
            }
        }
        if (num_m >= 4) { //4张m 直接同花顺
            return "Straight Flush";
        }

        //判断顺子
        boolean straight = true;
        //先判断有没有对子及以上
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
            } else {
                straight = false;
            }
        }
        if (straight) {
            Collections.sort(list);
            int dif = 0;
            for (int i = 1; i < list.size(); i++) {
                dif += list.get(i) - list.get(i - 1) - 1;
            }
            if (dif <= num_m) {
                straight = true;
            } else {
                straight = false;
            }

            // 判断 10 J Q K A
            if (list.get(0) == 1 && !straight) {
                list.remove(0);
                list.add(14);
                Collections.sort(list);
                dif = 0;
                for (int i = 1; i < list.size(); i++) {
                    dif += list.get(i) - list.get(i - 1) - 1;
                }
                if (dif <= num_m) {
                    straight = true;
                } else {
                    straight = false;
                }
            }
        }

        boolean flush = true;
        //判断同花
        char flush_temp = ' ';
        for (String s : ss) {
            if (s.length() > 1) {
                if (flush_temp == ' ') {
                    flush_temp = s.charAt(0);
                } else {
                    if (flush_temp != s.charAt(0)) {
                        flush = false;
                        break;
                    }
                }
            }
        }

        if (flush && straight) {
            return "Straight Flush";
        } else if (flush) {
            return "Flush";
        } else if (straight) {
            return "Straight";
        } else {
            return "GG";
        }
    }

    private static int reverse(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }
        switch (s) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return 1;
        }
    }
}
