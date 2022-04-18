package ch9;

/*
* 기본형 -> 래퍼클래스 타입 형변환이 가능
* 래퍼클래스 타입 -> 기본형 형변환이 가능
* 컴파일러가 래퍼클래스 타입간에도 사칙 연산자를 쓸 수 있도록 코딩 추가를 통해 연산을 가능케 함.
* 오토박싱 : 기본형 -> 래퍼클래스 타입 으로 자동 형변환 하도록 컴파일러가 코드를 추가하는 것
* 언박싱 : 래퍼클래스 타입 -> 기본형 으로 자동 형변환 하도록 컴파일러가 코드를 추가하는 것
* */
public class WrapperEx3 {
    public static void main(String[] args) {

        int i = 10;

        // 기본형을 래퍼클래스의 참조형으로 형변환
        Integer intg = (Integer) i;
        Object obj = (Object) i;
        Long lng = (Long) 100L;

        int i2 = intg + 10;  // 참조형과 기본형의 연산자를 통한 연산 가능 ( 참조형.intValue() + 10 의 형태 )
        long l = intg - lng; // 참조형간의 연산자를 통한 연산 가능

        Integer intg2 = new Integer(20);
        int i3 = (int) intg2; // 래퍼클래스의 참조형을 기본형으로 형변환
    }
}
