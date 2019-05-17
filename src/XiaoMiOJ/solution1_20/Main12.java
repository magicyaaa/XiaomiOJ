package XiaoMiOJ.solution1_20;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 找出可能的合的组合
 * @author: Ya
 * @create: 2019-05-06 23:32
 **/
public class Main12 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 递归方式
     */
    private static int method(String line) {
        String[] ss = line.split(" ");
        String[] s1 = ss[0].split(",");
        int[] array = new int[s1.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(array);//先进行一次排序 保证递增
        int target = Integer.parseInt(ss[1]);
        return method(array, target, 0, 0);
    }

    /**
     * 递归函数
     * array每取一个数num，sum = sum + num,(sum初始为0) 都从头开始for循环依次判断, ，
     * 若sum > target 退出循环
     * 若sum == target ，找到合适的值, +1
     * 若sum < target, 进行下一轮递归
     */
    private static int method(int[] array, int target, int count, int sum) {
        for (int i = 0; i < array.length && array[i] <= target; i++) {
            if (sum + array[i] > target) {
                break;
            } else if (sum + array[i] == target) {
                count++;
            } else if (sum + array[i] < target) {
                count = method(array, target, count, sum + array[i]);
            }
        }
        return count;
    }

}
