package XiaoMiOJ.solution50_59;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 找出面积最大的矩形
 * @author: Ya
 * @create: 2019-06-15 14:37
 **/
public class Main50 {
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

        int max = 0;
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                temp = min(array, i, j) * (j - i + 1);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    private static int min(int[] array, int i, int j) {
        int min = array[i];
        i++;
        while (i <= j) {
            if (array[i] < min) {
                min = array[i];
            }
            i++;
        }
        return min;
    }
}
