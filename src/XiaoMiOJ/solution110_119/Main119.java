package XiaoMiOJ.solution110_119;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 小米兔跳格子
 * @author: Ya
 * @create: 2019-07-19 00:07
 **/
public class Main119 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static boolean method(String line) {
        String[] ss = line.split(" ");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < i) {
                return false;
            } else {
                max = Math.max(i + array[i], max);
            }
        }
        return true;
    }
}
