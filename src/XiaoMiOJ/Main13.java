package XiaoMiOJ;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 出现频率最高的前 K 个元素
 * @author: Ya
 * @create: 2019-05-08 10:15
 **/
public class Main13 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 效率偏低啊!!!
     * 遍历依次 利用hashMap记录字母频数
     * 然后封装 放入数组,重写compareTo方法进行排序
     */
    private static String method(String line) {
        String[] ss = line.split(" ");
        String[] s1 = ss[0].split(",");
        int[] array = new int[s1.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }
        int k = Integer.parseInt(ss[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ArrayList<Demo> demos = new ArrayList<>();
        for (int num : map.keySet()) {
            demos.add(new Demo(num, map.get(num)));
        }

        Demo[] demos1 = new Demo[demos.size()];
        for (int i = 0; i < demos.size(); i++) {
            demos1[i] = demos.get(i);
        }

        Arrays.sort(demos1);//重点

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(demos1[i].num + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static class Demo implements Comparable<Demo> {
        int num;
        int count;

        public Demo(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Demo o) {
            if (this.count - o.count != 0) {
                return o.count - this.count;
            } else {
                return this.num - o.num;
            }
        }

        @Override
        public String toString() {
            return "[num:" + num + " count:" + count + "]";
        }
    }
}
