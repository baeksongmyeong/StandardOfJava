package ch14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class StreamEx1 {

    public static void main(String[] args) {

        // Stuednt 인스턴스들을 Stream 으로 생성
        /*
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );
         */

        Student[] students = new Student[]{
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };

        // 스트림 생성
        Stream<Student> studentStream = Arrays.stream(students);

        // 스트림 정렬
        studentStream.sorted(
                        Comparator.comparing(Student::getBan)
                                .thenComparing(Comparator.reverseOrder()) // 이게 Student 클래스에 구현된 compareTo 메서드를 사용하게 되며, 이에 대해 정방향, 역방향을 선택할 수 있음
                )
                .forEach((student -> System.out.println(student)));

        System.out.println();

        // 스트림 생성
        studentStream = Arrays.stream(students);

        // 스트림 정렬 (이름순이며 BiFunction 을 사용하는 형태가 된다.)
        studentStream.sorted( (s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);
        System.out.println();

        // 스트림 생성
        studentStream = Arrays.stream(students);

        // 스트림 정렬
        studentStream.sorted((s1, s2) -> s1.getTotalScore() > s2.getTotalScore() ? -1 : 1)
                .forEach(System.out::println);
        System.out.println();

        // 스트림 생성
        studentStream = Arrays.stream(students);

        // 람다식만을 이용해서, 반 오름차순, 점수 내림차순, 이름 오름차순으로 정렬하려 했는데 thenComparing 이 안됨. 그래서 메서드 참조형태로 바꾸니 됨
        studentStream
                .sorted(
                        Comparator.comparing(Student::getBan).reversed()
                                .thenComparing(Student::getTotalScore).reversed()
                                .thenComparing(Student::getName)
                )
                .forEach(System.out::println);
        System.out.println();
    }
}

class Student implements Comparable<Student> {

    // static 변수

    // instance 변수
    String name;
    int ban;
    int totalScore;

    // 생성자
    public Student(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    // static 초기화
    static {}

    // instance 초기화
    {}

    // static 메서드

    // instance 메서드
    public String getName() {return name;}
    public int getBan() {return ban;}
    public int getTotalScore() {return totalScore;}

    @Override
    public String toString() {return "Student{name='" + name + '\'' + ", ban=" + ban + ", totalScore=" + totalScore + '}';}

    @Override
    public int compareTo(Student s) {return s.getTotalScore() > this.totalScore ? 1 : -1;}
}
