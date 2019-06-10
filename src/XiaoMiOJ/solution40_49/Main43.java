package XiaoMiOJ.solution40_49;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: XiaomiOJ
 * @description: 寻找归一数字
 * @author: Ya
 * @create: 2019-06-05 15:07
 **/
public class Main43 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static boolean method(String line) {
        int num = Integer.parseInt(line);
        Set<Integer> set = new HashSet<>();
        return method(num, set);
    }

    private static boolean method(int num, Set<Integer> set) {
        int res = 0;
        while (num > 0) {
            res += Math.pow(num % 10, 2);
            num /= 10;
        }
        if (set.contains(res)) {
            return false;
        }
        if (res != 1) {
            set.add(res);
            return method(res, set);
        } else {
            return true;
        }
    }
}
