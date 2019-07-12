package XiaoMiOJ.solution80_89;

import java.util.Scanner;

/**
 * @program: XiaomiOJ
 * @description: 论 ADC 如何出装
 * @author: Ya
 * @create: 2019-06-28 11:34
 **/
public class Main84 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    /**
     * Global hard timeout exceeded. For more information, please contact the developer.
     */
    private static String method(String line) {
        String[] ss = line.split(" ");
        int x = Integer.parseInt(ss[0]);  //己方等级
        int y = Integer.parseInt(ss[1]);  //对方护甲

        int axe_damage = 185;
        int axe_stab = 100 + x * 10;
        int bow_damage = 180;
        double bow_stab = 0.45d;

        double defence1 = (y - axe_stab);  //斧子剩余护甲
        double defence2 = y * (1 - bow_stab); //弓 剩余护甲
        double damange1 = axe_damage * (1 - defence1 * (602 + defence1));
        double damange2 = bow_damage * (1 - defence2 * (602 + defence2));
        return damange1 > damange2 ? "axe" : "bow";
    }
}
