package XiaoMiOJ.solution31_40;


import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 判断是否为连乘数字串
 * @author: Ya
 * @create: 2019-05-26 18:25
 **/
public class Main32 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(print(line));
        }
    }

    private static String print(String line) {
        if (method(line)) {
            return "true";
        } else {
            return "false";
        }
    }

    private static boolean method(String line) {
        if (line.length() < 3) {
            return false;
        }
        for (int i = 1; i < line.length(); i++) {
            for (int j = i + 1; j < line.length(); j++) {
                int num1 = Integer.parseInt(line.substring(0, i));
                int num2 = Integer.parseInt(line.substring(i, j));
                int num3 = num1 * num2;
                String s = String.valueOf(num3);

                if (j + s.length() <= line.length()) {  // 长度符合
                    if (line.substring(j, j + s.length()).equals(s)) {//匹配
                        if (j + s.length() == line.length()) {  //刚好匹配完
                            return true;
                        } else {  //还有剩余, 递归匹配
                            if (method(line, i, j, j + s.length())) {
                                return true;
                            } else {
                                continue;
                            }
                        }
                    } else { //不匹配
                        continue;
                    }
                } else { //结果超长
                    break;
                }
            }
        }
        return false;
    }

    private static boolean method(String line, int index1, int index2, int index3) {
        int num1 = Integer.parseInt(line.substring(index1, index2));
        int num2 = Integer.parseInt(line.substring(index2, index3));
        int num3 = num1 * num2;
        String s = String.valueOf(num3);

        if (index3 + s.length() <= line.length()) {  // 长度符合
            if (line.substring(index3, index3 + s.length()).equals(s)) {//匹配
                if (index3 + s.length() == line.length()) {  //刚好匹配完
                    return true;
                } else {  //还有剩余, 递归匹配
                    return method(line, index2, index3, index3 + s.length());
                }
            } else { //不匹配
                return false;
            }
        } else { //结果超长
            return false;
        }
    }
}
