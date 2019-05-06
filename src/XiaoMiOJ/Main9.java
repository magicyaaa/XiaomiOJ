package XiaoMiOJ;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 移除 K 位得到最小值
 * @author: Ya
 * @create: 2019-05-06 18:28
 **/
public class Main9 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 转换思路：
     * 去掉k位 -> 即保留 n-k 位
     * */
    private static String method(String line) {
        String[] ss = line.split(" ");
        char[] array = new char[ss[0].length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ss[0].charAt(i);
        }
        int k = Integer.parseInt(ss[1]); //移除k个
        if (k == 0) {
            return ss[0];
        }
        k = array.length - k;  //修改为保留k个
        int start = 0;
        int pre = 0;
        int len = array.length;
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            pre = findMin(array, start, len - k);
            if (array[pre] != '0' || sb.length() != 0) {
                sb.append(array[pre]);
            }
            start = pre + 1;
            k--;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * 查找区间内最小值的坐标
     */
    private static int findMin(char[] array, int start, int end) {
        int minIndex = start;
        while (start <= end) {
            if (array[start] < array[minIndex]) {
                minIndex = start;
            }
            start++;
        }
        return minIndex;
    }

}
