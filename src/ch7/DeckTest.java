package ch7;

/*
Card 클래스는 Deck 클래스에 포함관계로 설정되어서 사용됨
 */

public class DeckTest {
    public static void main(String[] args) {

        // Deck 인스턴스 생성 > 카드 인스턴스 52개도 생성됨
        Deck d = new Deck();

        // Deck 인스턴스에 포함관계인 Card 배열 내 첫번째 인스턴스를 가져옴
        Card c = d.pick(0);

        // print 내에 객체가 있는 경우, 객체의 toString 이 자동 실행
        System.out.println(c);

        // Deck 내의 Card 배열내 Card 를 섞는다.
        d.shuffle();

        // 섞인 후 Card 배열 내 첫번째 인스턴스를 가져온다.
        c = d.pick(0);

        System.out.println(c);
    }
}

class Card {

    // 클래스 변수
    static final int KIND_MAX = 4; // 전체 카드 종류 ( 클로버, 스페이드, 하트, 다이아몬드 )
    static final int NUM_MAX = 13; // 전체 숫자 종류 ( 1 ~ 9, X(10), J, Q, K )
    static final int CLOVER = 1;
    static final int HEARD = 2;
    static final int DIAMOND = 3;
    static final int SPADE = 4;

    // 인스턴스 변수
    int kind; // 카드 인스턴스(카드 하나) 의 종류
    int number; // 카드 인스턴스(카드 하나) 의 번호
    
    // 클래스 초기화 영역
    static { System.out.println("Card 클래스 초기화 실행"); }

    // 인스턴스 초기화 영역
    { System.out.println("Card 인스턴스 초기화 실행"); }

    // 생성자
    Card() {
        this(SPADE, 1);
    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // 클래스 메서드

    // 인스턴스 메서드
    @Override
    public String toString() {
        String[] kinds = {"", "CLOVER", "HEARD", "DIAMOND", "SPADE"}; // 숫자로 저장된 카드 종류를 문자로 보여주기 위한 매핑 테이블 용도
        String numbers = "0123456789XJQK"; // 숫자로 저장된 카드 번호를 알파벳이 포함된 문자로 보여주기 위한 매핑 테이블 용도
        return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(number);
    }
}

class Deck {

    // 클래스 변수
    static int cardNum = 0;

    // 인스턴스 변수
    final int CARD_NUM = 52; // Deck 하나에 담겨야 하는 Card 의 총 수 ( 13 * 4 )
    Card[] cardArr = new Card[CARD_NUM]; // 하나의 Deck 에 담길 카드 52개를 담을 배열

    // 클래스 초기화 영역
    static { System.out.println("Deck 클래스 초기화 실행"); }

    // 인스턴스 초기화 영역
    static {
        System.out.println("Deck 인스턴스 초기화 실행");
    }

    // 생성자
    Deck() {
        // Card 52개를 생성하여 Deck 에 담는다.
        int i = 0;
        for (int k = Card.KIND_MAX; k > 0; k--) { // 전체 카드 종류 ( 클로버, 스페이드, 하트, 다이아몬드 )
            for (int n = 0; n < Card.NUM_MAX; n++) { // 전체 숫자 종류 ( 1 ~ 9, X(10), J, Q, K )
                System.out.printf("%d 번째 카드가 만들어집니다. %n", ++Deck.cardNum);
                // 카드 객체 생성 및 Deck 의 Card 배열에 카드 객체 주소 저장
                cardArr[i++] = new Card(k, n+1);
            }
        }
    }

    // 클래스 메서드

    // 인스턴스 메서드
    Card pick(int index) { // 특정 위치의 카드를 꺼내서 반환한다.
        return cardArr[index];
    }

    Card pick() { // Deck 에서 무작위로 카드 하나의 위치를 정한다.
        int index = (int)(Math.random() + 1) * CARD_NUM;
        return pick(index);
    }

    void shuffle() { // 카드를 무작위로 섞는다.
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int)(Math.random() * CARD_NUM); // 0 부터 51 까지의 수가 필요하다.
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}
