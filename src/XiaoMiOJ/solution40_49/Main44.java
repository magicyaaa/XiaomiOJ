package XiaoMiOJ.solution40_49;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 要多少个立方数
 * @author: Ya
 * @create: 2019-06-10 23:25
 **/
public class Main44 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method2(line));
        }
    }

    /**
     * 最少 应该用dp算法  (dp算法内存溢出)
     * 需要压缩算法
     * 还可以再来优化
     */
    private static int method2(String line) {
        int num = Integer.parseInt(line);
        List<Integer> list = new ArrayList<>();//保存立方数
        int c = 1;
        int temp;
        while (true) {
            temp = (int) Math.pow(c, 3);
            if (temp > num) {
                break;
            } else {
                list.add(temp);
            }
            c++;
        }
        Collections.sort(list);
        //dp算法 压缩
        int[] dp_pre = new int[num + 1];
        for (int i = 1; i < dp_pre.length; i++) {
            dp_pre[i] = i;
        }
        int[] dp_cur = new int[num + 1];
        for (int m = 1; m < list.size(); m++) {
            for (int n = 1; n < dp_cur.length; n++) {
                if (n - list.get(m) >= 0) {
                    dp_cur[n] = Math.min(dp_cur[n - list.get(m)] + 1, dp_pre[n]);
                } else {
                    dp_cur[n] = dp_pre[n];
                }
            }
            int[] temp1 = dp_pre;
            dp_pre = dp_cur;
            dp_cur = temp1;
        }
        return dp_pre[dp_cur.length - 1];
    }

    /**
     * 此方法内存溢出
     */
    private static int method(String line) {
        int num = Integer.parseInt(line);
        List<Integer> list = new ArrayList<>();//保存立方数
        int i = 1;
        int temp;
        while (true) {
            temp = (int) Math.pow(i, 3);
            if (temp > num) {
                break;
            } else {
                list.add(temp);
            }
            i++;
        }
        Collections.sort(list);
        //dp算法
        int[][] dp = new int[list.size() + 1][num + 1];
        //无穷大表示不能换到
        for (int m = 0; m < dp.length; m++) {
            for (int n = 1; n < dp[0].length; n++) {
                dp[m][n] = Integer.MAX_VALUE;
            }
        }

        for (int m = 1; m < dp.length; m++) { //记录 立方数
            for (int n = 0; n < dp[0].length; n++) { //记录能到达的num
                if (n - list.get(m - 1) >= 0) {
                    dp[m][n] = Math.min(dp[m][n - list.get(m - 1)] + 1, dp[m - 1][n]);
                } else {
                    dp[m][n] = dp[m - 1][n];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
