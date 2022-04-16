package ch7;

/*
final 이 붙은 인스턴스 변수(상수) 라도 생성자 또는 초기화 블록을 통해 초기값을 설정하는 것은 허용된다.
 */

public class FinalCardTest {
    public static void main(String[] args) {
        Card1 c = new Card1("HEARD", 10);
        //c.NUMBER = 5; // final 상수는 생성자 또는 초기화 블록에서만 값 설정이 가능하다.
        System.out.println(c.KIND);
        System.out.println(c.NUMBER);
        System.out.println(c);
    }
}

class Card1 {

    // 클래스 변수
    static int width = 100;
    static int height = 250;

    // 인스턴스 변수
    final int NUMBER;
    final String KIND;

    // 클래스 초기화 블록
    static {
    }

    // 인스턴스 초기화 블록
    {
    }

    // 인스턴스 생성자
    Card1(String kind, int number){
        this.NUMBER = number;
        this.KIND = kind;
    }

    Card1(){
        this("HEART", 1);
    }

    // 클래스 메서드

    // 인스턴스 메서드
    @Override
    public String toString(){
        return this.KIND + " " + this.NUMBER;
    }

}
