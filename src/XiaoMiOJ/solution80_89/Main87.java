package XiaoMiOJ.solution80_89;

import util.ArrayUtil;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 美丽字符串
 * @author: Ya
 * @create: 2019-06-28 16:08
 **/
public class Main87 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static String method(String line) {
        int[] tag = new int[26]; // 记录26个英文字母出现的次数
        for (int i = 0; i < line.length(); i++) {
            tag[line.charAt(i) - 'a']++;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tag) {
            if (i != 0) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        if (map.size() < 2) {
            return "YES";
        } else if (map.size() > 2) {
            return "NO";
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (HashMap.Entry<Integer, Integer> e : map.entrySet()) {
                list.add(e.getKey());
                list.add(e.getValue());
            }
            if (Math.abs(list.get(0) - list.get(2)) == 1) { // 两种字母长度的差值不能超过1
                if (list.get(1) == 1 || list.get(3) == 1) {  //至少有1个 出现的次数为1
                    return "YES";
                }
            }
            return "NO";
        }
    }
}
