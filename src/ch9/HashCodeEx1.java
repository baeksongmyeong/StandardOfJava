package ch9;

/*
* String 클래스는 값이 같은 경우 equals() 메서드는 true 를 반환하도록, hashCode() 메서드는 동일한 값을 반환하도록 오버라이딩 되어있다.
* String 클래스의 인스턴스를 생성할 때, new 연산자를 사용하는 것과, 리터럴을 사용하는 것은 차이가 있다.
* 리터럴을 사용하는 경우, 동일한 리터럴을 사용한 String 타입 참조변수들은 리터럴의 주소를 가리키므로, 동일한 인스턴스를 참조하게 된다.
* new 연산자를 사용하는 경우, String 타입 참조변수들은 각기 다른 String 인스턴스들의 주소를 가리키므로, 서로 다른 인스턴스를 참조하게 된다.
* */

public class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode() == str2.hashCode());
        System.out.println(System.identityHashCode(str1) == System.identityHashCode(str2));

        System.out.println();

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));
        System.out.println(str3.hashCode() == str4.hashCode());
        System.out.println(System.identityHashCode(str3) == System.identityHashCode(str4));
    }
}
