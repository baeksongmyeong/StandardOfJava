package ch10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
* 문자열로 날짜, 시간 인스턴스를 생성할 때, DateTimeFormatter 인스턴스의 패턴을 사용하는 법
* 날짜/시간 클래스.parse( 문자열, DateTimeFormatter ) 의 형태로 문자열을 날짜/시간 인스턴스로 변경할 수 있다.
* */
public class DateFormatterEx2 {
    public static void main(String[] args) {

        // 원본 문자열
        String sDate = "2016-01-01";

        // 원본 문자열과 매치되는 문자열 패턴
        String pattern = "yyyy-MM-dd"; // DateTimeFormatter.ISO_LOCAL_DATE

        // 문자열 패턴으로 DateTimeFormatter 생성
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        // LocalDate 의 parse() 메서드로 문자열을 읽어 LocalDate 인스턴스 생성
        LocalDate newYear = LocalDate.parse(sDate, dateTimeFormatter);

        // parse() 사용시 포맷이 미지정된 경우, 기본 포맷이 적용된다.
        LocalDate date = LocalDate.parse("2001-01-01");
        LocalTime time = LocalTime.parse("23:59:59");
        LocalDateTime dateTime  = LocalDateTime.parse("2001-01-01T23:59:59");
        //LocalDateTime dateTime1 = LocalDateTime.parse("2001-01-01 23:56:59"); // 시간앞에 T 가 없으면 오류 발생

        System.out.println("newYear = " + newYear);
        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);
        //System.out.println("dateTime1 = " + dateTime1);
    }
}
