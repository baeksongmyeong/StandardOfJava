package ch6;

class Tv3 {
    // 멤버변수
    String color;
    boolean power;
    int channel;
    // 메서드
    void power(){ power = !power; }
    void channelUp(){ channel++; }
    void channelDown(){ channel--; }
}

public class TvTest3 {
    public static void main(String[] args) {
        Tv3 t1 = new Tv3();
        Tv3 t2 = new Tv3();
        System.out.println(t1.channel);
        System.out.println(t2.channel);
        // t2 참조변수 저장값을 t1 값과 동일하게 설정 -> t2 가 참조하던 객체는 쓰레기가 된다.
        t2 = t1;
        t1.channel = 7;
        System.out.println(t1.channel);
        System.out.println(t2.channel);
    }
}


