package ch6;

// 클래스 선언
class Tv1 {
    // 속성 : 멤버변수
    String color;
    boolean power;
    int channel;
    
    // 기능 : 메서드
    void power(){ power = !power; }
    void channelUp(){ channel++; }
    void channelDown(){ channel--; }
}

public class TvTest {

    public static void main(String[] args) {

        // Tv 클래스의 인스턴스 생성
        Tv1 t = new Tv1();
        
        // Tv 클래스의 인스턴스 t 의 멤버변수 접근
        t.channel = 7;

        // Tv 클래스의 인스턴스 t 의 메서드 접근
        t.channelDown();

        System.out.printf("현재채널은 %d 입니다.", t.channel);
    }

}
