package XiaoMiOJ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 最长连续数列
 * @author: Ya
 * @create: 2019-04-30 09:45
 **/
public class Main4 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(method2(line));
            // System.out.println("answer");
        }
    }

    public static int method(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : array) {
            if (!map.containsKey(i)) {
                if (map.containsKey(i - 1) && map.containsKey(i + 1)) {//左右都有
                    int left = map.get(i - 1);
                    int right = map.get(i + 1);
                    //修改最左边 记录的值
                    map.put(left, right);
                    //修改最右边 记录的值
                    map.put(right, left);
                    map.put(i, i);
                    if (right - left > max) {
                        max = right - left;
                    }
                } else if (map.containsKey(i - 1)) { //左边有
                    int left = map.get(i - 1);
                    map.put(left, i);
                    map.put(i, left);
                    if (i - left > max) {
                        max = i - left;
                    }
                } else if (map.containsKey(i + 1)) { //右边有
                    int right = map.get(i + 1);
                    map.put(right, i);
                    map.put(i, right);
                    if (right - i > max) {
                        max = right - i;
                    }
                } else { //左右都没有
                    map.put(i, i);
                }
            }
        }
        return max + 1;
    }

    //快排方式
    public static int method2(String line) {
        String[] ss = line.split(",");
        int[] array = new int[ss.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(array);
        int max = 0;
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == array[i-1]+1){
                temp++;
            }else {
                if(temp > max){
                    max = temp;
                }
                temp = 1;
            }
        }
        if(temp > max){
            max = temp;
        }
        return max;
    }
}
