package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 有多少个等差数列？
 * @author: Ya
 * @create: 2019-05-13 22:55
 **/
public class Main20 {
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
        for (int i = 0; i < ss.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        if (array.length <= 1) {
            return 0;
        }
        //只有两个数才能等差
        int count = 0;
        int diff;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                count++;
                diff = array[j] - array[i];
                count += method2(array,j,j+1,diff);
            }
        }
        return count;
    }

    //递归找数列
    private static int method2(int[] array, int pre, int cur, int diff) {
        int count = 0;
        for (int i = cur; i < array.length; i++) {
            if (array[i] - array[pre] == diff) {
                count += 1 + method2(array, i, i + 1, diff);
            }
        }
        return count;
    }
}
