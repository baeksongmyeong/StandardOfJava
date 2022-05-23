package ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentF {

    enum LEVEL {HIGH, MID, LOW, FAIL}

    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;
    LEVEL level;

    public StudentF(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
        if(score>=200) this.level = LEVEL.HIGH;
        else if(score>=100) this.level = LEVEL.MID;
        else this.level = LEVEL.LOW;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    public LEVEL getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "StudentF{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", score=" + score +
                ", level=" + level +
                '}';
    }
}

public class StreamEx8 {
    public static void main(String[] args) {
        StudentF[] stuArr = new StudentF[]{

                //-----------------------------------------------
                // 1학년
                //-----------------------------------------------

                // 1반
                new StudentF("나자바", true,  1, 1, 300),
                new StudentF("김지미", false, 1, 1, 250),
                new StudentF("김자바", true,  1, 1, 200),

                // 2반
                new StudentF("이지미", false, 1, 2, 150),
                new StudentF("남자바", true,  1, 2, 100),
                new StudentF("안지미", false, 1, 2, 50),

                // 3반
                new StudentF("황지미", false, 1, 3, 100),
                new StudentF("강지미", false, 1, 3, 150),
                new StudentF("이자바", true,  1, 3, 200),

                //-----------------------------------------------
                // 2학년
                //-----------------------------------------------

                // 1반
                new StudentF("나자바", true,  2, 1, 300),
                new StudentF("김지미", false, 2, 1, 250),
                new StudentF("김자바", true,  2, 1, 200),

                // 2반
                new StudentF("이지미", false, 2, 2, 150),
                new StudentF("남자바", true,  2, 2, 100),
                new StudentF("안지미", false, 2, 2, 50),

                // 3반
                new StudentF("황지미", false, 2, 3, 100),
                new StudentF("강지미", false, 2, 3, 150),
                new StudentF("이자바", true,  2, 3, 200),
        };

        System.out.printf("%n1. 단순 그룹화 (반별 학생목록)%n");

        Map<Integer, List<StudentF>> result1 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getBan, Collectors.toList()));
        for (List<StudentF> students : result1.values()) {
            for (StudentF student : students) {
                System.out.println(student);
            }
        }

        System.out.printf("%n2. 단순 그룹화 (성적등급별 학생목록)%n");

        Map<StudentF.LEVEL, List<StudentF>> result2 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getLevel));
        TreeSet<StudentF.LEVEL> keySet1 = new TreeSet<>(result2.keySet());
        for (StudentF.LEVEL key : keySet1) {
            System.out.println("[" + key + "]");
            for (StudentF s : result2.get(key)) System.out.println(s);
            System.out.println();
        }


        System.out.printf("%n3. 단순 그룹화 + 통계 (성적등급별 학생수)%n");

        Map<StudentF.LEVEL, Long> result3 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getLevel, Collectors.counting()));
        for (StudentF.LEVEL level : result3.keySet()) System.out.println("["+ level + "] " + result3.get(level) + "명");


        System.out.printf("%n4. 다중 그룹화 (학년별, 반별 학생목록)%n");
        Map<Integer, Map<Integer, List<StudentF>>> result4 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getHak, Collectors.groupingBy(StudentF::getBan)));
        for (Map<Integer, List<StudentF>> hak : result4.values()) {
            for (List<StudentF> ban : hak.values()) {
                System.out.println();
                for (StudentF s : ban) {
                    System.out.println(s);
                }
            }
        }


        System.out.printf("%n5. 다중 그룹화 + 통계(학년별, 반별 1등 학생 1건)%n");
        Map<Integer, Map<Integer, StudentF>> result5 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getHak, Collectors.groupingBy(StudentF::getBan, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(StudentF::getScore)), Optional::get))));
        for (Map<Integer, StudentF> ban : result5.values()) {
            for (StudentF s : ban.values()) {
                System.out.println(s);
            }

        }


        System.out.printf("%n6. 다중 그룹화 + 통계(학년별, 반별 어떤 성적그룹들이 있는가? 등급은 중복되지 않게 출력)%n");
        Map<Integer, Map<Integer, Set<StudentF.LEVEL>>> result6 = Stream.of(stuArr).collect(Collectors.groupingBy(StudentF::getHak, Collectors.groupingBy(StudentF::getBan, Collectors.mapping(StudentF::getLevel, Collectors.toSet()))));
        System.out.println(result6);
    }
}
