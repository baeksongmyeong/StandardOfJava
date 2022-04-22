package ch10;

import java.text.*;
import java.util.*;

public class DateFormatEx4 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Scanner s = new Scanner(System.in);
        Date inDate = null;

        System.out.println("날짜를 " + pattern + " 의 형태로 입력해주세요");

        // 입력이 되면 true, 안되면 false 이다.
        while(s.hasNextLine()){
            try {
                inDate = df.parse(s.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("다시 입력해주세요");
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);

        Calendar today = Calendar.getInstance();

        long time = (cal.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60;

        System.out.printf("입력하신 날짜는 현재와 %d 시간 차이가 있습니다.", time);
    }
}
