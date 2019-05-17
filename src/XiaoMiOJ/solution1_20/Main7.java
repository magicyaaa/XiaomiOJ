package XiaoMiOJ.solution1_20;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: XiaomiOJ
 * @description: 第一个缺失正数
 * @author: Ya
 * @create: 2019-05-05 20:15
 **/
public class Main7 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 用hashset实现O(n)
     */
    private static int method(String line) {
        String[] ss = line.split(",");
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int cur = 0;
        for (String s : ss) {
            cur = Integer.parseInt(s);
            if (cur > max) {
                max = cur;
            }
            if (cur > 0) {
                set.add(cur);
            }
        }

        for (int i = 1; i <= max; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        return max + 1;
    }
}
