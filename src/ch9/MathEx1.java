package ch9;

import static java.lang.Math.*;

/*
* Math 클래스는 static 메서드로 구성되어 있음.
* 생성자가 private 라서 다른 클래스는 Math 클래스의 인스턴스를 생성하지 못함
* 반올림 : round() : 소수점 첫째자리에서 반올림 및 정수 반환
*         rint()  : 소수점 첫째자리에서 반올림 및 실수 반환 ( 가장 가까운 짝수 정수를 반환한다. )
* 올림 : ceil() : 실수 반환
* 내림 : floor() : 실수 반환
* */
public class MathEx1 {
    public static void main(String[] args) {
        double val = 90.7552;
        System.out.printf("round(%f)=%d%n",val, round(val));
        val *= 100;
        System.out.printf("round(%f)=%d%n",val, round(val));

        System.out.printf("round(%f)/100=%d%n",val, round(val)/100); // 정수형으로 나눈 경우, 정수 반환
        System.out.printf("round(%f)/100.0=%f%n",val, round(val)/100.0); // 실수형으로 나눈 경우, 실수 반환

        System.out.printf("ceil(%3.1f)=%3.1f%n",1.1, ceil(1.1)); // 올림
        System.out.printf("floor(%3.1f)=%3.1f%n",1.1, floor(1.1)); // 내림(버림)

        System.out.printf("round(%3.1f)=%d%n",1.1, round(1.1)); // 반올림
        System.out.printf("round(%3.1f)=%d%n",1.5, round(1.5)); // 반올림
        System.out.printf("rint(%3.1f)=%f%n",1.5, rint(1.5)); // 반올림
        System.out.printf("round(%3.1f)=%d%n",-1.5, round(-1.5)); // 반올림
        System.out.printf("rint(%3.1f)=%f%n",-1.5, rint(-1.5)); // 반올림 -> -1.5 와 가장 가까운 정수값이 2개이다. (-1 과 -2). 이 중 짝수를 반환하게 되어 있다.
        System.out.printf("ceil(%3.1f)=%f%n",-1.5, ceil(-1.5)); // 반올림
        System.out.printf("floor(%3.1f)=%3.1f%n",-1.5, floor(-1.5)); // 내림(버림)
    }
}
