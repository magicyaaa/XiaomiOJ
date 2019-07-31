package XiaoMiOJ.solution90_99;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 买香蕉
 * @author: Ya
 * @create: 2019-06-29 01:52
 **/
public class Main98 {
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
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        Arrays.sort(array);
        int[] res = new int[array.length];
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i] * (array.length - i);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
