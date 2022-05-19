package ch14;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
* 같은 종류의 함수형 인터페이스간에는 합성이 가능하다.
* Predicate 간의 합성시 입력된 하나의 값으로 합성시 사용된 모든 Predicate 가 test 를 진행하게 된다.
*   => Predicate 간의 값의 전달이 없다
* Function 간의 합성시 andThen 은 앞의 Function 을 먼저 실행하고, 그 결과를 뒤의 Function 의 입력으로 전달하는 것이다.
* compose 는 뒤의 Function 을 먼저 실행하고, 그 결과를 앞의 Function 에 입력으로 전달하는 것이다.
*   => Function 간의 값의 전달이 있다
* */
public class LambdaEx7 {
    public static void main(String[] args) {

        // Function 생성. 문자를 16진수로 변환
        Function<String, Integer> f = s -> Integer.parseInt(s, 16);

        // Function 생성. 숫자를 2진수 문자로 변환
        Function<Integer, String> g = i -> Integer.toBinaryString(i);

        // Function 합성 andThen. 문자 -> 숫자(16진수) -> 문자(2진수)
        Function<String, String> h = f.andThen(g);

        // Function 합성 compose. 숫자 -> 문자(2진수) -> 숫자(16진수)
        Function<Integer, Integer> h2 = f.compose(g);

        // andThen 합성 실행
        System.out.printf("%s%n", h.apply("FF"));

        // compose 합성 실행
        System.out.printf("%d%n", h2.apply(2));

        // 항등
        Function<String, String> f2 = x -> x;
        System.out.printf("%s%n", f2.apply("AAA"));

        // Predicate 100 미만
        IntPredicate p = i -> i < 100;

        // Predicate 200 미만
        IntPredicate q = i -> i < 200;

        // Predicate 2의 배수
        IntPredicate r = i -> i % 2 == 0;

        // Predicate 100 이상 ( negate() 사용 )
        IntPredicate notP = p.negate();

        // Predicate 합성. 100 이상 && ( 200 미만 || 2의 배수 )
        IntPredicate all = notP.and(q.or(r));

        // Predicate 합성 실행
        System.out.printf("%b%n", all.test(150));

        String str1 = "abc";
        String str2 = "abc";

        // Predicate 의 isEqual() 메서드는 비교원천 값을 설정하는 것
        Predicate<String> p2 = Predicate.isEqual(str1);
        System.out.printf("%b%n", p2.test(str2));
    }
}
