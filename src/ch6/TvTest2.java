package ch6;

class Tv2 {
    // 속성:멤버변수
    String color;
    boolean power;
    int channel;
    // 기능:메서드
    void power(){ power = !power; }
    void channelUp(){ channel++; }
    void channelDown(){ channel--; }
}

public class TvTest2 {
    public static void main(String[] args) {
        Tv2 t1 = new Tv2();
        Tv2 t2 = new Tv2();
        System.out.println("tv1.channel:"+t1.channel);
        System.out.println("tv2.channel:"+t2.channel);
        t1.channel = 7;
        System.out.println("tv1.channel:"+t1.channel);
        System.out.println("tv2.channel:"+t2.channel);
    }
}
