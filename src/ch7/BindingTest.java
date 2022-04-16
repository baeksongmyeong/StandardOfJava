package ch7;

/*
조상클래스와 자손클래스에 동일한 이름의 메서드, 변수가 선언되어 있고, 이를 각각 조상클래스 타입의 참조변수, 자손클래스 타입의 참조변수로 참조한 경우의 차이
- 메서드는 참조변수의 타입과 무관하게, 자손 인스턴스의 메서드를 참조
- 변수는 참조변수 타입에 따라 조상 또는 자손 인스턴스의 변수를 참조
 */

public class BindingTest {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.x);
        Parent parent = child;
        System.out.println(parent.x);
        child.method();
        parent.method();

    }
}

class Parent {

    // 멤버변수
    int x = 100;

    // 멤버메서드
    void method(){
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    // 멤버변수
    int x = 200;

    // 멤버메서드
    @Override
    void method(){
        System.out.println("Child Method");
    }
}
