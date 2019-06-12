package XiaoMiOJ.solution40_49;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 数组差
 * @author: Ya
 * @create: 2019-06-12 13:27
 **/
public class Main46 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(mehtod(line));
        }
    }

    /**
     * 子集不包括空集  坑
     * <p>
     * 用例输入: "82"
     * 期望输出: "0"
     * 你的输出: "-2147483565"
     */
    private static int mehtod(String line) {
        String[] ss = line.split(",");
        if (ss.length <= 1) {
            return 0;
        }
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int[][] dp = new int[array.length][array.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                dp[i][j] = sum_dp(array, i, j);
            }
        }

        int res = Integer.MIN_VALUE;
        int min, max;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                if (i == 0 && j == dp[0].length) {
                    continue;
                }
                max = dp[i][j];
                min = findMin(dp, i, j);
                res = Math.max(max - min, res);
            }
        }
        return res;
    }

    private static int sum_dp(int[] array, int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += array[i];
            i++;
        }
        return sum;
    }

    private static int findMin(int[][] dp, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < start; i++) {
            for (int j = i; j < start; j++) {
                min = Math.min(dp[i][j], min);
            }
        }
        for (int i = end + 1; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                min = Math.min(dp[i][j], min);
            }
        }
        return min;
    }
}
