package ch9;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/*
* BigDecimal 은 기본형 실수를 다루는 double 보다 큰 실수를 다루기 위한 래퍼 클래스이다.
* */
public class BigDecimalEx {

    public static void main(String[] args) {

        // 생성
        BigDecimal bd  = BigDecimal.valueOf(2.0);
        BigDecimal bd1 = new BigDecimal("123.456");
        BigDecimal bd2 = new BigDecimal("1.0");

        System.out.print("bd1="+bd1);
        System.out.print(",\tvalue="+bd1.unscaledValue()); // 전체 숫자
        System.out.print(",\tscale="+bd1.scale()); // 소수점 이하 자리수
        System.out.print(",\tprecision="+bd1.precision()); // 정수 자리수
        System.out.println();

        System.out.print("bd2="+bd2);
        System.out.print(",\tvalue="+bd2.unscaledValue()); // 전체 숫자
        System.out.print(",\tscale="+bd2.scale()); // 소수점 이하 자리수
        System.out.print(",\tprecision="+bd2.precision()); // 정수 자리수
        System.out.println();

        // 곱셈에서는 두 피연산자의 스케일값(소수점 이하 자리수) 을 더한다.
        BigDecimal bd3 = bd1.multiply(bd2);
        System.out.print("bd3="+bd3);
        System.out.print(",\tvalue="+bd3.unscaledValue()); // 전체 숫자
        System.out.print(",\tscale="+bd3.scale()); // 소수점 이하 자리수
        System.out.print(",\tprecision="+bd3.precision()); // 정수 자리수
        System.out.println();

        System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP));
        System.out.println(bd1.setScale(2, RoundingMode.HALF_UP));
        System.out.println(bd1.divide(bd2, new MathContext(2, RoundingMode.HALF_UP)));


    }


}
