package ch10;

public class CalendarEx8 {
    public static void main(String[] args) {
        String date1 = "201508";
        String date2 = "201405";

        // 연도는 12 를 곱하면 연도를 구성하는 총 개월수를 알 수 있다.
        int month1 = Integer.parseInt(date1.substring(0, 4)) * 12
                + Integer.parseInt(date1.substring(4));

        int month2 = Integer.parseInt(date2.substring(0,4)) * 12
                + Integer.parseInt(date2.substring(4));

        // 개월수 차이를 계산한다.
        System.out.println("개월수 차 : " + Math.abs(month1 - month2));
    }
}
