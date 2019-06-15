package XiaoMiOJ.solution40_49;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: XiaomiOJ
 * @description: 找数字对
 * @author: Ya
 * @create: 2019-06-15 13:56
 **/
public class Main48 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == 10) {
                    res++;
                } else if (Math.abs(array[i] - array[j]) == 10) {
                    res++;
                }
            }
        }
        return res;
    }
}
