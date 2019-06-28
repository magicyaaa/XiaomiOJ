package XiaoMiOJ.solution70_79;

import util.ArrayUtil;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 知了的鸣叫
 * @author: Ya
 * @create: 2019-06-24 18:05
 **/
public class Main79 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method2(line) ? 1 : 0);
        }
    }


    /**
     * 模拟方法效率太低了
     * 应该直接从数值上计算
     */
    private static boolean method2(String line) {
        String[] ss = line.split(",");
        int N = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[1]);
        int m = Integer.parseInt(ss[2]);
        int[] tag = new int[N];
        tag[0] = 1;
        if (k > 0) {
            k--;
        } else {
            return tag[m - 1] > 0;
        }

        while (k > 0) {
            tag = method_dp(tag);
            ArrayUtil.printArray(tag);
            k--;
        }
        return tag[m - 1] > 0;
    }

    private static int[] method_dp(int[] tag) {
        int[] new_tag = tag.clone();
        for (int i = 0; i < tag.length; i++) {
            if (tag[i] > 0) {  //大于0  叫的时间长度
                //吵醒相邻的知了
                method_awake(tag, new_tag, i);
                //如果叫了8秒 --> 休息8秒
                if (tag[i] == 8) {
                    new_tag[i] = -8;
                } else {
                    new_tag[i] = tag[i] + 1;
                }
            } else if (tag[i] == -1) { //休息完了  继续叫
                new_tag[i] = 1;
            } else if (tag[i] < 0) { //小于0  处于休息恢复中
                new_tag[i] = tag[i] + 1;
            }
        }
        return new_tag;
    }

    private static void method_awake(int[] tag, int[] new_tag, int i) {
        if (i > 0 && tag[i - 1] == 0) { //唤醒左边
            new_tag[i - 1] = 1;
        }
        if (i < tag.length - 1 && tag[i + 1] == 0) { //唤醒右边
            new_tag[i + 1] = 1;
        }
    }
}
