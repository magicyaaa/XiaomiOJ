package XiaoMiOJ.solution60_69;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: XiaomiOJ
 * @description: 括号配对
 * @author: Ya
 * @create: 2019-06-18 15:19
 **/
public class Main62 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 栈
     */
    private static int method(String line) {
        char[] chars = line.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return 0;
                }
            } else if (c == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return 0;
                }
            } else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        if (stack.empty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
