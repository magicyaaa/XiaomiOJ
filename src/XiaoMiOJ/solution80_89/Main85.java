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

    /**
     * dp算法
     * 为啥不对啊 ？？？？？？？？
     */
    private static int method_dp(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        if (dp.length > 1) {
            dp[1] = array[1];
        } else {
            return dp[0];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.max(dp[i - 2] + array[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
