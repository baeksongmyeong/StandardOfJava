package ch9;

import java.math.BigInteger;
import java.util.Arrays;

/*
* BigInteger 는 기본형중 가장 큰 정수를 다루는 long 보다 더 큰 정수를 다루기 위해 만든 래퍼 클래스이다.
* 해 단위까지 다룰수 있다.
* new 연산자 또는 static 메서드인 valueOf() 메서드로 인스턴스를 생성할 수 있다.
* String 인스턴스로의 변환을 지원한다. toString()
* byte 배열 인스턴스로의 변환을 지원한다. toByteArray()
* 연산자는 쓸 수 없으며, 별도의 연산용 메서드가 지원된다.
* 속도는 기본형 long 보다 느리며, 비트연산 메서드를 잘 활용해야 한다.
* */
public class BigIntegerEx {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d!=%s%n", i, clacFactorial(i));
            //Thread.sleep(300);
        }

        // byte 배열로의 변환
        byte[] bytes = BigInteger.TEN.toByteArray();
        System.out.println(Arrays.toString(bytes));

        // String 으로의 변환
        System.out.println(BigInteger.TEN.toString());

        // 기본형으로의 변환
        System.out.println(BigInteger.TEN.intValue());
        System.out.println(BigInteger.TEN.longValue());
        System.out.println(BigInteger.TEN.floatValue());
        System.out.println(BigInteger.TEN.doubleValue());
    }

    static String clacFactorial(int n){
        return factorial(BigInteger.valueOf(n)).toString();
    }

    static BigInteger factorial(BigInteger n){
        if(n.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        else{
            // n * factorial(n-1)
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
