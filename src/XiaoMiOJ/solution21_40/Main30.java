package XiaoMiOJ.solution21_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 反向位整数
 * @author: Ya
 * @create: 2019-05-24 00:52
 **/
public class Main30 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 思路：
     * 利用位运算
     * 每次判断 num 最后一位是0还是1，然后给res最后一位加上0或1
     * num右移一位，res左移一位
     * 继续判断32次。
     *
     * 注意： 要用long类型接收，因为int类型带符号32位,长度短一位,long类型64位
     * */
    private static long method(String line) {
        long num = Long.parseLong(line);
        long res = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                res <<= 1;
                res++;
            } else {
                res <<= 1;
            }
            num >>= 1;
        }
        return res;
    }
}
