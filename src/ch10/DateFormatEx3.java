package ch10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* SimpleDateFormat 의 패턴을 이용하여 문자열을 역으로 Date 인스턴스로 변환하는 방법
* SimpleDateFromat 의 인스턴스 메서드인 parse(String) 으로 패턴과 일치하는 문자열을 Date 인스턴스로 변환할 수 있다.
* */
public class DateFormatEx3 {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date d = df.parse("2015년 11월 23일");
            System.out.println(df2.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
