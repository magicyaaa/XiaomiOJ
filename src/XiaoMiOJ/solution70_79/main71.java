package XiaoMiOJ.solution70_79;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 还是字符串
 * @author: Ya
 * @create: 2019-06-21 13:01
 **/
public class main71 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method_dp(line));
        }
    }

    private static int method_dp(String line) {
        int target = Integer.parseInt(line);
        if (target < 3) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        int res = 1;
        //从第3个开始
        int last = 2;
        for (int index = 2; index < target; index++) {
            if (list.get(index) == 1) {
                res++;
                if (last == 1) {
                    list.add(2);
                    last = 2;
                } else {
                    list.add(1);
                    last = 1;
                }

            } else {
                if (last == 1) {
                    list.add(2);
                    list.add(2);
                    last = 2;
                } else {
                    list.add(1);
                    list.add(1);
                    last = 1;
                }
            }
        }
        return res;
    }
}
