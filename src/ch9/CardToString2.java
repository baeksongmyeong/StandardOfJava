package ch9;

/*
* 클래스 생성시 조상 클래스인 Object 클래스의 toString() 메서드를 오버라이드하면 원하는 형태의 문자열 정보를 생성해서 리턴할 수 있다.
* */

public class CardToString2 {
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2("HEARD", 10);
        System.out.println(c1);
        System.out.println(c2);
    }
}

class Card2 {
    String kind;
    int number;

    public Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public Card2() {
        this("SPADE", 1);
    }

    @Override
    public String toString(){
        return "kind : " + kind + ", number : " + number;
    }
}
