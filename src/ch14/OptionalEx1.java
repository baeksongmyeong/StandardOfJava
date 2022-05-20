package ch14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalEx1 {
    public static void main(String[] args) {
        
        // Optional 인스턴스 생성 : of(T value) 메서드
        Optional<String> optStr = Optional.of("abcde");

        // Optional 인스턴스의 map(Function ) 메서드
        Optional<Integer> optInt = optStr.map(String::length);

        // Optional 인스턴스의 get() 메서드
        System.out.println("optStr = " + optStr.get());
        System.out.println("optInt = " + optInt.get());
        System.out.println();

        // Optional 인스턴스의 filter 메서드
        int result1 = Optional.of("123").filter(s -> s.length() > 0).map(s -> Integer.valueOf(s)).get();
        
        // Optional 인스턴스의 orElse 메서드
        int result2 = Optional.of("").filter(s -> s.length() > 0).map(s -> Integer.valueOf(s)).orElse(-1);

        System.out.println("result1 : " + result1);
        System.out.println("result2 = " + result2);
        System.out.println();

        // Optional 인스턴스의 isPresent 메서드
        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());
        System.out.println();

        // Optional 의 기본형에서 값 가져오는 get As X 메서드
        System.out.println(optInt1.getAsInt());
        //System.out.println(optInt2.getAsInt()); // 예외발생
        System.out.println();

        // Optional 인스턴스의 toString 메서드
        System.out.println("optInt1 = " + optInt1);
        System.out.println("optInt2 = " + optInt2);
        System.out.println();
        
        // Optional 인스턴스의 equals 메서드
        System.out.println("optInt1.equals(optInt2) = " + optInt1.equals(optInt2));
        System.out.println();

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return Integer.valueOf(optStr.get());
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            return defaultValue;
        }
    }
}

