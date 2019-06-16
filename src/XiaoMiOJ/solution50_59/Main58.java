package XiaoMiOJ.solution50_59;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 数组重排
 * @author: Ya
 * @create: 2019-06-16 16:44
 **/
public class Main58 {
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

        int[] min = new int[array.length];
        int[] max = new int[array.length];
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < temp) {
                temp = array[i];
            }
            min[i] = temp;
        }
        temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
            max[i] = temp;
        }
        int left = array.length - 1;
        for (int i = 1; i < min.length; i++) {
            if (array[i - 1] > min[i]) {
                left = i - 1;
                break;
            }
        }
        if (left == array.length - 1) {
            return 0;
        }
        int right = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i + 1] < max[i]) {
                right = i + 1;
                break;
            }
        }
        return right - left + 1;
    }
}
