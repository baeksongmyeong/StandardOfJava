package ch6;

public class MyMathTest {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long add = mm.add(5L, 3L);
        long subtract = mm.subtract(5L, 3L);
        long multiply = mm.multiply(5L, 3L);
        double divide = mm.divide(5L, 3L); // long 타입 인자를 넘겨도 메서드의 매개변수 타입인 double 로 자동형변환이 됨.

        System.out.println(add);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
    }
}

class MyMath {
    // 클래스 변수
    // 인스턴스 변수
    // 클래스 메서드
    // 인스턴스 메서드
    long add(long a, long b) { return a + b; }
    long subtract(long a, long b) { return a - b; }
    long multiply(long a, long b) { return a * b; }
    double divide(double a, double b) { return a / b; }
}
