package XiaoMiOJ.solution70_79;

import util.ArrayUtil;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 发奖励
 * @author: Ya
 * @create: 2019-06-21 22:10
 **/
public class Main75 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 遍历两遍数组
     */
    private static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int[] res = new int[array.length];
        for (int i = 0; i < res.length - 1; i++) {
            if (i > 0 && array[i] > array[i - 1]) {
                res[i] = Math.max(res[i - 1] + 1, res[i]);
            }
            if (i < array.length - 1 && array[i] > array[i + 1]) {
                res[i] = Math.max(res[i + 1] + 1, res[i]);
            }
        }
        for (int i = res.length - 1; i >= 0; i--) {
            if (i > 0 && array[i] > array[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
            if (i < array.length - 1 && array[i] > array[i + 1]) {
                res[i] = Math.max(res[i + 1] + 1, res[i]);
            }
        }

        int resNum = 0;
        for (int i : res) {
            resNum += i;
        }
        return resNum + res.length;
    }
}
