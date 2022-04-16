package etc;

/*
클래스의 로딩 시점을 알아본다.

1. new 로 클래스 접근시 로딩됨.  new 클래스
2. 클래스 변수 접근시 로딩됨.    static 변수
3. 클래스 상수 접근시 로딩 안됨. static final 변수
4. 클래스 메서드 접근시 로딩됨.  static 메서드
5. 내부 static 클래스에 접근시에는 내부 클래스만 로딩되고 외부 클래스는 로딩 안됨.
 */

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //new Single(); // new Class() : Single Class Load O
        //System.out.println(Single.a); // static variable : Single Class Load O
        //System.out.println(Single.b); // static final variable : Single Class Load X
        //Single.getInstance(); // static method : Single Class Load O
        System.out.println(Single.Inner.INSATACE); // static inner Class : Single Class Load X, Inner Class Load O
        Date d = new Date();
    }
}

class Single {
    public Single(){}
    public static int a;
    public static final int b = 0;
    public static void getInstance(){}
    public static class Inner {
        public static Single INSATACE;
    }
}
