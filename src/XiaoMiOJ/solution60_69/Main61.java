package XiaoMiOJ.solution60_69;

import com.sun.source.tree.BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 找出矩阵中相同的行
 * @author: Ya
 * @create: 2019-06-17 21:30
 **/
public class Main61 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if (line.length() < 1) {
                break;
            }
            list.add(line.split(" "));
        }
        System.out.println(method(list));
    }

    /**
     * 1 0 0 1 0
     * 0 1 1 0 0
     * 1 0 0 1 0
     * 0 0 1 1 0
     * 0 1 0 0 0
     * <p>
     * 1 0 1 0 1
     * 1 0 1 0 0
     * 1 0 0 0 1
     * 1 0 0 1 0
     * 1 0 1 0 1
     */
    private static String method(List<String[]> list) {
        //整理成二维数组
        int[][] array = new int[list.size()][list.get(0).length];
        for (int i = 0; i < array.length; i++) {
            int[] temp = new int[list.get(i).length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(list.get(i)[j]);
            }
            array[i] = temp;
        }

        List<List<Integer>> total = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            temp.add(i);
        }
        total.add(temp);

        for (int cloumn = 0; cloumn < array[0].length; cloumn++) {
            List<List<Integer>> newTotal = new ArrayList<>();
            for (List<Integer> listRow : total) {
                List<Integer> zero = new ArrayList<>();
                List<Integer> one = new ArrayList<>();
                for (int row : listRow) { //第 row 行
                    if (array[row][cloumn] == 0) {
                        zero.add(row);
                    } else {
                        one.add(row);
                    }
                }
                if (zero.size() > 1) {
                    newTotal.add(zero);
                }
                if (one.size() > 1) {
                    newTotal.add(one);
                }
            }
            total = newTotal;
            if (total.size() == 1 && total.get(0).size() == 2) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : total.get(0)) {
            sb.append((i + 1) + " ");
        }
        return sb.toString().trim();
    }
}