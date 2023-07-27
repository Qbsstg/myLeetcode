package honor;

import java.util.*;

public class honor4 {

    public static class Student implements Comparable<Student> {

        String id;
        int score;

        public Student(String id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return score != o.score ? Integer.compare(score, o.score) : id.compareTo(o.id);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String grade_one_str = sc.nextLine();
        String grade_two_str = sc.nextLine();

        Map<String, Integer> student_id_map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(grade_one_str, ";");
        while (st.hasMoreTokens()) {
            List<String> list = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            student_id_map.put(list.get(0), Integer.valueOf(list.get(1)));
        }

        Map<String, Set<Student>> student_map = new HashMap<>();
        st = new StringTokenizer(grade_two_str, ";");
        while (st.hasMoreTokens()) {
            List<String> list = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
            while (st2.hasMoreTokens()) {
                list.add(st2.nextToken());
            }

            String id = list.get(0);

            if (student_id_map.containsKey(id)) {
                int total = student_id_map.get(id) + Integer.parseInt(list.get(1));
                String temp = id.substring(0, 5);
                student_map.computeIfAbsent(temp, k -> new TreeSet<>()).add(new Student(id, total));
            }
        }

        if (student_map.isEmpty()) {
            System.out.println("NULL");
        } else {
            student_map.forEach((k, v) -> {
                System.out.println(k);
                StringBuilder res = new StringBuilder();
                v.forEach(e -> {
                    res.append(e.id).append(";");
                });
                System.out.println(res.substring(0, res.length() - 1));
            });
        }
    }
}
