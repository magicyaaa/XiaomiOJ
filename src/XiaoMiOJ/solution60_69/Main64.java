package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 跳跳看
 * @author: Ya
 * @create: 2019-06-18 23:54
 **/
public class Main64 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
            System.out.println(method2(line));
        }
    }

    /**
     * dp算法
     */
    private static int method(String line) {
        String[] ss = line.split(" ");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= array[i] && i + j < array.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 检查一下这个方法为啥不对
     */
    private static int method2(String line) {
        String[] ss = line.split(" ");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= array[i]; j++) {
                if (i + j >= array.length) {
                    return dp[i] + 1;
                } else if (dp[i + j] == 0) {
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
