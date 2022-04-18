package ch7;

class Outer1 {

    // 외부클래스의 인스턴스 멤버 변수
    int value = 10;

    // 외부 클래스의 인스턴스 내부 클래스
    class Inner {

        // 인스턴스 멤버 변수
        int value = 20;

        // 인스턴스 멤버 메서드
        void method1(){
            int value = 30;
            System.out.println(value); // 지역변수 30
            System.out.println(this.value); // 내부 클래스 인스턴스 변수 20
            System.out.println(Outer1.this.value); // 외부 클래스 인스턴스 변수 10
        }

    }

}

public class InnerEx5 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner inner = outer.new Inner();
        inner.method1();
    }
}
