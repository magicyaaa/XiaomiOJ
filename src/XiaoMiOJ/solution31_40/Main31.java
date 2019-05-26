package XiaoMiOJ.solution31_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 有多少个公差为 2 的等差数列
 * @author: Ya
 * @create: 2019-05-25 23:58
 **/
public class Main31 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method2(line));
        }
    }

    /**
     * 效率最高的一种方式
     * 没看懂怎么算的
     * <p>
     * 看懂了—。—
     * 前n项和公式 a1*n + n*(n-1)*d / 2 = Sn   d = 2
     * --> a1 = Sn /n + 1-n
     */
    public static int method2(String line) {
        int x = Integer.valueOf(line);
        double s = Math.sqrt(x);
        int count = 0;
        for (int i = 1; i <= s; i++) {
            if (x % i == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 利用等差数列前n项和公式
     * Sn = a1 * n + n(n-1)/2*d
     */
    //todo 运行时间打败了 0% 的 Java 8 玩家！
    private static int method(String line) {
        int num = Integer.parseInt(line);
        int a1 = 1;
        double n = 0;
        int count = 0;
        double delta;
        for (; a1 <= num; a1++) {
            delta = delta(a1, num);
            if (delta >= 0) {
                n = (1 - a1 + delta) / 2;
                if (n > 0 && (int) n == n) {
                    count++;
                }
            }
        }
        return count;
    }

    private static double delta(int a, int S) {
        double temp = Math.pow(a - 1, 2) + 4 * S;
        if (temp < 0) {
            return -1L;
        }
        temp = Math.sqrt(temp);
        if ((int) temp == temp) {
            return temp;
        } else {
            return -1L;
        }
    }
}
