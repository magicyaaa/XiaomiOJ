package XiaoMiOJ.solution21_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 找到第 N 个数字 II
 * @author: Ya
 * @create: 2019-05-19 23:59
 **/
public class Main23 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static char method(String line) {
        long num = Long.parseLong(line);
        long tag = 0;
        long sum = 0;
        long pre = 0;
        while (sum < num) { //前n项和  (a1+an)n/2
            tag++;
            pre = sum;
            sum += (Math.pow(10, tag) - Math.pow(10, tag - 1)) * tag;
        }
        long r = num - pre;
        long a1 = (r - 1) / tag;
        long a2 = (r - 1) % tag;

        long a = (long) Math.pow(10, tag - 1) + a1;
        String s = String.valueOf(a);
        return s.charAt((int)a2);
    }
}
