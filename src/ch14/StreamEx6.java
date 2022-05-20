package ch14;

/*
* 최종연산 collect() 메서드
* - 매개변수로 Collector 인터페이스를 구현한 인스턴스가 필요하다
* - Collectors 클래스는 Collector 인스턴스를 반환하는 static 메서드가 제공되므로, 이를 이용해도 된다.
*
* --------------------------------------
* 1. 스트림 -> 컬렉션
* --------------------------------------
* 
* 스트림을 List 컬렉션으로 변환 - Collections.toList()
* 스트림.collect( Collectors.toList() )
*
* 스트림을 Set 컬렉션으로 변환 - Collectors.toSet()
* 스트림.collect( Collectors.toSet() )
*
* 스트림을 Map 으로 변환 ( 키와 값을 각각 람다식으로 작성 필요 ) - Collections.toMap( 람다식, 람다식 )
* 스트림.collect( Collectors.toMap( obj -> obj.getXXX, obj -> obj ) )
*
* 스트림을 특정 컬렉션으로 변환 - Collectors.toCollection( 컬랙션의 생성자 참조 형태 )
* 스트림.collect( Collectors.toCollection ( ArrayList::new) )
*
* --------------------------------------
* 2. 스트림 -> 배열
* --------------------------------------
* 
* 스트림을 특정 타입의 배열로 변환 - 스트림.toArray( 타입의 배열의 new 메서드 참조 형태 )
* 스트림.toArray( 타입[]::new )
* 
* --------------------------------------
* 3. 스트림에서 통계내기
* --------------------------------------
*
* 스트림 내 요소의 건수 - Collectors.count()
* 스트림.collect( Collectors.count() )
*
* 스트림 내 요소의 값 합산 - Collectors.summingInt(), summingLong(), summingDouble()
* 스트림.collect( Collectors.summingIng() )
*
* 스트림 내 요소의 값 평균 - Collectors.averagingInt(), averagingLong(), averagingDouble()
* 스트림.collect( Collectors.averagingInt()
*
* 스트림 내 요소의 값 중 최대값 - Collectors.maxBy( Comparator.comparingInt( 비교하려는 요소 내 필드 ) )
* 스트림.collect( Collector.maxBy( Comparator.comparingInt( Student::getTotalScore ) ) )
*
* 스트림 내 요소의 값 중 최소값 - Collectors.minBy( Comparator.comparingInt( 비교하려는 요소 내 필드 ) )
* 스트림.collect( Collector.minBy( Comparator.comparingInt( Student::getTotalScore ) ) )
*
* 스트림 내 요소의 모든 통계값 - Collectors.summarizingInt( 집계하려는 요소 내 필드 )
* 스트림.collect( Collectors.summarizingInt( Student::getTotalScore ) )
* 
* --------------------------------------
* 4. 리듀싱
* --------------------------------------
*
* 스트림.collect( Collectors.reducing( 0, Student::getTotalScore, Integer::sum ) )
* 
* --------------------------------------
* 5. 문자열 결합
* --------------------------------------
*
* 스트림.collect( Collectors.joining( 구분자, 접두사, 접미사 )
*
* */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {

    public static void main(String[] args) {

        // StudentB 타입의 인스턴스들의 배열 생성
        StudentB[] stuArr = {
                new StudentB("이자바", 3, 300),
                new StudentB("김자바", 1, 200),
                new StudentB("안자바", 2, 100),
                new StudentB("박자바", 2, 150),
                new StudentB("소자바", 1, 200),
                new StudentB("나자바", 3, 290),
                new StudentB("감자바", 3, 180),
        };

        // 학생 이름만 뽑아서 List<String> 에 저장 후 출력
        List<String> names = Stream.of(stuArr).map(StudentB::getName).collect(Collectors.toList());
        System.out.println("names = " + names);

        // 스트림을 배열로 변환
        StudentB[] stuArr2 = Stream.of(stuArr).toArray(StudentB[]::new);
        System.out.println(Arrays.toString(stuArr2));

        // 스트림을 Map<String, StudentB> 로 변환. 학생이름이 Key
        Map<String, StudentB> stuMap = Stream.of(stuArr).collect(Collectors.toMap(StudentB::getName, Function.identity()));
        for (String name : stuMap.keySet()) {
            System.out.println(name + "-" + stuMap.get(name));
        }

        // 스트림 내 요소 건수 계산
        long count = Stream.of(stuArr).collect(Collectors.counting());
        System.out.println("count = " + count);
        
        // 스트림 내 요소 총점 합산
        long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(StudentB::getTotalScore));
        System.out.println("totalScore = " + totalScore);
        
        // reducing 을 사용한 스트림 내 총점 합산
        totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, StudentB::getTotalScore, Integer::sum));
        System.out.println("totalScore = " + totalScore);

        // mayBy 를 사용한 스트림 내 최고점수 계산
        Optional<StudentB> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(StudentB::getTotalScore).reversed()));
        System.out.println("-------------------------------");
        topStudent.ifPresent(System.out::println);
        System.out.println("-------------------------------");

        // summarizingInt 을 사용한 스트림 내 특정 필드의 통계 산출
        IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(StudentB::getTotalScore));
        System.out.println("stat = " + stat);

        // joining 을 사용한 스트림 내 문자열의 결합
        String stuNames = Stream.of(stuArr).map(StudentB::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println("stuNames = " + stuNames);
    }

    
}

class StudentB implements Comparable<StudentB>{
    String name;
    int ban;
    int totalScore;
    public StudentB(String name, int ban, int totalScore) {this.name = name;this.ban = ban;this.totalScore = totalScore;}
    public String getName() {return name;}
    public int getBan() {return ban;}
    public int getTotalScore() {return totalScore;}
    @Override public String toString() {return "StudentB{name='" + name + '\'' + ", ban=" + ban + ", totalScore=" + totalScore + '}'; }
    @Override public int compareTo(StudentB s) {return s.getTotalScore() - this.getTotalScore();}
}