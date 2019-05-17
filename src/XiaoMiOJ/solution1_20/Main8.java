package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 最少交换次数
 * @author: Ya
 * @create: 2019-05-05 23:05
 **/
public class Main8 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 冒泡排序方法 统计次数
     */
    private static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        int count = 0;
        boolean tag; //记录有没有交换
        for (int i = 0; i < array.length - 1; i++) {
            tag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] ^= array[j + 1];
                    array[j + 1] ^= array[j];
                    array[j] ^= array[j + 1];
                    count++;
                    tag = true;
                }
            }
            if (!tag) {
                break;
            }
        }
        return count;
    }
}
