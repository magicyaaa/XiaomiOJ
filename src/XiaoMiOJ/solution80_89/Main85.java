package XiaoMiOJ.solution80_89;

import util.ArrayUtil;

import java.util.Scanner;


/**
 * @program: XiaomiOJ
 * @description: 抢劫
 * @author: Ya
 * @create: 2019-06-28 13:51
 **/
public class Main85 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method_dp(line));
        }
    }

    private static int method_dp(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        if (array.length > 1) {
            dp[1] = Math.max(array[0], array[1]);
        }
        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
