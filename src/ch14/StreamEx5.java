package ch14;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* 최종연산
* forEach
* 조건 일치 여부 allMatch(Predicate), anyMatch(Predicate), noneMatch(Predicate)
* 조건에 맞는 요소 중 하나 findFirst(Predicate), findAny(Predicate)
* 집계 count, max, min
* 리듀싱 reduce(BinaryOperator)
* */
public class StreamEx5 {
    public static void main(String[] args) {
        String[] strArr = {"Inheritance", "Java", "Lambda", "stream", "OptionalDouble", "IntStream", "count", "sum"};

        // 최종연산 forEach 로 출력
        Stream.of(strArr).forEach(System.out::println);

        // 최종연산 noneMatch 로 문자열길이가 0 인 요소가 있는지 확인
        boolean noneMatchR = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        boolean allMatchR = Stream.of(strArr).allMatch(s -> s.length() > 0);

        System.out.println("noneMatchR = " + noneMatchR);
        System.out.println("allMatchR = " + allMatchR);

        // 첫문자가 's' 로 시작하는 첫번째 요소 찾기
        Optional<String> sWrod = Arrays.stream(strArr).filter(s -> s.charAt(0) == 'c').findFirst();
        System.out.println("sWrod = " + sWrod.orElseGet(()->"none"));
        
        // Stream<String[]> 를 IntStream 으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        // 최종연산 reduce 를 이용한 count 구현
        int count = intStream1.reduce(0, (x, y) -> x + 1);

        // 최종연산 reduce 를 이용한 sum 구현
        int sum = intStream2.reduce(0, (x, y) -> x + y);
        
        // 최종연산 reduce 를 이용한 max 구현
        int max = intStream3.reduce(0, (x, y) -> x > y ? x : y);

        // 최종연산 reduce 를 이용한 min 구현
        int min = intStream4.reduce(0, (x, y) -> x > y ? y : x);

        Arrays.stream(strArr).mapToInt(String::length).forEach(System.out::println);
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max);
        System.out.println("min = " + min);

        // Integer 클래스의 max, min 메서드를 메서드 참조형태로 적용하여 max, min 값 찾기
        OptionalInt max1 = Stream.of(strArr).mapToInt(String::length).reduce((x, y) -> Integer.max(x, y));
        OptionalInt max2 = Stream.of(strArr).mapToInt(String::length).reduce(Integer::max);
        OptionalInt min1 = Stream.of(strArr).mapToInt(String::length).reduce((x, y) -> Integer.min(x, y));
        OptionalInt min2 = Stream.of(strArr).mapToInt(String::length).reduce(Integer::min);

        System.out.println("max1 = " + max1.getAsInt());
        System.out.println("max2 = " + max2.getAsInt());
        System.out.println("min1 = " + min1.getAsInt());
        System.out.println("min2 = " + min2.getAsInt());
    }
}
