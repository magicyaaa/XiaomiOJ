package XiaoMiOJ;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: A+B
 * @author: Ya
 * @create: 2019-04-29 17:12
 **/
public class Main1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] array = line.split(" ");
            long sum = 0;
            for(String s : array){
                sum += Long.parseLong(s);
            }
            // System.out.println("answer"); 4294967294
            System.out.println(sum);
        }
    }
}
