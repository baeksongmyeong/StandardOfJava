package ch7;

/*
익명 클래스를 선언하는 방법
- 클래스를 인스턴스화 하면서, 클래스 내부를 구현하는 코드도 넣고 있다.
 */
public class InnerEx6 {

    Object obj          = new Object();                      // 이게 보통 인스턴스를 만드는 방법
    Object iv           = new Object() { void method() {} }; // 인스턴스를 생성하면서, 그 안에 멤버를 정의하고 있다.
    static Object cv    = new Object() { void method() {} };
    void myMethod(){
        Object lv = new Object() { void method() {} };
    }

    public static void main(String[] args) {

    }

}
