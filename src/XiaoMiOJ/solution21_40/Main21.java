package XiaoMiOJ.solution21_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 按序组合成最大的数
 * @author: Ya
 * @create: 2019-05-17 23:25
 **/
public class Main21 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static String method(String line) {
        String[] ss = line.split(" ");
        String[] ss1 = ss[0].split(",");
        String[] ss2 = ss[1].split(",");
        int k = Integer.parseInt(ss[2]);  //记录需要找几个
        int[] a1 = new int[ss1.length];
        int[] a2 = new int[ss2.length];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = Integer.parseInt(ss1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = Integer.parseInt(ss2[i]);
        }

        StringBuilder sb = new StringBuilder();
        method(sb, a1, a2, -1, -1, k);
        return sb.toString();
    }

    private static void method(StringBuilder sb, int[] a1, int[] a2, int index1, int index2, int k) {
        if (k == 0) {
            return;
        }
        //先确定能查找的范围
        int end1;
        int end2;
        end1 = a1.length - (k - (a2.length - 1 - index2));
        end1 = end1 > a1.length - 1 ? a1.length - 1 : end1;

        end2 = a2.length - (k - (a1.length - 1 - index1));
        end2 = end2 > a2.length - 1 ? a2.length - 1 : end2;

        int max1 = Integer.MIN_VALUE;
        int i1 = -1;
        int max2 = Integer.MIN_VALUE;
        int i2 = -1;

        for (int i = index1 + 1; i <= end1; i++) {
            if (a1[i] > max1) {
                max1 = a1[i];
                i1 = i;
            }
        }
        for (int i = index2 + 1; i <= end2; i++) {
            if (a2[i] > max2) {
                max2 = a2[i];
                i2 = i;
            }
        }

        if (max1 >= max2) {
            sb.append(max1);
            method(sb, a1, a2, i1, index2, k - 1);
        } else {
            sb.append(max2);
            method(sb, a1, a2, index1, i2, k - 1);
        }
    }
}
