package XiaoMiOJ.solution21_40;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 按序组合成最大的数
 * @author: Ya
 * @create: 2019-05-17 23:25
 **/
public class Main22 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 878888766557 3
     * 436346234214 2
     *
     * 思路：1 12 123 ...  123456789 ... 12345678987
     *  以上数字个数为等差数列 利用前n项和 n(n+1)/2  定位到要求的第k个数字 属于哪一项
     *  然后找出具体的那一项 ，根据规律，求具体的值
     */
    private static int method(String line) {
        long num = Long.parseLong(line);

        long sum = 0;
        long i = 1;
        while (sum + i < num) { //累加
            sum += i;
            i++;
        }
        i = num - sum;
        int res = 1;
        boolean order = false;
        if (i > 16) {
            i = i % 16;
        }
        if (i == 0) {
            i = 16;
        }
        while (i > 1) {
            if (res == 9) {
                order = true;
            } else if (res == 1) {
                order = false;
            }

            if (!order) {
                res++;
            } else {
                res--;
            }
            i--;
        }
        return res;
    }
}
