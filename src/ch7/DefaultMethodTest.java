package ch7;

/*
인터페이스에 static 메서드 추가 가능
인터페이스에 default 메서드 추가 가능
둘 다 구현부를 가진다.
인터페이스에 신규 메서드 추가시, 추상 클래스가 아닌 default 메서드로 추가하면, 이 인터페이스를 구현했던 클래스들은 해당 메서드를 오버라이드 하지 않아도 오류가 발생하지 않는다.
추상클래스로 추가했다면, 반드시 오버라이드해야 한다.
인터페이스의 default 메서드가 조상 클래스의 메서드와 선언부가 중복된다면, 인터페이스의 default 메서드는 무시된다.
인터페이스들을 다중 구현시, 각 인터페이스의 default 메서드의 선언부가 중복된다면, 구현하는 클래스에서 오버라이드를 해서 메서드 내용을 정의해야 한다.
 */

public class DefaultMethodTest {
    public static void main(String[] args) {
        Child3 c = new Child3();
        c.method1();
        c.method2(); // 조상 클래스가 인터페이스보다 우선된다.
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}

class Child3 extends Parent3 implements MyInterface, MyInterface2 {

    // 인터페이스간 중복되는 default 메서드는 오버라이드 해서 처리해야 한다.
    @Override
    public void method1(){ System.out.println("method1() in Child"); }
}

class Parent3 {
    public void method2(){ System.out.println("method2() in Parent"); }
}

interface MyInterface {
    // default 메서드
    public default void method1(){ System.out.println("method1() in MyInterface"); } // 인터페이스간 중복되는 default 메서드
    public default void method2(){ System.out.println("method2() in MyInterface"); } // 조상 클래스의 인스턴스 메서드와 중복되므로, 이 메서드는 무시된다.
    // static 메서드
    public static void staticMethod(){ System.out.println("staticMethod() in MyInterface"); }
}

interface MyInterface2 {
    // default 메서드
    public default void method1(){ System.out.println("method1() in MyInterface2"); } // 인터페이스간 중복되는 default 메서드
    // static 메서드
    public static void staticMethod(){ System.out.println("staticMethod() in MyInterface2"); } // static 메서드는 인터페이스명으로 구분이 되므로, 중복이 발생하지 않는다.
}