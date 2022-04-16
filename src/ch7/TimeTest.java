package ch7;

import java.time.LocalTime;

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
        //System.out.println(t);
        Time t1 = new Time(12, 35, 30);
        System.out.println(t1);
        //t1.hour = 1; // private 변수이기에 다른 클래스에서 접근이 불가하다.
        t1.setHour(t1.getHour() + 1);
        System.out.println(t1);

    }
}

class Time {

    // 클래스 변수

    // 인스턴스 변수
    private int hour; // 시
    private int minute; // 분
    private int second; // 초

    // 클래스 초기화 블록
    static {}

    // 인스턴스 초기화 블록
    {}

    // 생성자
    Time(){
        this(LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond());
    }

    Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // 클래스 메서드

    // 인스턴스 메서드
    public int getHour() { return this.hour; }

    public void setHour(int hour){
        if(hour < 0 || hour > 23) { return; }
        this.hour = hour;
    }

    public int getMinute() { return this.minute; }

    public void setMinute(int minute){
        if(minute < 0 || minute > 59) { return; }
        this.minute = minute;
    }

    public int getSecond(){ return this.second; }

    public void setSecond(int second){
        if( second < 0 || second > 59 ) { return; }
        this.second = second;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
