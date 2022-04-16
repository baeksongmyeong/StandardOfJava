package ch7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/mm/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat time2 = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat time3 = new SimpleDateFormat("HH:mm:ss");
        System.out.printf("오늘 날짜는 %s%n", date.format(today));
        System.out.printf("현재 시간은 %s%n", time.format(today));
        System.out.printf("현재 시간은 %s%n", time2.format(today));
        System.out.printf("현재 시간은 %s%n", time3.format(today));
    }
}
