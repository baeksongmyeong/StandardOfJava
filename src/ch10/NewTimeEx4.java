package ch10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/*
* Period : 날짜 차이
*          Period 의 static 메서드 between(Temporal, Temporal)
*          년도, 월, 일 필드를 각각 가지고 있다.
*          날짜 차이를 각 필드에 저장한다.
*          날짜 차이를 월단위로 환산해서 반환하는 메서드가 있다.
* Duration : 시간 차이
*            Duration 의 static 메서드 between(Temporal, Temporal)
*            초, 나노초 필드를 각각 가지고 있다.
*            시간 차이를 각 필드에 저장한다.
*            시간 차이를 일, 시, 분, 초, 밀리초, 나노초로 환산해서 반환하는 메서드가 있다.
* */
public class NewTimeEx4 {
    public static void main(String[] args) {

        // LocalDate 생성
        LocalDate date1 = LocalDate.of(2014, 1, 1);
        LocalDate date2 = LocalDate.of(2015, 12, 31);

        // Period 생성
        Period pe = Period.between(date1, date2);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println("Period = " + pe);

        // Period 에서 값 가져오기
        long year = pe.get(ChronoUnit.YEARS);
        long month = pe.get(ChronoUnit.MONTHS);
        long day = pe.get(ChronoUnit.DAYS);

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        // Periond 필드값을 다른 단위로 환산하여 가져오기
        long l = pe.toTotalMonths();
        System.out.println("toTotalMonths = " + l);

        // LocalTime 생성
        LocalTime time1 = LocalTime.of(0, 0, 0);
        LocalTime time2 = LocalTime.of(12, 34, 56);

        // Duration 생성
        Duration du = Duration.between(time1, time2);

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);
        System.out.println("du = " + du);

        // Duration 값 가져오기
        long seconds = du.getSeconds();

        // Duration 값으로 LocalTime 생성하기
        LocalTime tmpTime = LocalTime.of(0, 0, 0).plus(seconds, ChronoUnit.SECONDS);

        // LocalTime 값 가져오기
        int i = tmpTime.get(ChronoField.HOUR_OF_DAY);
        int i1 = tmpTime.get(ChronoField.MINUTE_OF_HOUR);
        int i2 = tmpTime.get(ChronoField.SECOND_OF_MINUTE);

        System.out.println("HOUR = " + i);
        System.out.println("MINUTE = " + i1);
        System.out.println("SECOND = " + i2);



        // Duration 필드값을 다른 단위로 환산하여 가져오기
        long l1 = du.toDays();
        long l2 = du.toHours();
        long l3 = du.toMinutes();
        long l4 = du.toSeconds();
        long l5 = du.toMillis();
        long l6 = du.toNanos();

        System.out.println("toDays = " + l1);
        System.out.println("toHours = " + l2);
        System.out.println("toMinutes = " + l3);
        System.out.println("toSeconds = " + l4);
        System.out.println("toMillis = " + l5);
        System.out.println("toNanos = " + l6);
    }
}
