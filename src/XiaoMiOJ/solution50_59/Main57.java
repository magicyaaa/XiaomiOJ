package XiaoMiOJ.solution50_59;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 玩转字符串
 * @author: Ya
 * @create: 2019-06-16 16:13
 **/
public class Main57 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        String[] ss = line.split(" ");
        String line1 = ss[0];
        String line2 = ss[1];
        if (line1.length() > line2.length()) {
            return 0;
        }

        boolean order = true; // true顺序 false逆序
        int start = 0;
        int end = line2.length() - 1;
        int dif = line2.length() - line1.length(); //长度差

        while (dif > 0) {
            if (order) {
                if (line2.charAt(end) == 'A') {
                    end--;
                } else {
                    end--;
                    order = false;
                }
            } else {
                if (line2.charAt(start) == 'A') {
                    start++;
                } else {
                    start++;
                    order = true;
                }
            }
            dif--;
        }
        return isSame(line1, line2, start, end, order) ? 1 : 0;
    }

    /**
     * 判断是否一致
     */
    private static boolean isSame(String line1, String line2, int start, int end, boolean order) {
        if (line1.length() != end - start + 1) {
            return false;
        }
        if (order) {
            for (int i = 0; i < line1.length(); i++) {
                if (line1.charAt(i) != line2.charAt(start + i)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < line1.length(); i++) {
                if (line1.charAt(i) != line2.charAt(end - i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
