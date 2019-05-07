package XiaoMiOJ;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 爬楼梯
 * @author: Ya
 * @create: 2019-05-06 22:13
 **/
public class Main10 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * dp算法即可
     */
    private static int method(String line) {
        int num = Integer.parseInt(line);
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        int[] dp = new int[num + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[num];
    }
}
