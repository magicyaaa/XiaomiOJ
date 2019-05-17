package XiaoMiOJ.solution1_20;

import util.StringUtil;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @program: XiaomiOJ
 * @description: 四则运算
 * @author: Ya
 * @create: 2019-05-09 21:44
 **/
public class Main16 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(compute(line));
        }
    }

    private static String compute(String line) {
        String[] ss = line.split(" ");
        LinkedList<Integer> listNum = new LinkedList<>(); //记录数字
        LinkedList<Character> listSign = new LinkedList<>(); //记录符号
        for (String s : ss) {
            if (isInteger(s)) {
                listNum.add(Integer.parseInt(s));
            } else {
                listSign.add(s.charAt(0));
            }
        }

        int preNum;
        int nextNum;
        char preSign;
        char nextSign;
        while (listSign.size() > 0) {
            preSign = listSign.get(0);

            if (listSign.size() > 1) {
                nextSign = listSign.get(1);
                if (listSign.size() > 1
                        && (preSign == '+' || preSign == '-')
                        && (nextSign == '*' || nextSign == '/')) { //说明后面还还有符号 需要判断优先级

                    preNum = listNum.get(1);
                    nextNum = listNum.get(2);
                    int sum = 0;
                    switch (nextSign) {
                        case '*':
                            sum = preNum * nextNum;
                            break;
                        case '/':
                            if (nextNum == 0) {
                                return "err";
                            }
                            sum = preNum / nextNum;
                            break;
                        default:
                    }
                    listNum.set(1, sum);
                    listNum.remove(2);
                    listSign.remove(1);
                    continue;
                }
            }
            //后面没有符号了，或者优先直接计算
            int sum = 0;
            preNum = listNum.get(0);
            nextNum = listNum.get(1);
            switch (preSign) {
                case '+':
                    sum = preNum + nextNum;
                    break;
                case '-':
                    sum = preNum - nextNum;
                    break;
                case '*':
                    sum = preNum * nextNum;
                    break;
                case '/':
                    if (nextNum == 0) {
                        return "err";
                    }
                    sum = preNum / nextNum;
                    break;
            }
            listNum.set(0, sum);
            listNum.remove(1);
            listSign.remove(0);
        }
        return listNum.peekFirst().toString();
    }


    public static boolean isInteger(String str) {
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return true;
        }
        return false;
    }
}
