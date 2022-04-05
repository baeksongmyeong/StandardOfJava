package ch6;

public class CardTest {
    public static void main(String[] args) {

        // 클래스 변수 접근
        System.out.println("width:"+Card.width);
        System.out.println("height:"+Card.height);

        // 클래스 로딩 및 인스턴스 생성
        Card c1 = new Card();
        
        // 인스턴스 변수 접근
        c1.kind = "Heard";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println(c1.kind + ", " + c1.number);
        System.out.println(c2.kind + ", " + c2.number);

        // 클래스 변수 값 변경 후 모든 인스턴스에 적용되었는지 확인
        Card.width = 50;
        Card.height = 80;

        // 인스턴스 참조를 통해 클래스 변수 접근
        System.out.println(c1.width + ", " + c1.height);
        System.out.println(c2.width + ", " + c2.height);


    }
}

class Card {
    // 클래스 변수
    static int width = 100;
    static int height = 250;

    // 인스턴스 변수
    int number;
    String kind;

    // 클래스 메서드
    // 인스턴스 메서드
}
