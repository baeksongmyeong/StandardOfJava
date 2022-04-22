package ch10;

import java.util.Calendar;

/*
* Calendar 인스턴스에 값을 더하거나 빼는 2개의 메서드
* add()
* roll()
*
* roll() 은 특정 필드 변경시, 다른 필드에는 영향을 안주므로, 사용시 주의가 필요하다.
* */
public class CalendarEx4 {

    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();

        // 8월로 설정
        date.set(2015, 7, 31);

        System.out.println(toString(date));

        // 하루 추가
        date.add(Calendar.DATE, 1);
        System.out.println(toString(date));

        // 6달전
        date.add(Calendar.MONTH, -6);
        System.out.println(toString(date));

        // 31일 후(roll)
        date.roll(Calendar.DATE, 31);
        System.out.println(toString(date));

        date.add(Calendar.DATE, 31);
        System.out.println(toString(date));
    }

    public static String toString(Calendar c){
        return c.get(Calendar.YEAR) + "년 "
                + (c.get(Calendar.MONTH) + 1) + "월 "
                + c.get(Calendar.DATE) + "일 "
                ;
    }
}
