package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
* Calendar 를 Date 로 바꾸는 법
* Calendar 의 getTime() 메서드는 Date 타입 인스턴스를 반환해준다.
* 
* Date 를 Calendar 로 바꾸는 법
* Calendar 의 setTime(Date) 메서드는 Date 인스턴스의 값을 참조하여, Calendar 인스턴스를 만든다.
* */
public class DateFormatEx2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2005, 9, 3); // 10월

        // Calendar 의 값으로 Date 인스턴스 생성
        Date day = cal.getTime();

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(day));

        // Date 의 값으로 Calenda 인스턴스 생성
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(day);

    }
}
