package XiaoMiOJ.solution21_40;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 按序组合成最大的数
 * @author: Ya
 * @create: 2019-05-17 23:25
 **/

/**
 * 出错了！！！！
 */
public class Main21 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 用例输入: "5,9,7,5,3,9,0,5,5,6,3,2,6,8 9,1,4,8 6"
     * 期望输出: "999868"
     * 你的输出: "999848"
     * <p>
     * 用例输入: "3,6,0,4,0,9,2,4,9,2,9,1,0 9,3,0,0,3,0,1,9,8,6,9,0,1,6,4,4,8,6 23"
     * 期望输出: "99993100301986901644860"
     * 你的输出: "99993100030198690164486"
     */
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
        return method2(a1, a2, 0, 0, k);
    }

    /**
     * 保持最后有足够的个数同时选择最大的一个
     */
    private static String method2(int[] a1, int[] a2, int index1, int index2, int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            int count1 = a1.length - index1;
            int count2 = a2.length - index2;
            //当前可选择的范围 (不包括当前下标)
            int end1 = (k - count2 <= 0) ? a1.length : a1.length - (k - count2) + 1;
            int end2 = (k - count1 <= 0) ? a2.length : a2.length - (k - count1) + 1;

            //查找可选择范围内 最大值 和下标
            int max1 = -1, i1 = -1;
            for (int i = index1; i < end1; i++) {
                if (a1[i] > max1) {
                    max1 = a1[i];
                    i1 = i;
                }
            }
            int max2 = -1, i2 = -1;
            for (int i = index2; i < end2; i++) {
                if (a2[i] > max2) {
                    max2 = a2[i];
                    i2 = i;
                }
            }
            if (max1 > max2) {
                sb.append(max1);
                index1 = i1 + 1;
                k--;
            } else if (max1 < max2) {
                sb.append(max2);
                index2 = i2 + 1;
                k--;
            } else {
                sb.append(max1);
                k--;
                if (i1 == index1) {
                    index1 = i1 + 1;
                } else if (i2 == index2) {
                    index2 = i2 + 1;
                } else {
                    String s1 = method2(a1, a2, i1 + 1, index2, k);
                    String s2 = method2(a1, a2, index1, i2 + 1, k);
                    if (compareString(s1, s2)) {
                        return sb.append(s1).toString();
                    } else {
                        return sb.append(s2).toString();
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 比较字符串
     */
    private static boolean compareString(String s1, String s2) {
        int len = Integer.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return false;
            }
        }
        return s1.length() >= s2.length();
    }
}
