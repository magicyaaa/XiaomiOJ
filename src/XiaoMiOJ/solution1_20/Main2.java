package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 找出单独出现的数字
 * @author: Ya
 * @create: 2019-04-29 17:14
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] ss = line.split(" ");
            // System.out.println("answer");
            int num = 0;
            for (String s : ss) {
                num ^= Integer.parseInt(s);
            }
            System.out.println(num);
        }
    }

}
