package XiaoMiOJ.solution50_59;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 漂流瓶
 * @author: Ya
 * @create: 2019-06-16 18:34
 **/
public class Main59 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if (line.length() < 1) {
                break;
            }
            list.add(line.split(" "));
        }
        //list = test();
        System.out.println(method(list));
    }

    /**
     * test
     * 随机生成5x5的矩阵 测试用
     */
    private static List<String[]> test() {
        List<String[]> list1 = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                int num = (int) (Math.random() * 20);
                sb.append(num + " ");
            }
            list1.add(sb.toString().trim().split(" "));
        }
        return list1;
    }

    private static String method(List<String[]> list) {
        //整理成二维数组
        int[][] array = new int[list.size()][list.get(0).length];
        for (int i = 0; i < array.length; i++) {
            int[] temp = new int[list.get(i).length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(list.get(i)[j]);
            }
            array[i] = temp;
        }
        //ArrayUtil.printArray(array);
        //System.out.println("====");

        int[][] dp = new int[array.length][array[0].length];// 1为可到达太平洋 2为大西洋 3为都可到达
        //先标记好边界
        for (int i = 0; i < array.length - 1; i++) {
            dp[i][0] = 1;
            if (dp[dp.length - i - 1][dp[0].length - 1] == 1) {
                dp[dp.length - i - 1][dp[0].length - 1] = 3;
            } else {
                dp[dp.length - i - 1][dp[0].length - 1] = 2;
            }
        }
        for (int j = 0; j < array[0].length; j++) {
            dp[0][j] = 1;
            if (dp[dp.length - 1][dp[0].length - j - 1] == 1) {
                dp[dp.length - 1][dp[0].length - j - 1] = 3;
            } else {
                dp[dp.length - 1][dp[0].length - j - 1] = 2;
            }
        }
        dp[0][dp[0].length - 1] = 3;
        dp[dp.length - 1][0] = 3;
        //可到达太平洋的
        for (int i = 0; i < array.length; i++) {
            method(array, dp, i, 0, true);
            //System.out.println(i + " " + 0);
            //ArrayUtil.printArray(dp);
        }
        for (int j = 0; j < array[0].length; j++) {
            method(array, dp, 0, j, true);
            //System.out.println(0 + " " + j);
            //ArrayUtil.printArray(dp);
        }
        //可到达大西洋的
        //System.out.println("System.out...... -> " + "大西洋");
        for (int i = 0; i < array.length; i++) {
            method(array, dp, i, dp[0].length - 1, false);
            //System.out.println(i + " " + (dp[0].length - 1));
            //ArrayUtil.printArray(dp);
        }
        for (int j = 0; j < array[0].length; j++) {
            method(array, dp, dp.length - 1, j, false);
            //System.out.println((dp.length - 1) + " " + j);
            //ArrayUtil.printArray(dp);
        }
        //ArrayUtil.printArray(dp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 3) {
                    sb.append(i + " " + j + "\n");
                }
            }
        }

        //System.out.println("====");
        //ArrayUtil.printArray(array);
        return sb.toString();
    }

    /**
     * 递归逆向漂流—。—
     */
    private static void method(int[][] array, int[][] dp, int x, int y, boolean ocean) {
        //上
        if (x - 1 >= 0 && array[x - 1][y] >= array[x][y]) {
            if (ocean) {
                if (dp[x - 1][y] == 0) {
                    dp[x - 1][y] = 1;
                    method(array, dp, x - 1, y, ocean);
                } else if (dp[x - 1][y] == 2) {
                    dp[x - 1][y] = 3;
                    method(array, dp, x - 1, y, ocean);
                }
            } else {
                if (dp[x - 1][y] == 1) {
                    dp[x - 1][y] = 3;
                    method(array, dp, x - 1, y, ocean);
                } else if (dp[x - 1][y] == 0) {
                    dp[x - 1][y] = 2;
                    method(array, dp, x - 1, y, ocean);
                }
            }
        }
        //下
        if (x + 1 < array.length && array[x + 1][y] >= array[x][y]) {
            if (ocean) {
                if (dp[x + 1][y] == 0) {
                    dp[x + 1][y] = 1;
                    method(array, dp, x + 1, y, ocean);
                } else if (dp[x + 1][y] == 2) {
                    dp[x + 1][y] = 3;
                    method(array, dp, x + 1, y, ocean);
                }
            } else {
                if (dp[x + 1][y] == 1) {
                    dp[x + 1][y] = 3;
                    method(array, dp, x + 1, y, ocean);
                } else if (dp[x + 1][y] == 0) {
                    dp[x + 1][y] = 2;
                    method(array, dp, x + 1, y, ocean);
                }
            }
        }
        //左
        if (y - 1 >= 0 && array[x][y - 1] >= array[x][y]) {
            if (ocean) {
                if (dp[x][y - 1] == 0) {
                    dp[x][y - 1] = 1;
                    method(array, dp, x, y - 1, ocean);
                } else if (dp[x][y - 1] == 2) {
                    dp[x][y - 1] = 3;
                    method(array, dp, x, y - 1, ocean);
                }
            } else {
                if (dp[x][y - 1] == 1) {
                    dp[x][y - 1] = 3;
                    method(array, dp, x, y - 1, ocean);
                } else if (dp[x][y - 1] == 0) {
                    dp[x][y - 1] = 2;
                    method(array, dp, x, y - 1, ocean);
                }
            }
        }
        //右
        if (y + 1 < array[0].length && array[x][y + 1] >= array[x][y]) {
            if (ocean) {
                if (dp[x][y + 1] == 0) {
                    dp[x][y + 1] = 1;
                    method(array, dp, x, y + 1, ocean);
                } else if (dp[x][y + 1] == 2) {
                    dp[x][y + 1] = 3;
                    method(array, dp, x, y + 1, ocean);
                }
            } else {
                if (dp[x][y + 1] == 1) {
                    dp[x][y + 1] = 3;
                    method(array, dp, x, y + 1, ocean);
                } else if (dp[x][y + 1] == 0) {
                    dp[x][y + 1] = 2;
                    method(array, dp, x, y + 1, ocean);
                }
            }
        }
    }
}
