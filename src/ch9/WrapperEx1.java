package ch9;

/*
* 래퍼 클래스는 기본형 타입을 클래스로 다루어야 할 때 사용하는 클래스이다.
* 각 래퍼 클래스는 자신이 다루는 기본형 타입의 변수를 내부에 가지고 있어서, 그 안에 데이터를 저장한다.
* 래퍼 클래스는 생성자로 자신이 다루는 기본형 타입 외에 문자열도 추가로 지원한다.
* 래퍼 클래스의 equals() 메서드는 주소가 아닌 값을 비교하도록 오버라이드 되어 있다.
* */
public class WrapperEx1 {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Integer i2 = new Integer(100);

        System.out.println("i == i2 ? " + (i == i2));
        System.out.println("i.equals(i2) ? " + i.equals(i2));
        System.out.println("i.compareTo(i2)=" + i.compareTo(i2)); // 값이 같으면 0 반환
        System.out.println("i.toString()=" + i.toString());

        System.out.println("Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE=" + Integer.SIZE + "bits"); // 래퍼 클래스의 저장공간의 총 bit
        System.out.println("Integer.BYTES=" + Integer.BYTES + "bytes"); // 래퍼 클래스의 저장공간의 총 byte
        System.out.println("Integer.TYPE=" + Integer.TYPE); // 래퍼 클래스가 다루는 기본타입
    }
}