package ch14;

/*
* 람다식 외부에 선언된 변수를 람다식에서 참조하기
*
*   - 참조 가능
*   - 하지만 참조되는 변수들은 람다식 내에서만이 아니라, 프로그램 전체에서 상수로 관리된다. (final 예약어가 없더라도 상수로 관리)
*   - 람다식의 매개변수명으로 외부 변수와 동일한 이름을 사용할 수 없다.
* */

/*---------------------------------
함수형 인터페이스 선언
---------------------------------*/
@FunctionalInterface
interface MyFunction3 {
    public abstract void myMethod();
}

/*---------------------------------
외부 클래스 및 내부 클래스 선언
---------------------------------*/
class Outer {

    int val = 10;

    class Inner {

        int val = 20;

        void method(int i) {
            int val = 30;

            // 람다식에서 참조되는 외부 변수는 상수로 간주되므로, 값을 변경할 수 없다.
            //i = 10;

            // 람다식으로 생성된 익명 객체를 함수형 인터페이스 타입으로 참조
            MyFunction3 f = ()->{
                // 외부변수 참조
                System.out.printf("%10s%n", i  ); // 입력값
                System.out.printf("%10s%n", val); // 30
                System.out.printf("%10s%n", ++this.val); // 21
                System.out.printf("%10s%n", ++Outer.this.val); // 11
            };

            // 람다식으로 생성된 익명 객체의 메서드(람다식)을 실행
            f.myMethod();

        }

    }

}


public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}
