package XiaoMiOJ.solution50_59;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 马走日
 * @author: Ya
 * @create: 2019-06-16 12:32
 **/
public class Main56 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int M = Integer.parseInt(scan.nextLine().trim());
            int N = Integer.parseInt(scan.nextLine().trim());
            String[] ss = scan.nextLine().trim().split(" ");
            int s_x = Integer.parseInt(ss[0]);
            int s_y = Integer.parseInt(ss[1]);
            ss = scan.nextLine().trim().split(" ");
            int t_x = Integer.parseInt(ss[0]);
            int t_y = Integer.parseInt(ss[1]);

            System.out.println(method(M, N, s_x, s_y, t_x, t_y));
        }
    }

    /**
     * 逆向推理
     * dp算法 递归
     * 每个目标点，均存在8个位置可一步到达目标点
     */
    private static int method(int M, int N, int s_x, int s_y, int t_x, int t_y) {
        int[][] dp = new int[M + 1][N + 1];
        dp[t_x][t_y] = 0;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{t_x, t_y});
        return method2(dp, list, s_x, s_y);
    }

    private static int method2(int[][] dp, List<int[]> list, int s_x, int s_y) {
        List<int[]> newList = new ArrayList<>();
        if (list.size() == 0) {
            return -1;
        }
        int x, y;
        for (int[] a : list) {
            x = a[0];
            y = a[1];
            if (x == s_x && y == s_y) {
                return dp[x][y];
            }
            //-1 -2
            if (x - 1 >= 0 && y - 2 >= 0 && dp[x - 1][y - 2] == 0) {
                dp[x - 1][y - 2] = dp[x][y] + 1;
                newList.add(new int[]{x - 1, y - 2});
            }
            //-1 +2
            if (x - 1 >= 0 && y + 2 < dp[0].length && dp[x - 1][y + 2] == 0) {
                dp[x - 1][y + 2] = dp[x][y] + 1;
                newList.add(new int[]{x - 1, y + 2});
            }
            //+1 +2
            if (x + 1 < dp.length && y + 2 < dp[0].length && dp[x + 1][y + 2] == 0) {
                dp[x + 1][y + 2] = dp[x][y] + 1;
                newList.add(new int[]{x + 1, y + 2});
            }
            //+1 -2
            if (x + 1 < dp.length && y - 2 >= 0 && dp[x + 1][y - 2] == 0) {
                dp[x + 1][y - 2] = dp[x][y] + 1;
                newList.add(new int[]{x + 1, y - 2});
            }
            //-2 -1
            if (x - 2 >= 0 && y - 1 >= 0 && dp[x - 2][y - 1] == 0) {
                dp[x - 2][y - 1] = dp[x][y] + 1;
                newList.add(new int[]{x - 2, y - 1});
            }
            //-2 +1
            if (x - 2 >= 0 && y + 1 < dp[0].length && dp[x - 2][y + 1] == 0) {
                dp[x - 2][y + 1] = dp[x][y] + 1;
                newList.add(new int[]{x - 2, y + 1});
            }
            //+2 -1
            if (x + 2 < dp.length && y - 1 >= 0 && dp[x + 2][y - 1] == 0) {
                dp[x + 2][y - 1] = dp[x][y] + 1;
                newList.add(new int[]{x + 2, y - 1});
            }
            //+2 +1
            if (x + 2 < dp.length && y + 1 < dp[0].length && dp[x + 2][y + 1] == 0) {
                dp[x + 2][y + 1] = dp[x][y] + 1;
                newList.add(new int[]{x + 2, y + 1});
            }
        }
        return method2(dp, newList, s_x, s_y);
    }

    /**
     * StackOverflowError
     */
    private static void mehtod(int[][] dp, int pre_x, int pre_y) {
        //-1 -2
        if (pre_x - 1 >= 0 && pre_y - 2 >= 0 && dp[pre_x - 1][pre_y - 2] > dp[pre_x][pre_y] + 1) {
            dp[pre_x - 1][pre_y - 2] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x - 1, pre_y - 2);
        }
        //-1 +2
        if (pre_x - 1 >= 0 && pre_y + 2 < dp[0].length && dp[pre_x - 1][pre_y + 2] > dp[pre_x][pre_y] + 1) {
            dp[pre_x - 1][pre_y + 2] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x - 1, pre_y + 2);
        }
        //+1 +2
        if (pre_x + 1 < dp.length && pre_y + 2 < dp[0].length && dp[pre_x + 1][pre_y + 2] > dp[pre_x][pre_y] + 1) {
            dp[pre_x + 1][pre_y + 2] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x + 1, pre_y + 2);
        }
        //+1 -2
        if (pre_x + 1 < dp.length && pre_y - 2 >= 0 && dp[pre_x + 1][pre_y - 2] > dp[pre_x][pre_y] + 1) {
            dp[pre_x + 1][pre_y - 2] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x + 1, pre_y - 2);
        }
        //-2 -1
        if (pre_x - 2 >= 0 && pre_y - 1 >= 0 && dp[pre_x - 2][pre_y - 1] > dp[pre_x][pre_y] + 1) {
            dp[pre_x - 2][pre_y - 1] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x - 2, pre_y - 1);
        }
        //-2 +1
        if (pre_x - 2 >= 0 && pre_y + 1 < dp[0].length && dp[pre_x - 2][pre_y + 1] > dp[pre_x][pre_y] + 1) {
            dp[pre_x - 2][pre_y + 1] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x - 2, pre_y + 1);
        }
        //+2 -1
        if (pre_x + 2 < dp.length && pre_y - 1 >= 0 && dp[pre_x + 2][pre_y - 1] > dp[pre_x][pre_y] + 1) {
            dp[pre_x + 2][pre_y - 1] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x + 2, pre_y - 1);
        }
        //+2 +1
        if (pre_x + 2 < dp.length && pre_y + 1 < dp[0].length && dp[pre_x + 2][pre_y + 1] > dp[pre_x][pre_y] + 1) {
            dp[pre_x + 2][pre_y + 1] = dp[pre_x][pre_y] + 1;
            mehtod(dp, pre_x + 2, pre_y + 1);
        }
    }
}
