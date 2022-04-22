package ch10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ValueRange;

/*
* 날짜와 시간을 다루는 클래스가 추가되었다.
* 날짜 : LocalDate
* 시간 : LocalTime
*
* 인스턴스 생성
* .now()
* .of()
*
* 값 가져오기
* get(), getXXX()
*
* 값 변경
* with(), withXXX()
*
* 값 더하기, 값 빼기
* plus(), plusXXX()
*
* 값 비교
* isAfter()
* isBefore()
* isEqual()
*
* 지정된 필드 하위는 0 으로 초기화
* truncatedTo()
* */
public class NewTimeEx1 {
    public static void main(String[] args) {

        // LocalDate, LocalTime 의 인스턴스 생성 : now()
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        // LocalDate, LocalTime 의 인스턴스 생성 : of()
        LocalDate birthDate = LocalDate.of(1999, 12, 31); // 1999-12-31
        LocalTime birthTime = LocalTime.of(23, 59, 50);      // 23:59:50

        // toString
        System.out.println("today = " + today);
        System.out.println("now = " + now);
        System.out.println("birthDate = " + birthDate);
        System.out.println("birthTime = " + birthTime);

        // 값을 변경하는 with()
        LocalDate d1 = birthDate.withYear(2000);// 2000-12-31
        System.out.println("birthDate.withYear(2000) = " + d1);

        // 값을 더하는 plus()
        LocalDate d2 = birthDate.plusDays(1);// 2000-01-01
        System.out.println("birthDate.plusDays(1) = " + d2);

        // 값을 더하는 plus()
        LocalDate d3 = birthDate.plus(1, ChronoUnit.DAYS);
        System.out.println("birthDate.plus(1, ChronoUnit.DAYS) = " + d3);

        // 지정한 단위 이후는 0 으로 반드는 truncatedTo()
        LocalTime d4 = birthTime.truncatedTo(ChronoUnit.HOURS);
        System.out.println("birthTime.truncatedTo(ChronoUnit.HOURS) = " + d4);

        // ChronoField 필드의 범위를 확인하는 range()
        ValueRange range1 = ChronoField.CLOCK_HOUR_OF_DAY.range();
        System.out.println("ChronoField.CLOCK_HOUR_OF_DAY.range() = " + range1);

        ValueRange range2 = ChronoField.HOUR_OF_DAY.range();
        System.out.println("ChronoField.HOUR_OF_DAY.range() = " + range2);

        // 값을 비교하는 isAfter(), isBefore(), isEqual()
        boolean after = birthDate.isAfter(today);
        System.out.println("birthDate.isAfter(today) = " + after);
        boolean before = birthDate.isBefore(today);
        System.out.println("birthDate.isBefore(today) = " + before);
        boolean equal = birthDate.isEqual(today);
        System.out.println("birthDate.isEqual(today) = " + equal);
    }
}
