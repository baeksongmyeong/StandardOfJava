package ch10;

import java.util.Calendar;

/*
* Calendar 의 주의사항
* 월은 0 ~ 11 이다. 값 조회 및 설정할 때 주의 필요
* 요일은 1 ~ 7 이며, 1 은 일요일이다.
* 두 날짜간의 계산은 각 날짜의 밀리세컨값을 가져온 후 처리하면 된다. ( getTimeInMillis() )
* */
public class CalendarEx2 {
    public static void main(String[] args) {

        // 요일은 1부터 시작하기 때문에 배열의 0 번째 요소는 비워뒀음.
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // 월은 0 ~ 11 이므로, 값을 설정할 때, 한달을 빼야 한다.
        date1.set(2015, 7, 15); // 시간은 현재 시간을 따르며, 값을 참조시 현재 시간과 동기화 된 값이 반환된다.
        System.out.println("date1은 "
                + calToString(date1)
                + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]
                + "요일입니다."
        );
        System.out.println("오늘은 "
                + calToString(date2)
                + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]
                + "요일입니다."
        );
        
        // 두 날짜사이의 차이를 밀리세컨 ( 1 / 1000 초 ) 로 계산
        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();
        System.out.println(diff);
        // 초 차이로 변환 (버림 발생)
        diff /= 1000;
        System.out.println(diff);
        // 분 차이로 변환
        diff /= 60;
        System.out.println(diff);
        // 시 차이로 변환
        diff /= 60;
        System.out.println(diff);
        // 일 차이로 변환
        diff /= 24;
        System.out.println(diff);
        // 년 차이로 변환
        diff /= 365;
        System.out.println(diff);


    }

    static String calToString(Calendar c){
        return c.get(Calendar.YEAR) + "년 "
                + (c.get(Calendar.MONTH) + 1) + "월 "
                + c.get(Calendar.DATE) + "일 "
                ;
    }
}
