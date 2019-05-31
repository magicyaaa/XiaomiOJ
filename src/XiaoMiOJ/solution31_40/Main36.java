package XiaoMiOJ.solution31_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 选水果
 * @author: Ya
 * @create: 2019-05-28 22:17
 **/
public class Main36 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        int k = Integer.parseInt(line);
        int num; //原始总数量
        int m = k + 1;  // m初始最小值
        int index;
        while (true) {
            num = 2 * k;
            index = (m - 1) % num;
            num--;
            while (index >= k) {
                if (num == k) {
                    return m;
                }
                index = index - 1 + m;
                index %= num;
                num--;
            }
            m++;
        }
    }
}
