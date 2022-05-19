package ch14;

/*
* 람다식
*   - 문장이 아닌 식으로 표현
*   - 하나의 메서드를 포함하는 익명 객체이다.
*
* 메서드를 람다식으로 변환
*   1. 선언부에서 반환타입과 메서드명을 제거
*   2. 매개변수의 타입 제거
*       - 추론이 가능한 경우만 가능
*   3. 매개변수의 괄호 제거
*       - 매개변수가 1개인 경우만 가능
*       - 매개변수의 타입을 기술하지 않는 경우만 가능
*   4. 구현부의 괄호 제거
*        - 문장이 1개인 경우만 가능
*       - 문장이 1개라도 return 문장이면 불가능
*   5. return 예약어 제거
*       - return 예약어를 제거하고, 식만 남겨놓을수 있음
*       - return 예약어 제거시, 문장이 아니라 식이 되므로, 문장의 끝을 알리는 ';' 제거
*
* 람다식과 함수형 인터페이스
*   - 함수형 인터페이스 : 추상 메서드를 한개만 가지는 인터페이스
*                      람다식을 다루기위한 인터페이스
*   - 람다식도 하나의 메서드를 구현한 익명객체. 이는 곧 함수형 인터페이스를 구현한 객체의 모습과 동일
*   - 따라서, 함수형 인터페이스의 구현 객체를 람다식(익명객체)으로 대체하는 것이 가능
*   - 이 때, 람다식의 구현부는 함수형 인터페이스의 추상메서드의 구현부로 인식된다.
*
* */

/*---------------------------------
함수형 인터페이스 선언
추상 메서드명 run()
인터페이스 내 모든 메서드는 public abstract 로 접근자가 설정되어야 하며, 이는 당연한 것이므로 생략할 수 있다.
@FunctionalInterface 를 넣으면, 이 인터페이스를 함수형 인터페이스로 인식하게 하는 것이며(추상 메서드가 1개), 이를 구현하는 코드가 있을경우, 해당 코드가 정상적인지 컴파일러가 확인해준다.
---------------------------------*/
interface MyFunction1 {
    void run();
}

public class LambdaEx1 {

    // 함수형 인터페이스의 구현체를 매개변수로 사용하는 메서드 선언
    // MyFunction 함수형 인터페이스의 구현체를 매개변수로 받는 것이다.
    static void execute(MyFunction1 f) {f.run();}

    // 함수형 인터페이스의 구현체를 반환타입으로 사용
    // MyFunction 함수형 인터페이스의 구현체를 반환하는 것이다.
    static MyFunction1 getMyFunction() {

        // 인터페이스의 구현부를 가지는 익명 객체를 생성해서 반환하는 방법
//        MyFunction f =  new MyFunction(){
//            @Override
//            public void run() {System.out.println("f3.run()");}
//        };

        // 람다식을 이용한 익명 객체를 생성해서 반환하는 방법
        MyFunction1 f = () -> System.out.println("f3.run()");

        return f;
    }

    public static void main(String[] args) {
        
        // 함수형 인터페이스의 구현 객체를 람다식을 통해 생성
        MyFunction1 f1 = () -> System.out.println("f1.run()");

        // 함수형 인터페이스의 구현 객체를 익명 객체를 통해 생성
        MyFunction1 f2 = new MyFunction1() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        // 메서드의 반환타입이 함수형 인터페이스의 구현 객체(람다식을 이용해서 객체 생성)인 것을 호출
        MyFunction1 f3 = getMyFunction();

        // 각 합수형 인터페이스의 구현 객체의 메서드 실행
        f1.run();
        f2.run();
        f3.run();

        // 메서드의 매개변수로 함수형 인터페이스의 구현 객체를 입력
        execute(f1);

        // 메서드의 매개변수로 람다식을 입력
        execute(()-> System.out.println("run()"));
    }
}
