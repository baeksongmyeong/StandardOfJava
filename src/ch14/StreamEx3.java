package ch14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        // 스트림의 소스가 될 StudentA 클래스의 인스턴스들을 담는 배열 생성
        StudentA[] stuArr = new StudentA[]{
                new StudentA("이자바", 3, 300),
                new StudentA("김자바", 1, 200),
                new StudentA("안자바", 2, 100),
                new StudentA("박자바", 2, 150),
                new StudentA("소자바", 1, 200),
                new StudentA("나자바", 3, 290),
                new StudentA("감자바", 3, 180),
        };

        // 배열을 소스로하여 StudentA 를 담는 스트림 생성
        Stream<StudentA> stuStream = Arrays.stream(stuArr);
        
        // 스트림을 반, 점수 순 ( StudentA 에 구현한 Comparable 의 compareTo() 메서드를 사용 ) 으로 정렬하여 출력
        stuStream.sorted().sorted(Comparator.comparing(StudentA::getBan).thenComparing(Comparator.reverseOrder())).forEach(System.out::println);

        System.out.println("-----------------------------");

        // 스트림 재생성 후 점수를 추출하여 기본형 스트림으로 생성
        IntStream stuScoreStream = Stream.of(stuArr).mapToInt(StudentA::getTotalScore);

        // 기본형 스트림의 summaryStatistics 메서드 호출
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();

        // summaryStatistics 가 반환한 SummaryStatistics 인스턴스의 메서드를 이용해서 통계 결과 확인
        System.out.printf("%-10s%-2s%d%n", "count", "=", stat.getCount());
        System.out.printf("%-10s%-2s%d%n", "sum", "=", stat.getSum());
        System.out.printf("%-10s%-2s%f%n", "average", "=", stat.getAverage());
        System.out.printf("%-10s%-2s%d%n", "min", "=", stat.getMin());
        System.out.printf("%-10s%-2s%d%n", "max", "=", stat.getMax());
    }
}

class StudentA implements Comparable<StudentA>{
    String name;
    int ban;
    int totalScore;

    public StudentA(String name, int ban, int totalScore) {this.name = name;this.ban = ban;this.totalScore = totalScore;}

    public String getName() {return name;}
    public int getBan() {return ban;}
    public int getTotalScore() {return totalScore;}

    @Override public int compareTo(StudentA o) {return o.getTotalScore() - this.totalScore;}
    @Override public String toString() {return "StudentA{name='" + name + '\'' + ", ban=" + ban + ", totalScore=" + totalScore + '}'; }
}
