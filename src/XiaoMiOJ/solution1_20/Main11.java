package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 构建短字符串
 * @author: Ya
 * @create: 2019-05-06 23:06
 **/
public class Main11 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 不使用hashSet  使用数组记录26个字母出现的次数 数组下标0～25对应字母a~z
     */
    private static String method(String line) {
        String[] ss = line.split(" ");
        String s1 = ss[0];
        String s2 = ss[1];
        int[] num = new int[26]; //记录26个英文字母出现的个数
        for (int i = 0; i < s2.length(); i++) {
            num[s2.charAt(i) - 'a']++;
        }
        int index;
        for (int i = 0; i < s1.length(); i++) {
            index = s1.charAt(i) - 'a';
            if (num[index] > 0) {
                num[index]--;
            } else {
                return "false";
            }
        }
        return "true";
    }
}
