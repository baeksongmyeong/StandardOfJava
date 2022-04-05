package ch6;

class Tv4 {
    // 멤버변수
    String color;
    boolean power;
    int channel;
    // 메서드
    void power(){ power = !power; }
    void channelUp(){ channel++; }
    void channelDown(){ channel--; }
}

public class TvTest4 {
    public static void main(String[] args) {
        //객체배열 생성
        Tv4[] tvArr = new Tv4[3];
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv4();
            tvArr[i].channel = i + 10;
        }
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp();
            System.out.println(tvArr[i].channel);
        }
    }
}
