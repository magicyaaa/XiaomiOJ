package XiaoMiOJ;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: XiaomiOJ
 * @description: 大数的加法运算与大小判断
 * @author: Ya
 * @create: 2019-05-13 22:55
 **/
public class Main19 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(mehtod(line));
        }
    }

    private static String mehtod(String line) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        char sign = '&';
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                if (sign == '&') {
                    list1.add(line.charAt(i) - '0');
                } else {
                    list2.add(line.charAt(i) - '0');
                }
            } else {
                sign = line.charAt(i);
            }
        }

        if (sign == '+') {
            StringBuilder sb = new StringBuilder();
            boolean carry = false;
            int index1 = list1.size() - 1;
            int index2 = list2.size() - 1;
            int num_temp;
            while (index1 >= 0 && index2 >= 0) {
                num_temp = list1.get(index1) + list2.get(index2);
                if (carry) { //判断是否已经进位 +1
                    num_temp++;
                }

                if (num_temp >= 10) { //判断是否要进位
                    carry = true;
                    num_temp -= 10;
                } else {
                    carry = false;
                }
                sb.append(num_temp);
                index1--;
                index2--;
            }

            if (list1.size() != list2.size()) {
                int index;
                if (index1 > index2) {
                    index = index1;
                } else {
                    index = index2;
                    list1 = list2;
                }
                while (index >= 0) {
                    num_temp = list1.get(index);
                    if (carry) {
                        num_temp++;
                    }
                    if (num_temp >= 10) {
                        carry = true;
                        num_temp -= 10;
                    } else {
                        carry = false;
                    }
                    sb.append(num_temp);
                    index--;
                }
                if(carry){
                    sb.append(1);
                }
            } else if (carry) {
                sb.append(1);
            }

            sb.reverse();
            return sb.toString();

        } else {  //比较大小
            if (list1.size() > list2.size()) {
                return sign == '>' ? "Y" : "N";
            } else if (list1.size() < list2.size()) {
                return sign == '>' ? "N" : "Y";
            } else {
                int index = 0;
                while (index < list1.size() && index < list2.size()) {
                    if (list1.get(index) > list2.get(index)) {
                        return sign == '>' ? "Y" : "N";
                    } else if (list1.get(index) < list2.get(index)) {
                        return sign == '>' ? "N" : "Y";
                    } else {
                        index++;
                    }
                }
                return "N";
            }
        }
    }
}
