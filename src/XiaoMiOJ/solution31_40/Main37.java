package XiaoMiOJ.solution31_40;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 寻找宝藏   OK
 * @author: Ya
 * @create: 2019-05-31 14:19
 **/
public class Main37 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;

        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            if (line == null || line.length() < 1) { //可以去掉
                break;
            }
            list.add(line);
        }
        System.out.println(method(list));
    }

    private static boolean method(List<String> list) {
        int num = Integer.parseInt(list.get(0));
        int[][] array = new int[list.size() - 1][2];
        Map<Integer, List<Integer>> lock = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String[] ss = list.get(i + 1).split(" ");
            array[i][0] = Integer.parseInt(ss[0]);
            array[i][1] = Integer.parseInt(ss[1]);
            if (!lock.containsKey(array[i][0])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(array[i][1]);
                lock.put(array[i][0], temp);
            } else {
                lock.get(array[i][0]).add(array[i][1]);
            }
        }

        boolean[] tag = new boolean[num];
        for (int i = 0; i < array.length; i++) {
            tag[array[i][0]] = true;
        }

        boolean deathLock;  //是否死锁  即便利一遍都一个都解不开
        boolean hasLock;   //是否还有锁  即是否已经全解开
        while (true) {
            deathLock = true;
            hasLock = false;
            for (int i = 0; i < tag.length; i++) {
                //检查上锁的 依赖是否都打开
                if (tag[i]) {
                    hasLock = true;
                    if (isOpen(tag, i, lock)) {
                        tag[i] = false;
                        deathLock = false;
                        break;
                    }
                }
            }
            if (!hasLock) {
                return true;
            }
            if (deathLock) {
                return false;
            }
        }
    }

    private static boolean isOpen(boolean[] tag, int key, Map<Integer, List<Integer>> map) {
        List<Integer> list = map.get(key);
        for (Integer i : list) {
            if (tag[i]) {
                return false;
            }
        }
        return true;
    }
}

