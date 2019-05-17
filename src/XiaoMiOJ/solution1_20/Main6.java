package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 交叉队列
 * @author: Ya
 * @create: 2019-05-05 18:41
 **/
public class Main6 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(method(line));
        }
    }

    private static boolean method(String line) {
        String[] ss = line.split(",");
        char[] c1 = ss[0].toCharArray();
        char[] c2 = ss[1].toCharArray();
        char[] c = ss[2].toCharArray();

        if (c.length != c1.length + c2.length) {
            return false;
        }
        int index = 0, index1 = 0, index2 = 0;
        return method2(c, c1, c2, 0, 0, 0);
    }

    /**
     * 递归方式
     */
    private static boolean method2(char[] c, char[] c1, char[] c2, int index, int index1, int index2) {
        if (index1 >= c1.length) {
            while (index2 < c2.length) {
                if (c[index] != c2[index2]) {
                    return false;
                }
                index++;
                index2++;
            }
            return true;
        }
        if (index2 >= c2.length) {
            while (index1 < c1.length) {
                if (c[index] != c1[index1]) {
                    return false;
                }
                index++;
                index1++;
            }
            return true;
        }
        if (c[index] != c1[index1] && c[index] != c2[index2]) {
            return false;
        } else if (c[index] == c1[index1] && c[index] == c2[index2]) {
            return method2(c, c1, c2, index + 1, index1 + 1, index2)
                    || method2(c, c1, c2, index + 1, index1, index2 + 1);
        } else if (c[index] == c1[index1]) {
            return method2(c, c1, c2, index + 1, index1 + 1, index2);
        } else {
            return method2(c, c1, c2, index + 1, index1, index2 + 1);
        }
    }
}
