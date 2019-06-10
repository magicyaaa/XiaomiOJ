package XiaoMiOJ.solution40_49;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 要多少个立方数
 * @author: Ya
 * @create: 2019-06-10 23:25
 **/
public class Main44 {
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
        Set<Integer> cubeNumSet = new HashSet<>(); //保存立方数
        int i = 1;
        int temp;
        while (true) {
            temp = (int) Math.pow(i, 3);
            if (temp > num) {
                break;
            } else {
                cubeNumSet.add(temp);
            }
            i++;
        }
        int[] array = new int[cubeNumSet.size()];
        Iterator<Integer> iterator = cubeNumSet.iterator();
        for (int j = 0; j < cubeNumSet.size(); j++) {
            array[j] = iterator.next();
        }

        Arrays.sort(array);
        int res = 0;
        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] <= num) {
                num -= array[j];
                j++;
                res++;
            }
        }
        return res;
    }
}
