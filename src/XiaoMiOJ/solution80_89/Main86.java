package XiaoMiOJ.solution80_89;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 优秀数字
 * @author: Ya
 * @create: 2019-06-28 15:30
 **/
public class Main86 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static String method(String line) {
        long M = Long.parseLong(line);
        if (M == 0) {
            return "Bad";
        }
        if(M == 2){
            return "Good";
        }
        if ((M & 1) == 0) { //偶数
            return "Normal";
        }

        long res = 2;
        boolean tag1 = false, tag2 = false;
        while (res - 1 <= M) {
            if (res + 1 == M) {
                tag1 = true;
            }
            if (res - 1 == M) {
                tag2 = true;
            }
            res <<= 1;
        }

        if (tag1 && tag2) {
            return "Very Good";
        } else if (tag1) {
            return "Good";
        } else if (tag2) {
            return "Bad";
        } else {
            return "Normal";
        }
    }
}
