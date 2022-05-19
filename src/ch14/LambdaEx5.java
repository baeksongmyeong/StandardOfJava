package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {

    /*
     * 정적 메소드 doSomething
     * Function 함수형 인터페이스를 매개변수로 받는다.
     * */
    public static <T> ArrayList<T> doSomething(Function<T, T> f, List<T> list) {
        ArrayList<T> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(f.apply(t));
        }
        return newList;
    }

    /*
     * 정적 메소드 printEvenNum
     * Predicate, Consumer 함수형 인터페이스를 매개변수로 받는다
     * */
    public static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        // 요소 하나 꺼내오고
        System.out.printf("%s", "[");
        for (T t : list) {
            // 짝수여부 판단
            if (p.test(t)) {
                // 출력
                c.accept(t);
            }
        }
        System.out.printf("%s%n", "]");
    }

    /*
     * 정적메소드 makeRandomList
     * Supplier 함수형 인터페이스를 매개변수로 받는다.
     * */
    public static <T> void makeRandomList(Supplier<T> s, List<T> list){
        for (int i = 0; i < 10; i++) list.add(s.get());
    }

    /*
    * 메인 메서드
    * */
    public static void main(String[] args) {

        // 1 부터 100 사이의 난수를 생성하는 람다식을 Supplier 함수형 인터페이스로 참조
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;

        // 출력을 담당하는 람다식을 Consumer 함수형 인터페이스로 참조
        Consumer<Integer> c = i -> System.out.printf("%d, ", i);
        
        // 2의 배수 여부를 판단하는 람다식을 Predicate 함수형 인터페이스로 참조
        Predicate<Integer> p = i -> i % 2 == 0;

        // 입력된 값을 10으로 나눈 후, 10을 곱한 결과를 리턴하는 람다식을 Function 함수형 인터페이스로 참조
        Function<Integer, Integer> f = i -> (i / 10) * 10;

        // ArrayList 인스턴스 생성
        ArrayList<Integer> list = new ArrayList<>();

        // ArrayList 인스턴스에 랜덤값을 추가하되, 위에서 만든 Supplier 함수형 인터페이스로 참조한 람다식을 제공한다
        makeRandomList(s, list);

        // ArrayList 의 값 출력
        System.out.println(list);

        // ArrayList 의 요소 중 짝수만 출력하되, 위에서 만든 Predicate 로 짝수여부를 판단하고, Consumer 로 출력하도록 함수형 인터페이스로 참조하 람다식을 제공한다.
        printEvenNum(p, c, list);

        // ArrayList 의 요소들에 1의 자리를 제거한 새로운 ArrayList 인스턴스를 생성하되, 1의 자리를 제거하는 기능은 람다식으로 제공하고, Function 함수형 인터페이스로 참조하도록 한다.
        ArrayList<Integer> newList = doSomething(f, list);

        // 새로운 ArrayList 인스턴스 출력
        System.out.print(newList);
    }
}


