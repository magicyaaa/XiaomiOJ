package XiaoMiOJ.solution40_49;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 硬币排序
 * @author: Ya
 * @create: 2019-06-02 12:26
 **/
public class Main41 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(String.valueOf(method(line)));
        }
    }

    /**
     * 要求时间复杂度O(n) 空间O(1)
     * cba -> abc
     * aaaabc
     */
    private static char[] method(String line) {
        char[] chars = line.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (chars[end] == 'c') {
            if (end == 0) {
                return chars;
            }
            end--;
        }
        for (int i = 0; i < chars.length && i <= end; i++) {
            if (chars[i] == 'a') {
                if (start < i) {
                    //交换chars[start] 与 chars[i]
                    chars[start] ^= chars[i];
                    chars[i] ^= chars[start];
                    chars[start] ^= chars[i];
                }
                start++;
                continue;
            } else if (chars[i] == 'b') {

            } else {
                while (chars[end] == 'c') {
                    if (end <= i) {
                        return chars;
                    }
                    end--;
                }
                //交换chars[i]:c 与 chars[end]:a/b
                chars[i] ^= chars[end];
                chars[end] ^= chars[i];
                chars[i] ^= chars[end];
                i--;
                end--;
            }
        }
        return chars;
    }
}
