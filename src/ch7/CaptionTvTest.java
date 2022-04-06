package ch7;

/*
상속을 구현 Tv <- CaptionTv
조상 클래스의 멤버변수, 메서드를 자손 클래스의 인스턴스로 접근해본다.
자손 클래스만의 멤버변수, 메서드를 자손 클래스의 인스턴스로 접근해본다.
 */

class Tv {
    // 클래스 변수

    // 인스턴스 변수
    boolean power;
    int channel;

    // 클래스 초기화 블록
    static {}

    // 인스턴스 초기화 블록
    {}

    // 생성자
    public Tv() {}

    // 클래스 메서드
    
    // 인스턴스 메서드
    void power() { power = !power; }
    void channelUp(){ channel++; }
    void channelDown(){ channel--; }
}

class CaptionTv extends Tv {

    // 클래스 변수

    // 인스턴스 변수
    boolean caption;

    // 클래스 초기화 블록
    static {}

    // 인스턴스 초기화 블록
    {}

    // 생성자
    CaptionTv() {}

    // 클래스 메서드

    // 인스턴스 메서드
    void displayCaption(String text){
        if(caption){
            System.out.println(text);
        }
    }
}
public class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv(); // Tv 를 상속한 CaptionTv 클래스의 인스턴스 생성
        ctv.channel = 10; // CaptionTv 의 조상인 Tv 에서 상속한 멤버변수인 channel 접근
        ctv.channelUp(); // CaptionTv 의 조상인 Tv 에서 상속한 메서드인 channelUp 접근
        System.out.printf("현재채널:%d%n", ctv.channel);
        ctv.displayCaption("Hello, World 1"); // CaptionTv 의 고유 메서드 접근
        ctv.caption = true; // CaptionTv 의 고유 멤버변수 접근
        ctv.displayCaption("Hello, World 2");
    }
}


