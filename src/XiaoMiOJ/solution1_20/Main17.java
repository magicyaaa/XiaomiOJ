package XiaoMiOJ.solution1_20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.spi.CurrencyNameProvider;

/**
 * @program: XiaomiOJ
 * @description: 小写数字转大写数字
 * @author: Ya
 * @create: 2019-05-13 22:52
 **/
public class Main17 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static String method(String line) {
        if(line.equals("0")){
            return "零元整";
        }
        int index = 0;
        int len = line.length();
        char c;
        boolean preZero = false;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            c = revers(line.charAt(index));
            if(c != '零' || !preZero){
                sb.append(c);
            }

            int num1 = len - 1 - index;
            int num_temp = (len - 1 - index) % 4;

            if (num_temp == 0) {

            } else if (num_temp == 1 && c != '零') {
                sb.append('拾');
            } else if (num_temp == 2 && c != '零') {
                sb.append('佰');
            } else if (num_temp == 3 && c != '零') {
                sb.append('仟');
            }


            if(c == '零'){
                preZero = true;
            }else {
                preZero = false;
            }

            if (num1 == 8) {
                if(c == '零'){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append('亿');
                preZero = false;
            } else if (num1 == 4) {
                if(c == '零'){
                    sb.deleteCharAt(sb.length()-1);
                }
                if(sb.charAt(sb.length()-1) !='亿'){
                    sb.append('万');
                }
                preZero = false;
            } else if (num1 == 0) {
                if(c == '零'){
                    sb.deleteCharAt(sb.length()-1);
                }
            }

            index++;
        }
        sb.append("元整");
        return sb.toString();
    }

    private static char revers(char c) {
        switch (c) {
            case '0':
                return '零';
            case '1':
                return '壹';
            case '2':
                return '贰';
            case '3':
                return '叁';
            case '4':
                return '肆';
            case '5':
                return '伍';
            case '6':
                return '陆';
            case '7':
                return '柒';
            case '8':
                return '捌';
            case '9':
                return '玖';
            default:
                return '&';
        }
    }
}
