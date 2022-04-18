package ch9;

import java.util.Date;

/*
* String 클래스의 toString() 메서드는 값을 출력하도록 오버라이드 되어 있다.
* Date 클래스의 toString() 메서드는 값을 출력하도록 오버라이드 되어 있다.
* */

public class ToStringTest {
    public static void main(String[] args) {
        String str = new String("KOREA");
        Date today = new Date();

        System.out.println(str);
        System.out.println(str.toString());
        System.out.println(today);
        System.out.println(today.toString());
    }
}
