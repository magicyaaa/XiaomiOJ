package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 上上下下的字符串
 * @author: Ya
 * @create: 2019-06-17 19:28
 **/
public class Main60 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * num从1开始
     * 先寻找第一个'+'，第一个'+'为1，然后往前推'-' ,num相应递增
     * 然后再寻找第二个'+' 往前推'-'
     */
    private static String method(String line) {
        line += '+';
        int len = line.length();
        int[] res = new int[len];
        int start = -1;
        for (int num = 1; num <= res.length; num++) {
            for (int j = start + 1; j < len; j++) {
                if (line.charAt(j) == '+') {  //寻找第一个 +
                    res[j] = num;
                    //往前推 符号就+1
                    int temp = j - 1;
                    while (temp > start) {
                        res[temp] = ++num;
                        temp--;
                    }
                    start = j;
                    break;
                } else if (j == len - 1 && line.charAt(j) == '-') {
                    res[j + 1] = num;
                    //往前推 符号就+1
                    int temp = j;
                    while (temp > start) {
                        res[temp] = ++num;
                        temp--;
                    }
                    start = j;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num);
        }
        return sb.toString().trim();
    }
}
