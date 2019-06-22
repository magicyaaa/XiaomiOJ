package XiaoMiOJ.solution60_69;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 开始报数
 * @author: Ya
 * @create: 2019-06-19 20:31
 **/
public class Main67 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        int n = Integer.parseInt(line); //找第n个喊3的小孩
        boolean[] tag = new boolean[500]; //true 为淘汰
        int index = 0;
        int num = 1;
        int res = 0;
        while (true) {
            if (num == 3) {
                num = 0;
                tag[index] = true;
                res = index;
                n--;
                if(n == 0){
                    break;
                }
            }
            index += 1;
            if (index >= 500) {
                index %= 500;
            }
            while (tag[index]) {
                index += 1;
                if (index >= 500) {
                    index %= 500;
                }
            }
            num++;
        }
        return res + 1;
    }
}
