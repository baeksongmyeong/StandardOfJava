package ch7;

/*
내부 클래스는 변수의 유형과 매우 비슷하다.
인스턴스 내부 클래스
static 내부 클래스
지역 내부 클래스
그 외로 익명 내부 클래스가 있다.

 */
public class InnerEx1 {

    // 인스턴스 내부 클래스
    class InstanceInner {
        int iv = 100;
        final static int CONST = 100;
        //static int cv = 100; // static 클래스만 static 변수를 가질수 있다.
    }

    // static 내부 클래스
    static class StaticInner {
        int iv = 200;
        static int cv = 200;
    }

    void myMethod(){

        // 지역 내부 클래스
        class LocalInner {
            int iv = 300;
            final static int CONST = 300;
            //static int cv = 300; // static 내부 클래스만 static 변수를 가질수 있다.
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST); // static 변수이므로 인스턴스 없이 참조 가능
        System.out.println(StaticInner.cv); // static 변수이므로 인스턴스 없이 참조 가능
    }
}
