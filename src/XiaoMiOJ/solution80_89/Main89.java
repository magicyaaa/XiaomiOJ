package XiaoMiOJ.solution80_89;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: N!
 * @author: Ya
 * @create: 2019-06-28 16:36
 **/
public class Main89 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            //System.out.println(method(line));
            System.out.println(method2(line)); //这个方法更快
        }
    }

    /**
     * https://www.cnblogs.com/vipchenwei/p/7123064.html
     * 利用分解质因数
     * <p>
     * 运行超时！！！！
     */
    private static int method(String line) {
        int num = Integer.parseInt(line);
        int count = 0;
        int temp;
        for (int i = 1; i <= num; i++) {
            temp = i;
            while (temp % 5 == 0) {
                temp /= 5;
                count++;
            }
        }
        return count;
    }

    /**
     * 这个方法更快
     * https://blog.csdn.net/nka_kun/article/details/73008599
     */
    private static int method2(String line) {
        int num = Integer.parseInt(line);
        int sum = 0;
        for (int i = 5; i <= num; i *= 5) {
            sum += num / i;
        }
        return sum;
    }
}
