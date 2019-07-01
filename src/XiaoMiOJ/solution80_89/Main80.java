package XiaoMiOJ.solution80_89;

import util.ArrayUtil;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: XiaomiOJ
 * @description: 最短字符串
 * @author: Ya
 * @create: 2019-06-25 19:38
 **/
public class Main80 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method2(line));
        }
    }

    private static String method2(String line) {
        Stack<Integer> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        list.add(line.charAt(0));
        int[] tag = new int[line.length()];
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == list.get(0)) { //和开头匹配
                tag[i] = 0;
                stack.push(i);
            } else { //和开头不匹配
                tag[i] = tag[i - 1] + 1;
                if (tag[i] >= list.size()) {  //更长匹配
                    list.add(line.charAt(i));
                } else {
                    if (list.get(tag[i]) == line.charAt(i)) { //继续匹配

                    } else { //不能继续匹配 新的头错了
                        i = stack.pop(); //取上次的头
                        tag[i] = tag[i - 1] + 1;
                        if (tag[i] >= list.size()) {  //更长匹配
                            list.add(line.charAt(i));
                        }else {
                            while (list.get(tag[i]) != line.charAt(i)){
                                i = stack.pop(); //取上次的头
                                tag[i] = tag[i - 1] + 1;
                                if (tag[i] >= list.size()) {  //更长匹配
                                    list.add(line.charAt(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        //ArrayUtil.printArray(tag);
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}