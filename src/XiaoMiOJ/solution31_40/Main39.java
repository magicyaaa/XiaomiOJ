package XiaoMiOJ.solution31_40;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 寻找最大主对角线的和
 * @author: Ya
 * @create: 2019-06-01 00:06
 **/
public class Main39 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            /*if (line == null || line.length() < 1) {  //不行需要这一段，OJ里自己会退出输入
                break;
            }*/
            list.add(line);
        }

        int[][] array = new int[list.size()][list.get(0).split(" ").length];
        for (int i = 0; i < array.length; i++) {
            String[] ss = list.get(i).split(" ");
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.parseInt(ss[j]);
            }
        }
        System.out.println(method(array));

    }

    private static int method(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = j = 0; j < array[0].length - 1; j++) {
                if (array[i][j] + array[i + 1][j + 1] > max) {
                    max = array[i][j] + array[i + 1][j + 1];
                }
            }
        }
        return max;
    }
}
