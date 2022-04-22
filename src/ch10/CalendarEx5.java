package ch10;

import java.util.Calendar;
/*
* roll 메서드로 특정 필드 값 변경시 다른 필드에 영향을 안주지만, 예외가 있다.
* 일 필드가 말일로 되어있는데, 월 필드를 바꾸는 경우, 바꾸는 월의 말일로 일 필드가 자동 변환된다.
* 그리고나서는 월의 값을 다시 바꿔도, 말일로는 자동설정되지 않는다.
*
* ex) 2015.01.31 -> 1달 추가 -> 2015.02.28 -> 1달 추가 -> 2015.03.28
* */
public class CalendarEx5 {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();

        date.set(2015,0,31);
        System.out.println(toString(date));

        date.roll(Calendar.MONTH, 1);
        System.out.println(toString(date));

        date.roll(Calendar.MONTH, 1);
        System.out.println(toString(date));

    }

    public static String toString(Calendar c){
        return c.get(Calendar.YEAR) + "년 "
                + (c.get(Calendar.MONTH) + 1) + "월 "
                + c.get(Calendar.DATE) + "일 "
                ;
    }
}
