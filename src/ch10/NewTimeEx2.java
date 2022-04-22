package ch10;

import java.time.*;

/*
* LocalDate + LocalTime = LocalDateTime 클래스
* LocalDate + LocalTime + TimeZone(시간대) = ZonedDateTim 클래스
*
* LocalDateTime 의 생성
* now(), of()
*
* LocalDateTime 과 LocalDate, LocalTime 간으 변환 가능
* toLocalDate(), toLocalTime()
* 
* */
public class NewTimeEx2 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2015, 12, 13);
        LocalTime time = LocalTime.of(12, 34, 56);

        // LocalDateTime 생성 : of()
        LocalDateTime dt = LocalDateTime.of(date, time);
        System.out.println("dt = " + dt);

        // ZoneId 생성 : of()
        ZoneId zid = ZoneId.of("Asia/Seoul");
        System.out.println("zid = " + zid);

        // ZonedDateTime 생성 : LocalDateTime 에 ZoneId 를 추가
        ZonedDateTime zdt = dt.atZone(zid);
        System.out.println("zdt = " + zdt);

        // ZonedDateTime 생성 : now()
        ZonedDateTime seoulTime = ZonedDateTime.now();
        System.out.println("seoulTime = " + seoulTime);

        // ZoneId 생성 : of()
        ZoneId nyId = ZoneId.of("America/New_York");
        
        // ZonedDateTime 생성 : now() + with()
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
        System.out.println("nyTime = " + nyTime);

        // OffDateTime 생성 : toOffsetDateTime()
        OffsetDateTime odt = zdt.toOffsetDateTime();
        System.out.println("odt = " + odt);
    }
}
