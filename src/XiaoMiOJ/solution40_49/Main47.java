package XiaoMiOJ.solution40_49;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 硬币比赛
 * @author: Ya
 * @create: 2019-06-12 18:21
 **/
public class Main47 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method_dp(line));
        }
    }

    /**
     * 递归方式
     */
    private static boolean method(String line) {
        String[] ss = line.split(",");
        if (ss.length <= 2) {
            return true;
        }
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        return method1(array, -1, 0, 0, 0) || method1(array, -1, 1, 0, 0);
    }

    private static boolean method1(int[] array, int pre, int next, int sum1, int sum2) {
        if (next >= array.length) {
            ++pre;
            while (pre < array.length) {
                sum1 += array[pre];
                ++pre;
            }
            return sum1 > sum2;
        }
        pre++;
        while (pre <= next) {
            sum1 += array[pre];
            pre++;
        }
        return method2(array, next, next + 1, sum1, sum2) && method2(array, next, next + 2, sum1, sum2);
    }

    private static boolean method2(int[] array, int pre, int next, int sum1, int sum2) {
        if (next >= array.length) {
            ++pre;
            while (pre < array.length) {
                sum2 += array[pre];
                ++pre;
            }
            return sum1 > sum2;
        }
        pre++;
        while (pre <= next) {
            sum2 += array[pre];
            pre++;
        }
        return method1(array, next, next + 1, sum1, sum2) || method2(array, next, next + 2, sum1, sum2);
    }

    /**
     * dp
     */
    private static boolean method_dp(String line) {
        String[] ss = line.split(",");
        if (ss.length <= 2) {
            return true;
        }
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int[] dp = new int[array.length];
        int n = dp.length;
        dp[n - 1] = array[n - 1];
        dp[n - 2] = array[n - 1] + array[n - 2];
        dp[n - 3] = array[n - 3] + array[n - 2];
        if (n >= 4) {
            dp[n - 4] = Math.max(array[n - 4] + array[n - 1], array[n - 4] + array[n - 3]);
        }
        for (int i = array.length - 5; i >= 0; i--) {
            dp[i] = Math.max(array[i] + Math.min(dp[i + 2], dp[i + 3]), array[i] + array[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return dp[0] > sum / 2;
    }
}
