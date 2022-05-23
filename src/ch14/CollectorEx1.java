package ch14;

/*
* Collector 의 구현
* - Collector 인터페이스를 구현해야 한다.
* - Collector< T, A, R >
* - 아래의 메서드를 구현해야 한다.
* - 1. Supplier<A> supplier()         : 작업결과를 저장할 공간 정의
* - 2. BiConsumer<A, T> accumulator() : 스트림의 요소를 어떻게 supplier() 가 제공한 공간에 누적할 것인지 정의 
* - 3. BinaryOperator<A> combiner()   : 병렬 스트림인 경우, 각 쓰레드의 처리결과를 어떻게 합칠 것인지 정의
* - 4. Function<A, R> finisher()      : 작업결과 변환방식을 정의. 변환이 필요없으면 항등 함수 Function.identity() 사용
* - 5. Set<Characteristics> characteristics() : 컬렉터가 수행하는 작업의 속성을 나타내는 정보를 제공.
*       - Characteristics.CONCURRENT      : 병렬처리 작업
*       - Characteristics.UNORDERED       : 요소 간 순서 유지가 불가한 작업
*       - Characteristics.IDENTITY_FINISH : finisher() 메서드에 항등함수가 적용된 작업
* */

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorEx1 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb", "ccc"};
        Stream<String> strStream = Stream.of(strArr);
        String result = strStream.collect(new ConcatCollector());
        System.out.println(Arrays.toString(strArr));
        System.out.println("result = " + result);
    }
}

// Collector<T, A, R>
class ConcatCollector implements Collector<String, StringBuilder, String> {

    // 저장할 공간
    @Override
    public Supplier<StringBuilder> supplier() {
        System.out.println("supplier");
        return () -> new StringBuilder();
    }

    // 저장할 공간에 스트림의 요소를 어떻게 누적할 것인가?
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        System.out.println("accumulator");
        return (sb, s) -> sb.append(s);
    }

    // 병행 수행 결과간 처리방법
    @Override
    public BinaryOperator<StringBuilder> combiner() {
        System.out.println("combiner");
        return (sb1, sb2) -> sb1.append(sb2);
    }

    // 최종 요소 타입
    @Override
    public Function<StringBuilder, String> finisher() {
        System.out.println("finisher");
        return sb -> sb.toString();
    }

    // Collector 의 설명
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics");
        return Collections.emptySet();
    }
}
