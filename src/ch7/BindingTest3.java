package ch7;

/*
조상과 중복된 멤버변수를 가지는 자손클래스를 인스턴스 화 한 경우,
super 를 통해서 조상의 멤버변수값을 가져올 수 있다.
 */

public class BindingTest3 {
    public static void main(String[] args) {
        Parent2 p = new Child2();
        Child2 c = new Child2();

        System.out.println("p.x=" + p.x); // 100 이 나올듯
        p.method(); // 오버라이딩 된 메서드 호출
        System.out.println();
        System.out.println("c.x=" + c.x); // 200 이 나올듯
        c.method();
    }
}

class Parent2 {
    int x = 100;
    void method(){
        System.out.println("Parent Method");
    }
}

class Child2 extends Parent2 {
    int x = 200; // 조상과 중복된 멤버변수
    void method(){ // 조상과 중복된 멤버메서드
        System.out.println("x=" + x); // 200 이 나올듯
        System.out.println("super.x=" + super.x); // 100 이 나올듯
        System.out.println("this.x=" + this.x); // 200 이 나올듯
    }
}
