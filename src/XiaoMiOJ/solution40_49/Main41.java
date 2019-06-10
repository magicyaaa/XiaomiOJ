package XiaoMiOJ.solution40_49;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 字符串替换
 * @author: Ya
 * @create: 2019-06-05 11:08
 **/
public class Main41 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * dp算法  即最小编辑代价 ,插入 删除 替换 (ic dc rc) 的编辑代价都为1
     */
    private static int method(String line) {
        String[] ss = line.split(",");
        String line1 = ss[0];
        String line2 = ss[1];

        int[][] dp = new int[line2.length() + 1][line1.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (line1.charAt(j - 1) == line2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
