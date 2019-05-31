package XiaoMiOJ.solution31_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 国王招驸马
 * @author: Ya
 * @create: 2019-05-31 19:48
 **/
public class Main38 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int[] dp = new int[array.length];
        dp[0] = 1;
        for (int i = 0; i < array.length; i++) {
            if (dp[i] != 0) {
                for (int j = 1; j <= array[i] && i + j < array.length; j++) {
                    if (dp[i + j] == 0) {
                        dp[i + j] = dp[i] + 1;
                    } else if (dp[i + j] > dp[i] + 1) {
                        dp[i + j] = dp[i] + 1;
                    }
                }
            } else {
                return -1;
            }
        }
        return dp[dp.length - 1] - 1;
    }
}
