package ch9;

/*
* Object 클래스의 toString() 메서드는 인스턴스의 클래스명 + @ + 16진수의 해시코드 형태의 문자열을 반환한다.
* Card 클래스는 toString() 메서드를 오버라이드 하지 않았으므로, 본래 기능대로 실행된다.
* */

public class CardToString {
    public static void main(String[] args) {
        Card1 c1 = new Card1();
        Card1 c2 = new Card1();
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}

class Card1 {
    String kind;
    int number;

    public Card1(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public Card1() {
        this("SPADE", 1);
    }
}
