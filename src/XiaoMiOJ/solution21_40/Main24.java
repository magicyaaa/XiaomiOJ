package XiaoMiOJ.solution21_40;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 海盗分赃
 * @author: Ya
 * @create: 2019-05-22 21:47
 *
 * 思路：
 * 能够平均分脏，一人一半，首先总数是偶数，其次判断能否在这些数中凑齐 总数的 1／2
 **/
public class Main24 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static boolean method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
            sum += array[i];
        }
        if ((sum & 1) == 1) {
            return false;
        } else {
            sum = sum / 2;
        }
        Arrays.sort(array);
        return method(array, 0, 0, sum);
    }

    private static boolean method(int[] a, int cur, int sum, int target) {
        if (cur >= a.length) {
            return false;
        }
        if (sum + a[cur] == target) {
            return true;
        }
        if (sum + a[cur] < target) {
            if (method(a, cur + 1, sum + a[cur], target)) {
                return true;
            } else {
                return method(a, cur + 1, sum, target);
            }
        } else {
            return method(a, cur + 1, sum, target);
        }
    }
}
