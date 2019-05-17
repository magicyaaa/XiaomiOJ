package XiaoMiOJ.solution1_20;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 在一个有序的经过旋转的数组里查找一个数
 * @author: Ya
 * @create: 2019-05-08 23:29
 **/
public class Main14 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 旋转n次和旋转一次没啥区别
     * 直接遍历也可以找到答案
     * 二分法查找效率更搞
     */
    private static int method(String line) {
        String[] ss = line.split(" ");
        String[] s1 = ss[0].split(",");
        int[] array = new int[s1.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }
        int target = Integer.parseInt(ss[1]);

        //旋转数组二分法查找
        return binarySearch(array, 0, array.length - 1, target);
    }

    /**
     * 旋转数组二分法查找
     */
    private static int binarySearch(int[] array, int start, int end, int target) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[start] > array[end]) { //有旋转 注意旋转点
            if (array[mid] > array[end]) {
                if (target >= array[start] && target < array[mid]) { //在左边
                    return binarySearch(array, start, mid - 1, target);
                } else { //在右边
                    return binarySearch(array, mid + 1, end, target);
                }
            } else {
                if (target > array[mid] && target <= array[end]) { //在右边
                    return binarySearch(array, mid + 1, end, target);
                } else { //在左边
                    return binarySearch(array, start, mid - 1, target);
                }
            }

        } else { //没有旋转 直接二分
            if (target > array[mid]) { //右边
                return binarySearch(array, mid + 1, end, target);
            } else { //左边
                return binarySearch(array, start, mid - 1, target);
            }
        }
    }
}
