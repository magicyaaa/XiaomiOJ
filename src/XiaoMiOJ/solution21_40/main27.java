package XiaoMiOJ.solution21_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 石头收藏家
 * @author: Ya
 * @create: 2019-05-23 00:04
 **/
public class main27 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line1;
        String line2;
        String line3;

        while (scan.hasNextLine()) {
            line1 = scan.nextLine().trim();
            line2 = scan.nextLine().trim();
            line3 = scan.nextLine().trim();
            System.out.println(method(line1, line2, line3));
        }
    }

    /**
     * dp算法
     * 01背包问题
     */
    private static int method(String line1, String line2, String line3) {
        int sum = Integer.parseInt(line1);
        String[] ss1 = line2.split(" ");
        int[] a1 = new int[ss1.length];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = Integer.parseInt(ss1[i]);
        }
        String[] ss2 = line3.split(" ");
        int[] a2 = new int[ss2.length];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = Integer.parseInt(ss2[i]);
        }

        int[][] dp = new int[a1.length + 1][sum + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a1[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a1[i-1]] + a2[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
