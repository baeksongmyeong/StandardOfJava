package ch10;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/*
* DateTimeFormatter 클래스 : 날짜, 시간 객체를 문자열로 변환할때 포맷을 지정할수 있는 클래스
* ofPatter()
* format()
* parse()
* */
public class DateTimeFormatterEx1 {
    public static void main(String[] args) {

        ZonedDateTime zdateTime = ZonedDateTime.now();
        System.out.printf("%30s -> %20s", "원본일시", zdateTime);

        // 패턴용 문자열 배열
        String[] patterns = {
                "yyyy-MM-dd HH:mm:ss",
                "''yy년 MMM dd일 E요일",
                "yyyy-MM-dd HH:mm:ss.SSS Z VV",
                "yyyy-MM-dd hh:mm:ss a",
                "오늘은 올 해의 D 번째 날입니다.",
                "오늘은 이 달의 d 번째 날입니다.",
                "오늘은 올 해의 w 번째 주입니다.",
                "오늘은 이 달의 W 번째 날입니다.",
                "오늘은 이 달의 W 번째 E 요입니다.",
        };
    
        // 문자열을 날짜패턴 클래스에 적용 후 날짜 객체를 패턴에 맞춰 출력
        for (String pattern : patterns) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            String fDate = zdateTime.format(dtf);
            System.out.printf("%-30s -> %-30s%n", pattern, fDate.toString());
        }

        // DateTimeFormatter 에도 format() 메서드가 있다.
        String date = DateTimeFormatter.ofPattern("yyyy / MM / dd").format(zdateTime);
        System.out.println("date = " + date);

        // 패턴은 DateTimeFormatter 에 정의된 열겨형을 사용해도 된다.
        System.out.println("ISO_DATE_TIME : " + DateTimeFormatter.ISO_DATE_TIME.format(zdateTime));
        System.out.println("ISO_LOCAL_DATE : " + DateTimeFormatter.ISO_LOCAL_DATE.format(zdateTime));
        System.out.println("ISO_DATE : " + DateTimeFormatter.ISO_DATE.format(zdateTime));
        System.out.println("BASIC_ISO_DATE : " + DateTimeFormatter.BASIC_ISO_DATE.format(zdateTime));
        System.out.println("ISO_TIME : " + DateTimeFormatter.ISO_TIME.format(zdateTime));
    }
}
