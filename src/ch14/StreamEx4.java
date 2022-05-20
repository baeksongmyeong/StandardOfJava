package ch14;

import java.util.stream.Stream;

/*
* flatMap 중간연산
*   - 2차원으로 구성되는 요소들을 1차원으로 변환할 수 있다.
* */
public class StreamEx4 {
    public static void main(String[] args) {

        String[][] strArr = {{"abc", "def", "jkl"}, {"ABC", "GHI", "JKL"}};

        // Map 을 쓰면 1차원으로 구성이 불가하다.
        Stream<Stream<String>> streamStream = Stream.of(strArr).map(Stream::of);

        // flatMap 을 쓰면 2차원 요소들을 1차원으로 구성할 수 있다
        Stream<String> strStrm = Stream.of(strArr).flatMap(Stream::of);

        // 모든 요소들에 대해 소문자 변환, 중복 제거, 오름차순 정렬 후 출력
        strStrm.map(String::toLowerCase).distinct().sorted().forEach(System.out::println);

        System.out.println();

        // 문장의 배열
        String[] lineArr = new String[]{"Believe or not It is true", "Do or do not There is no try"};
        
        // 공백 구분자로 분할, 소문자 변환, 중복 제거, 정렬 후 출력
        Stream.of(lineArr).flatMap(s -> Stream.of(s.toLowerCase().split(" +"))).distinct().sorted().forEach(System.out::println);

        System.out.println();

        // Stream<Stream<String>> 형태 생성
        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);

        // Stream<Stream<String>> -> Stream<String[]> 로 변환
        Stream<String[]> streamA = strStrmStrm.map(s -> s.toArray(String[]::new));

        // Stream<String[]> -> Stream<String> 로 변환
        Stream<String> streamB = streamA.flatMap(Stream::of);

        // 출력
        streamB.map(String::toLowerCase).distinct().forEach(System.out::println);



    }
}
