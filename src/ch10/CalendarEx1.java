package ch10;

import java.util.Calendar;

/*
* 자바에서 날짜와 시간을 다루기 위해 제공하는 클래스들
* Date 클래스는 1.0 부터 제공
* Calendar 클래스는 1.1 부터 제공
* java.time 패키지 내에 클래스들은 1.8 부터 제공
* 
* Date 는 성능 조악
* Date 와 Calendar 간 변환가능
* 
* Calendar 클래스는 추상클래스. 직접 new 불가. static getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 인스턴스를 받아야 함
* 
* Calendar 인스턴스의 각 멤버변수에 대한 값은 get(int) 메서드로 가져올 수 있음
* 여기서 int 값은 Calendar 클래스내에서 상수로 제공되고 있음
* */
public class CalendarEx1 {
    public static void main(String[] args) {

        // Calendar 클래스는 추상클래스이므로 인스턴스를 직접 생성할 수 없다.
        //new Calendar();

        // 생성자가 아닌 static 메서드로 Calendar 클래스를 구현한 인스턴스를 참조한다.
        // 기본적으로 현재 시간으로 멤버변수가 설정된 인스턴스가 반환된다.
        Calendar today = Calendar.getInstance();

        System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR)); // 1
        System.out.println("월(0~11) : " + today.get(Calendar.MONTH)); // 2
        System.out.println("이 해의 몇째 주 : " + today.get(Calendar.WEEK_OF_YEAR)); // 3
        System.out.println("이 달의 몇째 주 : " + today.get(Calendar.WEEK_OF_MONTH)); // 4
        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DATE)); // 5
        System.out.println("이 달의 몇 일 : " + today.get(Calendar.DAY_OF_MONTH)); // 5
        System.out.println("이 해의 몇 일 : " + today.get(Calendar.DAY_OF_YEAR)); // 6
        System.out.println("요일 (1:일요일) : " + today.get(Calendar.DAY_OF_WEEK)); // 7
        System.out.println("이 달의 몇째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 8
        System.out.println("오전/오후 (0:오전/1:오후) : " + today.get(Calendar.AM_PM)); // 9
        System.out.println("시간 (0~11) : " + today.get(Calendar.HOUR)); // 10
        System.out.println("시간 (0~23) : " + today.get(Calendar.HOUR_OF_DAY)); // 11
        System.out.println("분 (0~59) : " + today.get(Calendar.MINUTE)); // 12
        System.out.println("초 (0~59) : " + today.get(Calendar.SECOND)); // 13
        System.out.println("1000분의 1초 (0~999) : " + today.get(Calendar.MILLISECOND)); // 14
        System.out.println("TimeZone (-12 ~ +12) : " + today.get(Calendar.ZONE_OFFSET) / (60*60*1000)); // 15
        System.out.println("이 달의 마지막 날 : " + today.getActualMaximum(Calendar.DATE));
    }
}
