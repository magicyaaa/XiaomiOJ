package XiaoMiOJ.solution31_40;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 寻找宝藏   结果不对  但是不知道为什么
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
        return false;
    }
}

/* 还是不对 nnd
private static boolean method(List<String> list) {
        int n = Integer.parseInt(list.get(0)); //一共n 个机关
        int[][] array = new int[list.size() - 1][2]; // 机关 依赖关系
        String[] ss;
        for (int i = 1; i < list.size(); i++) {
            ss = list.get(i).split(" ");
            array[i - 1][0] = Integer.parseInt(ss[0]);
            array[i - 1][1] = Integer.parseInt(ss[1]);
        }
        boolean[] door = new boolean[n]; //记录机关的开关状态  false没上锁 ；true已上锁，需要解开

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //记录机关的依赖关系
        HashSet<Integer> set;
        for (int i = 0; i < array.length; i++) {
            door[array[i][0]] = true;
            if (map.containsKey(array[i][0])) {
                map.get(array[i][0]).add(array[i][1]);
            } else {
                set = new HashSet<>();
                set.add(array[i][1]);
                map.put(array[i][0], set);
            }
        }
        HashSet<Integer> waiting_lock = new HashSet<>();//记录需要等待解开的锁，避免互相依赖出现死循环
        for (int i = 0; i < door.length; i++) { //开始遍历解锁
            if (door[i]) { //true 为需要解开 ，false为不需要解锁(已经解锁)
                if (!searchLock(i, waiting_lock, door, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    //查找此机关能否打开
    private static boolean searchLock(int cur, HashSet<Integer> waiting_lock, boolean[] door, HashMap<Integer, HashSet<Integer>> map) {
        waiting_lock.add(cur); //加入 待解开
        HashSet<Integer> set;
        if (!door[cur]) {
            waiting_lock.remove(cur);
            return true;
        }
        if (map.containsKey(cur)) { //存在依赖
            set = map.get(cur);  //依赖的机关
            for (Integer i : set) {  //查找依赖的机关能否解开
                if (!door[i]) {  //说明依赖的机关是已经打开的 ，此机关可打开
                    door[cur] = false;
                    waiting_lock.remove(cur);
                    continue;
                }
                if (waiting_lock.contains(i)) { //依赖的机关在 待解开里 ，死锁
                    return false;
                }
                // 依赖的机关没有解开 ,也不在 待解开里面
                if (searchLock(i, waiting_lock, door, map)) {
                    waiting_lock.remove(cur);
                    continue;
                }
            }
            return true;
        } else { //不存在依赖，即没有办法能解开此机关
            return false;
        }
    }
 */

/*
private static boolean method(List<String> list) {
        int n = Integer.parseInt(list.get(0)); //一共n 个机关
        int[][] array = new int[list.size() - 1][2]; // 机关 依赖关系
        String[] ss;
        for (int i = 1; i < list.size(); i++) {
            ss = list.get(i).split(" ");
            array[i - 1][0] = Integer.parseInt(ss[0]);
            array[i - 1][1] = Integer.parseInt(ss[1]);
        }
        boolean[] door = new boolean[n]; //记录机关的开关状态  false没上锁 ；true已上锁，需要解开

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //记录机关的依赖关系
        HashSet<Integer> set;
        for (int i = 0; i < array.length; i++) {
            door[array[i][0]] = true;
            if (map.containsKey(array[i][0])) {
                map.get(array[i][0]).add(array[i][1]);
            } else {
                set = new HashSet<>();
                set.add(array[i][1]);
                map.put(array[i][0], set);
            }
        }
        HashSet<Integer> waiting_lock = new HashSet<>();//记录需要等待解开的锁，避免互相依赖出现死循环
        for (int i = 0; i < door.length; i++) { //开始遍历解锁
            if (door[i]) { //true 为需要解开 ，false为不需要解锁(已经解锁)
                if (!searchLock(i, waiting_lock, door, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    //查找此机关能否打开
    private static boolean searchLock(int cur, HashSet<Integer> waiting_lock, boolean[] door, HashMap<Integer, HashSet<Integer>> map) {
        waiting_lock.add(cur); //加入 待解开
        HashSet<Integer> set;
        if (!door[cur]) {
            waiting_lock.remove(cur);
            return true;
        }
        if (map.containsKey(cur)) { //存在依赖
            set = map.get(cur);  //依赖的机关
            for (Integer i : set) {  //查找依赖的机关能否解开
                if (!door[i]) {  //说明依赖的机关是已经打开的 ，此机关可打开
                    door[cur] = false;
                    waiting_lock.remove(cur);
                    return true;
                }
                if (waiting_lock.contains(i)) { //依赖的机关在 待解开里 ，死锁
                    continue;  //寻找其他依赖
                }
                // 依赖的机关没有解开 ,也不在 待解开里面
                if (searchLock(i, waiting_lock, door, map)) {
                    waiting_lock.remove(cur);
                    return true;
                }
            }
            return false;
        } else { //不存在依赖，即没有办法能解开此机关
            return false;
        }
    }
 */
