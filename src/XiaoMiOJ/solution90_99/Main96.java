package XiaoMiOJ.solution90_99;

import com.sun.net.httpserver.Authenticator;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 第N个丑数  运行超时
 * @author: Ya
 * @create: 2019-06-29 00:14
 **/
public class Main96 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        int num = Integer.parseInt(line);
        if (num == 1) {
            return 1;
        }
        int count = 1;
        int i = 2;
        while (count < num) {
            if (isUgly(i)) {
                count++;
            }
            i++;
        }
        return i - 1;
    }

    private static boolean isUgly(int num) {
        while (num != 1) {
            if ((num & 1) == 0) {
                num /= 2;
            } else if (is3(num)) {
                num /= 3;
            } else if (is5(num)) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    //能否被3整除
    private static boolean is3(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean is5(int num) {
        int n = num % 10;
        if (n == 5 || n == 0) {
            return true;
        } else {
            return false;
        }
    }
}
