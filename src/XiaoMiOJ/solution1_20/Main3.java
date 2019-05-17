package XiaoMiOJ.solution1_20;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 大数相减
 * @author: Ya
 * @create: 2019-04-29 17:13
 **/
public class Main3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(method(line));
        }
    }

    public static String method(String line) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int i = 0;
        while (line.charAt(i) != '-') {
            s1.push(line.charAt(i));
            i++;
        }
        i++;
        while (i < line.length()) {
            s2.push(line.charAt(i));
            i++;
        }

        StringBuilder sb = new StringBuilder();
        boolean tag = false;
        char c1;
        char c2;
        int num;
        while (!s1.empty() && !s2.empty()) {
            if (!tag) {
                num = s1.pop() - s2.pop();
            } else {
                num = s1.pop() - s2.pop() - 1;
            }

            if (num >= 0) {
                sb.append(num);
                tag = false;
            } else {
                sb.append(num + 10);
                tag = true;
            }
        }

        num = 0;
        while (!s1.empty()) {
            if (tag) {
                num = s1.pop() - '1';
            } else {
                num = s1.pop() - '0';
            }
            if (num >= 0) {
                sb.append(num);
                tag = false;
            } else {
                sb.append(num + 10);
                tag = true;
            }
        }
        //去0
        int j = sb.length() - 1;
        for (; j >= 0; j--) {
            if (sb.charAt(j) == '0') {
                sb.deleteCharAt(j);
            } else {
                break;
            }
        }
        return sb.reverse().toString();
    }
}
