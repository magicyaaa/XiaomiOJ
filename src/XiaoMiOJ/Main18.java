package XiaoMiOJ;

import util.ArrayUtil;

import java.lang.reflect.Member;
import java.util.*;

/**
 * @program: XiaomiOJ
 * @description: 帮小学生排队
 * @author: Ya
 * @create: 2019-05-13 22:55
 **/
public class Main18 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(method(line));
        }
    }

    private static String method(String line) {
        String[] ss = line.split(" ");
        int n = Integer.parseInt(ss[0]);
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(Integer.parseInt(ss[2 * i + 1]), Integer.parseInt(ss[2 * i + 2]));
        }
        Arrays.sort(students);

        LinkedList<Student> list = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            addStudent(list, students[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (Student st : list) {
            sb.append(st.h + " " + st.k + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static void addStudent(LinkedList<Student> list, Student st) {
        if (list.size() == 0) {
            list.add(st);
            return;
        }
        int max = st.k;
        int count = 0;
        ListIterator<Student> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (count == max) {
                iterator.add(st);
                return;
            }
            Student s = iterator.next();
            if (s.h >= st.h) {
                count++;
            }
        }
        iterator.add(st);
    }

    private static class Student implements Comparable<Student> {
        int h;
        int k;

        public Student(int h, int k) {
            this.h = h;
            this.k = k;
        }

        @Override
        public int compareTo(Student o) {
            if (o.h - this.h == 0) {
                return this.k - o.k;
            }
            return o.h - this.h;
        }

        @Override
        public String toString() {
            return " h:" + h + " k:" + k;
        }
    }
}
