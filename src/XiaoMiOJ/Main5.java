package XiaoMiOJ;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 出旋转有序数列的中间值
 * @author: Ya
 * @create: 2019-05-01 23:32
 **/
public class Main5 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    public static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int len = array.length;
        if (len == 1) {
            return array[0];
        }
        int min = 0;
        for (int i = 1; i < len; i++) {
            if (array[i] < array[i - 1]) {
                min = i;
            }
        }
        int mid = len / 2;
        return array[(mid + min) % len];
    }
}
