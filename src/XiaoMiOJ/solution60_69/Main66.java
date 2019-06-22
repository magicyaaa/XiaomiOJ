package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 节约用电
 * @author: Ya
 * @create: 2019-06-19 17:29
 **/
public class Main66 {
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
            if (chars[i] == '1') {
                //转换
                revers(chars, i + 1);
                res++;
            }
        }
        /*for (int i = chars.length / 2; i < chars.length; i++) {
            if (chars[i] == '1') {
                return -1;
            }
        }*/
        return res;
    }

    private static void revers(char[] array, int index) {
        for (int i = index; i <= array.length; i += index) {
            if (array[i - 1] == '1') {
                array[i - 1] = '0';
            } else {
                array[i - 1] = '1';
            }
        }
    }
}
