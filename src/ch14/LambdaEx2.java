package ch14;

/*
* 람다식의 타입과 형변환
*
*   - 함수형 인터페이스 타입이 람다식 자체를 의미할 수는 없다.
*   - 람다식은 람다식 자체의 타입을 가지며, 이는 컴파일러가 임의로 지정하기에 타입을 알수는 없다.
*   - 따라서 원래는 람다식으로 생성되는 익명 객체를 함수형 인터페이스의 타입으로 참조하려면 형변환이 필요하다.
*        - Myfunction f = (MyFunction) () -> System.out.println("형변환");
*   - 하지만, 위 형변환은 생략이 가능하다.
*   - 그리고, 람다식은 익명 객체이지만 모든 클래스의 조상인 Object 타입으로의 직접적인 형변환은 막아놨다.
*   - 오직 함수형 인터페이스 타입으로만 형변환이 가능하다.
*   - Object 타입으로 형변환하고 싶다면, 먼저 함수형 인터페이스의 타입으로 형변환 한 후에, Object 타입으로 형변환 할 수는 있다.
*
* */

/*---------------------------------
함수형 인터페이스 선언
---------------------------------*/
@FunctionalInterface
interface MyFunction2 {
    public abstract void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        
        // 함수형 인터페이스의 구현 객체를 람다식으로 생성
        MyFunction2 f = ()->{};

        // 람다식을 함수형 인터페이스로 형변환 한 후에, Object 타입으로 참조
        Object obj = (Object) ((MyFunction2)()->{});
        
        // 람다식을 함수형 인터페이스로 형변환 한 후에, Object 타입으로 형변환하고, String 타입으로 참조
        String str = ((Object)((MyFunction2)()->{})).toString();

        // 익명 객체가 아닌, 일반적인 객체의 타입 출력
        // 클래스명 @ 주소
        System.out.println(new LambdaEx2());

        // 일반적인 익명 객체의 타입 출력
        // 클래스명 $ 번호 @ 주소
        MyFunction2 f2 = new MyFunction2() {@Override public void myMethod() { /* 구현부 */}};
        System.out.println(f2);

        // 각 람다식을 이용해서 생성된 인스턴스 출력
        // 클래스명 $$ Lambda $ 번호 / ~~~ @ 주소
        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        // 람다식은 익명객체이지만 Object 타입으로 형변환하여 참조가 안된다는 예이다.
        // 람다식을 함수형 인터페이스로 형변환하면, 모든 클래스와 인터페이스의 조상인 Object 타입으로 참조를 할 수 있다.
        //System.out.println(()->{}); // 컴파일 에러 발생
        System.out.println((MyFunction2)()->{});
    }
}
