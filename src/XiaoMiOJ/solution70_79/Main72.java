package XiaoMiOJ.solution70_79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 简单直接全排列
 * @author: Ya
 * @create: 2019-06-21 17:19
 **/
public class Main72 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));

        }
    }

    private static String method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(array);
        List<int[]> list = new ArrayList<>();
        fullSort(list, array, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int num : list.get(i)) {
                sb.append(num + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    /**
     * 递归实现 全排列
     */
    private static void fullSort(List<int[]> list, int[] array, int index) {
        if (index == array.length - 1) {
            list.add(array);
            return;
        }
        for (int i = index; i < array.length; i++) {
            fullSort(list, swap2(array, index, i), index + 1);
        }
    }

    /**
     * 交换 (无法保证全排列的是升序)
     * 应该使用swap2
     */
    private static int[] swap(int[] array, int i, int j) {
        int[] res = array.clone();
        if (i == j) {
            return res;
        }
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
        return res;
    }

    /**
     * 保证 余下部分是递增的排序
     */
    private static int[] swap2(int[] array, int i, int j) {
        int[] res = array.clone();
        if (i == j) {
            return res;
        }
        int temp = res[j];
        //其余往后偏移一个位置
        for (int index = j; index > i; index--) {
            res[index] = res[index - 1];
        }
        res[i] = temp;
        return res;
    }
}

