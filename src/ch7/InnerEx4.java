package ch7;

class Outer {

    // Outer 클래스의 인스턴스 멤버이자 인스턴스 내부 클래스
    class InstanceInner {
        int iv = 100;
    }

    // Outer 클래스의 static 멤버이자 static 내부 클래스
    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    void myMethod(){
        // Outer 클래스의 지역 내부 클래스
        class LocalInner {
            int iv = 400;
        }
    }

}

public class InnerEx4 {
    public static void main(String[] args) {
        // 인스턴스 내부 클래스의 인스턴스를 생성하려면, 외부 클래스의 인스턴스를 먼저 생성해야 한다.
        //new InstanceInner(); // 직접 인스턴스 내부 클래스의 인스턴스를 생성할 수 없다.
        Outer oc = new Outer();
        Outer.InstanceInner ii = oc.new InstanceInner();

        System.out.println(ii.iv);
        
        // static 내부 클래스는 외부클래스.내부클래스.static멤버 형태로 접근이 가능하다.
        System.out.println(Outer.StaticInner.cv);

        // static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println(si.iv);
    }
}
