package XiaoMiOJ;

import java.lang.reflect.Array;

import util.ArrayUtil;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 和为零的三元组
 * @author: Ya
 * @create: 2019-05-09 19:53
 **/
public class Main15 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }

        ArrayList<Integer> listPositive = new ArrayList<>();
        ArrayList<Integer> listNegative = new ArrayList<>();
        int zeroNum = 0;
        for (int i : array) {
            if (i == 0) {
                zeroNum++;
            } else if (i < 0) {
                listNegative.add(i);
            } else {
                listPositive.add(i);
            }
        }

        int count = 0; //记录总数

        if (listNegative.size() != 0 && listPositive.size() != 0) { // 正数 或 负数的个数不能为0
            //转化为 int[]
            int[] arrayPositive = new int[listPositive.size()];
            for (int i = 0; i < arrayPositive.length; i++) {
                arrayPositive[i] = listPositive.get(i);
            }
            int[] arrayNegative = new int[listNegative.size()];
            for (int i = 0; i < arrayNegative.length; i++) {
                arrayNegative[i] = listNegative.get(i);
            }
            Arrays.sort(arrayPositive); //排序 可用来二分法查找
            Arrays.sort(arrayNegative); //排序 可用来二分法查找

            //=====
            List<Integer> twoNegative = new ArrayList<>(); //记录两负数之和
            List<Integer> twoPositive = new ArrayList<>(); //记录两正数之和

            int pre_i = 1, pre_j = 1;
            for (int i = 0; i < arrayNegative.length; i++) {
                if (pre_i != arrayNegative[i]) {
                    for (int j = i + 1; j < arrayNegative.length; j++) {
                        if (pre_j != arrayNegative[j]) {
                            twoNegative.add(arrayNegative[i] + arrayNegative[j]);
                            pre_j = arrayNegative[j];
                        }
                    }
                    pre_j = 1;
                    pre_i = arrayNegative[i];
                }
            }

            pre_i = -1;
            pre_j = -1;
            for (int i = 0; i < arrayPositive.length; i++) {
                if (arrayPositive[i] != pre_i) {
                    for (int j = i + 1; j < arrayPositive.length; j++) {
                        if (pre_j != arrayPositive[j]) {
                            twoPositive.add(arrayPositive[i] + arrayPositive[j]);
                        }
                        pre_j = arrayPositive[j];
                    }
                    pre_j = -1;
                    pre_i = arrayPositive[i];
                }
            }
            //=====

            // 计算 2负数 + 1个正数
            for (Integer integer : twoNegative) {
                if (binarySearch(arrayPositive, -integer, 0, arrayPositive.length - 1)) {
                    count++;
                }
            }
            // 计算 2正数 + 1个负数
            for (Integer integer : twoPositive) {
                if (binarySearch(arrayNegative, -integer, 0, arrayNegative.length - 1)) {
                    count++;
                }
            }

            //计算 负数+0+正数 的情况   需要注意重复数值
            int next = 1; //用个正数初始化 , 记录上个负数 去重用
            if (zeroNum > 0) {
                for (int i : arrayNegative) {
                    if (i != next) {
                        if (binarySearch(arrayPositive, -i, 0, arrayPositive.length - 1)) {
                            count++;
                        }
                        next = i;
                    }
                }
            }
        }

        //计算 0 + 0 + 0 的情况
        if (zeroNum >= 3) {
            count++;
        }

        return count;
    }

    /**
     * 二分法查找
     * 数组递增
     */
    private static boolean binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return true;
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right);
        } else {
            return binarySearch(array, target, left, mid - 1);
        }
    }
}
