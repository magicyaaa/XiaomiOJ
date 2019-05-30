package XiaoMiOJ.solution31_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 分糖果
 * @author: Ya
 * @create: 2019-05-28 09:43
 **/
public class Main35 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 思路 ：
     * 为了避免重复的情况，要保持有序，即非递增分配
     *
     * 比如7个糖果 3个框
     * 分配顺序：
     * 7,0,0
     * 6,1,0
     * 5,2,1
     * 5,1,2 x
     * 4,3,0
     * 4,2,1
     * 4,1,2 x
     * 3,4,0 x
     * 3,3,1
     * 3,2,2 x
     * 3,1,3 x
     * 2,5,0
     * ...
     * 1,6,0 x
     */
    private static int method(String line) {
        String[] ss = line.split(",");
        int m = Integer.parseInt(ss[0]); //糖果数量
        int n = Integer.parseInt(ss[1]);  //篮子数量
        int res = 0;
        for (int i = m; i > 0; i--) {
            res += method(i, m - i, n, 2);
        }
        return res;
    }

    private static int method(int pre, int candy_remain, int n, int now) {
        if (candy_remain == 0) {
            return 1;
        }
        if (now == n) {
            if (candy_remain <= pre) {
                return 1;
            } else {
                return 0;
            }
        }
        if (now > n) {
            return 0;
        }
        int res = 0;
        for (int i = candy_remain; i > 0; i--) {
            if (i <= pre) {
                res += method(i, candy_remain - i, n, now + 1);
            }
        }
        return res;
    }
}
