package ch14;

/*
* 메서드 참조
* 람다식이 하나의 메서드만을 호출하는 경우
* 메서드만을 기술해서 람다식을 간소화 시킬 수 있다.
* */

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Person {
    int age;
    String name;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class LambdaEx8 {
    public static void main(String[] args) {

        // 입력된 문자열을 출력하는 Consumer 생성
        Consumer<String> c = (s)-> System.out.println(s);
        c.accept("ABC");

        // 메서드 참조 형태로 변형
        c = System.out::println;
        c.accept("ABC");

        // 입력된 문자열을 숫자로 바꾸는 Function 생성
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        System.out.println(f.apply("14"));

        // 메서드 참조 형태로 변경
        f = Integer::parseInt;
        System.out.println(f.apply("16"));

        // 문자열 2개를 입력하여 일치여부를 확인하는 BiFunction 생성
        BiFunction<String, String, Boolean> bf = (s1, s2) -> s1.equals(s2);
        System.out.println(bf.apply("abc", "def"));

        // 메서드 참조 형태로 변형
        bf = String::equals;
        System.out.println(bf.apply("abc", "abc"));
        
        // 생성자를 호출하여 인스턴스를 만드는 Supplier 생성
        Supplier<Person> s = () -> new Person();
        System.out.println(s.get());

        // 메서드 참조 형태로 변형
        s = Person::new;
        System.out.println(s.get());

        // 인자가 1개 있는 생성자를 호출하여 인스턴스를 리턴하는 람다식
        Function<Integer, Person> f2 = (i) -> new Person(i);
        System.out.println(f2.apply(10));
        
        // 메서드 참조 형태로 변형
        Function<Integer, Person> f3 = Person::new;
        System.out.println(f3.apply(20));

        // 인자가 2개 있는 생성자를 호출하여 인스턴스를 리턴하는 람다식
        BiFunction<Integer, String, Person> f4 = (age, name) -> new Person(age, name);
        System.out.println(f4.apply(10, "aaa"));

        // 메서드 참조 변형
        BiFunction<Integer, String, Person> f5 = Person::new;
        System.out.println(f5.apply(20, "bbb"));

        // 존재하지 않는 생성자의 매개변수 타입으로 함수형 인터페이스의 지네릭을 설정시 컴파일러가 자동으로 오류처리해줌.
        //BiFunction<String, String, Person> f6 = (x, y) -> new Person(x, y);
    }
}
