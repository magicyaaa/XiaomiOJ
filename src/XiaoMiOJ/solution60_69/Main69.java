package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 合法字符串
 * @author: Ya
 * @create: 2019-06-19 22:06
 **/
public class Main69 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method_dp(line));
        }
    }

    /**
     * dp算法
     */
    private static long method_dp(String line) {
        int target = Integer.parseInt(line);
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 3;
        } else if (target == 2) {
            return 9;
        } else if (target == 3) {
            return 24;
        }
        long[] dp = new long[target + 1];
        dp[1] = 3;
        dp[2] = 9;
        dp[3] = 24;
        for (int i = 4; i <= target; i++) {
            dp[i] = dp[i - 1] * 3 - dp[i - 3] * 2;
        }
        return dp[target];
    }

    /**
     * 递归
     * 应该用long类型
     * 递归效率太低了 应该用dp算法
     */
    private static long method_recurrence(String line) {
        int target = Integer.parseInt(line);
        if (target < 1) {
            return 0;
        }
        return method_recurrence(3L, 2, target, false);
    }

    /**
     * status false和上一个不同  true相同
     */
    private static long method_recurrence(long res, int num, int target, boolean status) {
        if (num > target) {
            return res;
        }
        if (status) { //上一个与其前一个相同，那么当前只能不同
            return method_recurrence(res * 2L, num + 1, target, false);
        } else {// 上一个与其前一个不同
            //可以相同 也可以以不同
            return method_recurrence(res, num + 1, target, true)
                    + method_recurrence(res * 2L, num + 1, target, false);
        }
    }
}
