package XiaoMiOJ.solution50_59;

import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 数独游戏
 * @author: Ya
 * @create: 2019-06-15 15:30
 **/
public class Main54 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * 输入
     * 从左到右从上到下，使用空格分隔每一宫，使用逗号分隔每一格，没有数字则代表该格为空。
     */
    private static boolean method(String line) {
        String[] ss1 = line.split(" ");
        List<int[]> list = new ArrayList<>();  //9个宫
        for (String s : ss1) {
            String[] ss2 = s.split(",");
            int[] temp = new int[ss2.length];
            for (int i = 0; i < temp.length; i++) {
                if (ss2[i].equals("-")) {
                    temp[i] = -1;
                } else {
                    temp[i] = Integer.parseInt(ss2[i]);
                }
            }
            list.add(temp);
        }
        //检查宫
        Set<Integer> set = new HashSet<>();
        for (int[] a : list) {
            set.clear();
            for (int num : a) {
                if (num != -1) {
                    if (set.contains(num)) {
                        return false;
                    } else {
                        set.add(num);
                    }
                }
            }
        }
        //检查行
        for (int i = 0; i < list.size(); i += 3) {
            for (int c = 0; c < 9; c += 3) {
                set.clear();
                for (int c1 = c; c1 < c + 3; c1++) {
                    for (int j = i; j < i + 3; j++) {
                        if (list.get(j)[c1] != -1) {
                            if (set.contains(list.get(j)[c1])) {
                                return false;
                            } else {
                                set.add(list.get(j)[c1]);
                            }
                        }
                    }
                }
            }
        }

        //检查列
        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 3; c++) {
                set.clear();
                for (int c1 = c; c1 < 9; c1 += 3) {
                    for (int j = i; j < 9; j += 3) {
                        if (list.get(j)[c1] != -1) {
                            if (set.contains(list.get(j)[c1])) {
                                return false;
                            } else {
                                set.add(list.get(j)[c1]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    private static boolean checkRow(int[][] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != -1) {
                    if (set.contains(array[i][j])) {
                        return false;
                    } else {
                        set.add(array[i][j]);
                    }
                }
            }
            set.clear();
        }
        return true;
    }

    private static boolean checkCloumn(int[][] array) {
        Set<Integer> set = new HashSet<>();
        for (int c = 0; c < array[0].length; c++) {
            for (int r = 0; r < array.length; r++) {
                if (array[r][c] != -1) {
                    if (set.contains(array[r][c])) {
                        return false;
                    } else {
                        set.add(array[r][c]);
                    }
                }
            }
            set.clear();
        }
        return true;
    }

    private static boolean checkSquar(int[][] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i += 3) {
            for (int j = 0; j < array[0].length; j += 3) {
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (array[r][c] != -1) {
                            if (set.contains(array[r][c])) {
                                return false;
                            } else {
                                set.add(array[r][c]);
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }

}
