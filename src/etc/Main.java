package etc;

import org.openjsse.util.RSAKeyUtil;

public class Main {
    public static void main(String[] args) {
        //new Single(); // new Class() : Single Class Load O
        //System.out.println(Single.a); // static variable : Single Class Load O
        //System.out.println(Single.b); // static final variable : Single Class Load X
        //Single.getInstance(); // static method : Single Class Load O
        System.out.println(Single.Inner.INSATACE); // static inner Class : Single Class Load X, Inner Class Load O
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
