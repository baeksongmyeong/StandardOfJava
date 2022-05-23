package ch14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx7 {
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

        System.out.println("1. 단순분할(성별로 분할");
        Map<Boolean, List<StudentF>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(StudentF::isMale));
        System.out.println("남학생 : " + stuBySex.get(true));
        System.out.println("여학생 : " + stuBySex.get(false));

        System.out.println("----------------------");

        System.out.println("2. 단순분할 + 통계(성별 학생수");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(StudentF::isMale, Collectors.counting()));
        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        System.out.println("----------------------");

        System.out.println("3-1. 단순분할 + 통계(성별 1등) - Optional 타입 반환");
        Map<Boolean, Optional<StudentF>> topScoreBySex = Stream.of(stuArr).collect(
                Collectors.partitioningBy(
                        StudentF::isMale
                        , Collectors.maxBy(Comparator.comparing(StudentF::getScore))
                ));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        System.out.println("----------------------");

        System.out.println("3-2. 단순분할 + 통계(성별 1등) - T 타입 반환");
        Map<Boolean, StudentF> topScoreBySex2 = Stream.of(stuArr).collect(
                Collectors.partitioningBy(StudentF::isMale
                        , Collectors.collectingAndThen( // 추가
                                Collectors.maxBy(Comparator.comparingInt(StudentF::getScore))
                                , Optional::get // 추가
                        )
                )
        );
        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));

        System.out.println("----------------------");

        System.out.println("4. 다중분할 (성별 불합격자, 100 점 이하");
        /*
        * 1. 성별로 분류
        * 2. 분류된 결과에서 100 점이하 분류
        * */
        Map<Boolean, Map<Boolean, List<StudentF>>> failedStuBySex = Arrays.stream(stuArr).collect(
                Collectors.partitioningBy(
                        StudentF::isMale // 성별 분류
                        , Collectors.partitioningBy( // partitionBy 안에 partitionBy 를 사용할 수 있다.
                                stu -> stu.getScore() <= 100 // 100 점 이하 분류
                        )
                )
        );
        // 남자 100 점 이하 학생 목록
        List<StudentF> failedMaleStu = failedStuBySex.get(true).get(true);

        // 여자 100 점 이하 학생 목록
        List<StudentF> failedFemaleStu = failedStuBySex.get(false).get(true);

        System.out.println("남자 100점 이하자 : " + failedMaleStu);
        System.out.println("여자 100점 이하자 : " + failedFemaleStu);
    }
}

class StudentE {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public StudentE(String name, boolean isMale, int hak, int ban, int score) {this.name = name;this.isMale = isMale;this.hak = hak;this.ban = ban;this.score = score;}

    public String getName() {return name;}
    public boolean isMale() {return isMale;}
    public int getHak() {return hak;}
    public int getBan() {return ban;}
    public int getScore() {return score;}

    @Override public String toString() {return "StudentD{name='" + name + '\'' + ", isMale=" + isMale + ", hak=" + hak + ", ban=" + ban + ", score=" + score + '}'; }

    // groupingBy 에서 사용
    enum Level {HIGH, MID, LOW}
}
