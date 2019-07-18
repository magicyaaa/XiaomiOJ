package XiaoMiOJ.solution110_119;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 数数字游戏
 * @author: Ya
 * @create: 2019-07-17 15:09
 **/
public class Main117 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        int[] fib = createFib();
        boolean[][] dp = dp(10000, fib);
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line, dp));
        }

    }

    private static String method(String line, boolean[][] dp) {
        boolean res;
        String[] ss = line.split(" ");
        int num1 = Integer.parseInt(ss[0]);
        int num2 = Integer.parseInt(ss[1]);
        if (num1 >= num2) {
            res = dp[num1][num2];
        } else {
            res = dp[num2][num1];
        }
        return res ? "Xiaoai Win" : "Xiaobing Win";
    }

    /**
     * 生成一个fib数列
     */
    private static int[] createFib() {
        int[] fib = new int[20];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * 生成dp数组
     */
    private static boolean[][] dp(int n, int[] fib) {
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (!dp[i][j]) {
                    dp(dp, i, j, fib);
                }
            }
        }
        return dp;
    }

    private static void dp(boolean[][] dp, int i, int j, int[] fib) {
        for (int k = 1; k < fib.length; k++) {
            if (i + fib[k] <= 10000) {
                if (i + fib[k] >= j) {
                    dp[i + fib[k]][j] = true;
                } else {
                    dp[j][i + fib[k]] = true;
                }
            }
            if (i != j && j + fib[k] <= 10000) {
                if (j + fib[k] >= i) {
                    dp[j + fib[k]][i] = true;
                } else {
                    dp[i][j + fib[k]] = true;
                }
            }
        }
    }
}
