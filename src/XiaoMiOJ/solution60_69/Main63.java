package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 数7游戏
 * @author: Ya
 * @create: 2019-06-18 17:33
 **/
public class Main63 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(test(Integer.parseInt(line)));
        }
    }

    private static int test(int count) {
        for (int i = 1; i <= count; i++) {
            if (i % 7 == 0) {
                count++;
                continue;
            }
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 7) {
                    count++;
                    break;
                } else {
                    temp /= 10;
                }
            }
        }
        return count;
    }
}
