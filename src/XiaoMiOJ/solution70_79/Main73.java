package XiaoMiOJ.solution70_79;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 找出单独出现的数字II
 * @author: Ya
 * @create: 2019-06-21 18:47
 **/
public class Main73 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method_set(line));
        }
    }

    /**
     * 利用hash set
     */
    private static String method_hashSet(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toString();
            }
        }
        return "error";
    }

    /**
     * 利用Set
     */
    private static String method_set(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        HashSet<Integer> set1 = new HashSet<>(array.length);
        HashSet<Integer> set = new HashSet<>(array.length * 2);
        for (int i : array) {
            if (set.contains(i)) {
                set1.remove(i);
            } else {
                set.add(i);
                set1.add(i);
            }
        }

        for (Integer i : set1) {
            return i.toString();
        }
        return "error";
    }

    //还有一种位运算方式- -
}
