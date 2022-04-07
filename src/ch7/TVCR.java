package ch7;

/*
자바는 단일 상속만 지원
다중상속처럼 하려면 포함관계를 이용해서 구현
포함관계 객체의 메서드를 호출하는 것으로 구현
 */

public class TVCR extends TV {
    
    // 멤버변수
    VCR vcr = new VCR();

    // 초기화

    // 생성자

    // 멤버메서드
    void play(){ // VCR 객체의 메서드를 호출한다. VCR 객체의 메서드명과 동일하게 하여, 마치 VCR 객체를 직접 호출하는 것처럼 보이게 한다. 중간다리 역할
        vcr.play();
    }

    void stop(){
        vcr.stop();
    }
    
    void rew(){
        vcr.rew();
    }

    void ff(){
        vcr.ff();
    }
    

}

class TV {
    // 멤버변수 - 기본값 - 명시적
    boolean power;
    int channel;
    // 초기화
    // 생성자
    // 멤버메서드
    void power(){power = !power;}
    void channelup(){channel++;}
    void channelDown(){channel--;}
}

class VCR {
    // 멤버변수
    boolean power;
    int counter = 0;
    // 초기화
    // 생성자
    // 멤버메서드
    void power(){ power = !power; }
    void play(){}
    void stop(){}
    void rew(){}
    void ff(){}
}
