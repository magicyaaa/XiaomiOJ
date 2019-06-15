package XiaoMiOJ.solution50_59;

import util.ArrayUtil;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 数数有几个岛
 * @author: Ya
 * @create: 2019-06-15 20:23
 **/
public class Main55 {
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
        String[] ss2 = ss[0].split(",");
        boolean[][] array = new boolean[ss.length][ss2.length];

        for (int i = 0; i < array.length; i++) {
            String[] string_temp = ss[i].split(",");
            boolean[] boolean_temp = new boolean[string_temp.length];
            for (int j = 0; j < boolean_temp.length; j++) {
                if (string_temp[j].equals("1")) {
                    boolean_temp[j] = true;
                } else {
                    boolean_temp[j] = false;
                }
            }
            array[i] = boolean_temp;
        }
        return method(array);
    }

    private static int method(boolean[][] array) {
        boolean[][] tag = new boolean[array.length][array[0].length];//记录是否占领
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] && !tag[i][j]) {  // 是岛屿 且 从未占领
                    method(array, tag, i, j); //占领标记
                    res++;
                }
            }
        }
        return res;
    }

    private static void method(boolean[][] array, boolean[][] tag, int i, int j) {
        tag[i][j] = true;
        //上
        if (i - 1 >= 0 && array[i-1][j] && !tag[i-1][j]) {
            method(array, tag, i - 1, j);
        }
        //下
        if (i + 1 < array.length && array[i+1][j] && !tag[i+1][j]) {
            method(array, tag, i + 1, j);
        }
        //左
        if (j - 1 >= 0 && array[i][j-1] && !tag[i][j-1]) {
            method(array, tag, i, j - 1);
        }
        //右
        if (j + 1 < array[0].length && array[i][j+1] && !tag[i][j+1]) {
            method(array, tag, i, j + 1);
        }
    }
}
