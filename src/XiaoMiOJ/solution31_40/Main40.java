package XiaoMiOJ.solution31_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 找小“3”
 * @author: Ya
 * @create: 2019-06-01 23:53
 **/
public class Main40 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method1(line));
        }
    }

    private static long method1(String line) {
        int len = line.length();
        long[] dp = new long[len + 1];  //记录 0 10 100 1000 10000...范围内分别有多少个3
        long count_3;
        int mid_num;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) { //i 长度
            count_3 = 0;
            for (int j = 1; j <= i; j++) {  // 第j位
                mid_num = i - 2;  //中间长度  已经排除了mid_num < 0
                mid_num = mid_num > 0 ? mid_num : 0;
                if (j == 1) {
                    count_3 += 9 * (Math.pow(10, mid_num));
                } else if (j == i) {
                    count_3 += 5 * (Math.pow(10, mid_num));
                } else {
                    count_3 += 9 * 5 * ((Math.pow(10, mid_num - 1)));
                }
            }
            dp[i] = count_3 + dp[i - 1];
        }

        int now; // 第几位
        char c;
        long res = 0;
        for (int i = 0; i < len; i++) {
            now = len - i;
            c = line.charAt(i);
            if (now == 1) {
                if (c - '0' >= 3) {
                    res += 1;
                }
                break;
            }
            if (c > '3') {
                res += dp[now - 1] * (c - '0') + (Math.pow(10, now - 1) / 2);
            } else if (c == '3') {
                res += dp[now - 1] * (c - '0') + (Integer.parseInt(line.substring(i + 1, len)) + 1) / 2;
            } else {
                res += dp[now - 1] * (c - '0');
            }
        }
        return res;
    }

    /**
     * 测试方法
     */
    private static int method(String line) {
        int num = Integer.parseInt(line);
        int count = 0;
        for (int i = 1; i <= num; i += 2) {
            count += howmany(i);
        }
        return count;
    }

    private static int howmany(int num) {
        int count = 0;
        String line = String.valueOf(num);
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '3') {
                count++;
            }
        }
        return count;
    }
}
