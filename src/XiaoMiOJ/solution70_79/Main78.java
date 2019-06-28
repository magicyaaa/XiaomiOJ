package XiaoMiOJ.solution70_79;

import util.ArrayUtil;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 字符串拼颜值
 * @author: Ya
 * @create: 2019-06-22 17:07
 **/
public class Main78 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        char[] chars = line.toCharArray();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                int count = 1;
                int j = i + 1;
                while (j < chars.length && chars[j] == '?') {
                    count++;
                    j++;
                }
                if (i != 0 && j != chars.length) {
                    if (chars[i - 1] == chars[j]) {
                        if ((count & 1) == 1) { //奇数

                        } else { //偶数
                            res++;
                        }
                    } else {
                        if ((count & 1) == 1) { //奇数
                            res++;
                        } else { //偶数

                        }
                    }
                }
                i = j;
            } else {
                if (i > 0 && chars[i] == chars[i - 1]) {
                    res++;
                }
            }
        }
        return res;
    }
}
