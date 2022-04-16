package ch7;

/*
인터페이스의 본질적인 이해
클래스를 제공하는 쪽, 사용하는 쪽이 존재
메서드를 사용하는 쪽은 메서드의 선언부만 알면되고, 구현부는 몰라도 된다.
 */

class A {
    public void methodA(B b){
        b.methodB();
    }
}

class B {
    public void methodB(){
        System.out.println("methodB()");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new B());
    }
}
