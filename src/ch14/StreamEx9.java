package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamEx9 {
    public static void main(String[] args) {

        Integer[] iArr = {1, 2, 3};

        // 지네릭 스트림 -> 기본형 스트림
        Stream<Integer> iArr1 = Stream.of(iArr);
        IntStream intStream = iArr1.mapToInt(i -> i);

        // 기본형 스트림 -> 지네릭 스트림
        Stream<Integer> boxed = intStream.boxed();

        // 기본형 스트림 -> 다른 타입의 기본형 스트림
        IntStream range = IntStream.range(1, 10);
        LongStream longStream = range.asLongStream();

        // 스트림 -> 부분 스트림
        longStream.skip(5).limit(4);

        // 두개의 스트림 결합
        IntStream.concat(IntStream.range(1, 10), IntStream.range(10, 20));

        // 스트림 내 스트림 -> 스트림
        // flatMap

        // 스트림 -> 병렬 스트림
        IntStream.of(1, 2, 3).parallel();

        // 병렬 스트림 -> 스트림
        IntStream parallel = IntStream.range(1, 10).parallel();
        parallel.sequential();

        // 스트림 -> 컬렉션
        Stream<String> strStream = Stream.of("AAA", "BBB", "CCC");
        ArrayList<String> collect1 = strStream.collect(Collectors.toCollection(ArrayList<String>::new));

        // 스트림 -> List
        List<String> collect = Stream.of("AAA", "BBB", "CCC").collect(Collectors.toList());

        // 스트림 -> Set
        Set<String> collect2 = Stream.of("AAA", "BBB", "CCC").collect(Collectors.toSet());

        // 컬렉션 -> 스트림
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        Stream<String> stream = arrayList.stream();

        // 스트림 -> 맵
        Map<String, String> collect3 = Stream.of("AAA", "BBB", "CCC").collect(Collectors.toMap(s -> s, s -> s));

        // 스트림 -> 배열
        Stream<String> aaa = Stream.of("AAA", "BBB", "CCC");
        String[] strings = aaa.toArray(String[]::new);

        // 스트림 -> 기본형 배열
        int[] ints = Stream.of(1, 2, 3).mapToInt(i -> i).toArray();
    }
}
