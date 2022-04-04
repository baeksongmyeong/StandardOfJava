package ch2;

public class FloatEx1 {
    public static void main(String[] args) {
        float f = 9.12345678901234567890f;
        float f2 = 1.234567891234567890f;
        double d = 9.12345678901234567890d;

        System.out.printf("         12345678901234567890%n");
        System.out.printf("f  :   %f%n", f); // %f 로 실수 출력. 소수점 7자리에서 반올림
        System.out.printf("f  : %24.20f%n", f); // % 전체길이.소수점길이 f
        System.out.printf("f2 : %24.20f%n", f2);
        System.out.printf("d  : %24.20f%n", d); // float 과 double 의 정밀도 차이
    }
}
