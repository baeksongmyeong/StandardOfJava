package ch9;

/*
* StringBuffer 클래스는 내부에 char 배열이 있으며, 값을 변경할 수 있다.
* equals() 메서드가 오버라이드 되어 있지 않아, 참조변수에 저장된 주소값을 비교할 뿐이며, 저장된 문자배열의 값을 비교할 수 없다.
* toString() 메서드는 오버라이드 되어 있어, char 배열의 값들을 조합하여, String 인스턴스로 반환한다.
* 따라서 StringBuffer 인스턴스간 값 비교를 위해서는, 각 인스턴스들을 toString() 하여, String 인스턴스들로 값을 가져온 후, equals() 메서드로 비교해야 한다.
* String 클래스의 equals() 메서드는 값을 비교하도록 오버라이드 되어 있기 때문에 이렇게 처리하는 것이 가능하다.
* */

public class StringBufferEx1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("==     : " + (sb == sb2));
        System.out.println("equals : " + sb.equals(sb2));
        System.out.println("toString 후 equals : " + sb.toString().equals(sb2.toString()));

    }
}
