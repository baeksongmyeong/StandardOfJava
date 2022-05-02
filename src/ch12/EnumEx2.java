package ch12;


/*
* 열거형의 ordinal() 메서드의 반환값인 상수선언순서를 상수의 값으로 사용하지 말아라
* 그렇다면 상수의 값은 어떻게 설정해야 하는걸까
*   - 상수명(값) 형태로 선언하면 된다.
*   - 이렇게만 하면 컴파일 오류가 발생한다.
*   - 값의 개수, 타입에 맞는 인스턴스 변수가 열거형 내에 선언되어야 하며,
*   - 이 인스턴스 변수를 초기화 하는 생성자를 선언해야 컴파일이 된다.
*   - 이 말은, 열거형 내에 선언된 상수들은 열거형이 나타낼 수 있는 값의 종류를 제한하는 역할이고
*   - 하나의 열거형 타입은 그 값의 종류내에서 값을 저장하는 공간을 가져야 한다는 것이다.
*
* 열거형 내에는 상수만이 아니라, 변수, 메서드도 선언이 가능하다.
*   - 열거형은 클래스라고 생각해도 무방할 듯 하다.
*   - 하지만 new 연산자로 열거형의 인스턴스는 생성할 수 없다.
*   - 생성자가 암묵적으로 private 으로 고정되어 있기 때문이다.
*
* 열거형은 해당 열거형이 로드되는 순간, 각 상수들에 대한 인스턴스가 생기는 것 같다
*   - 각 상수들에 대한 인스턴스를 이전 예제에 나왔던 3개의 방법을 참조를 하게 되는것 같다.
*       - 열거형.상수명
*       - 열거형.valueOf("상수명")
*       - Enum.valueOf(열거형.class, "상수명")
*
* 이렇게 참조된 상수 인스턴스를 통해 열거형에 선언된 변수나 메서드들을 이용하면 되는 것 같다.
* */

enum Direction2 {
    EAST(1, "<")
    ,SOUTH(2, "v")
    ,WEST(3, "<")
    ,NORTH(4, "^")
    ;

    // Direction2 열거형 내 모든 상수를 배열로 저장
    private static final Direction2[] DIR_ARR = Direction2.values();

    // 위에 선언한 상수의 값인 상수명(정수값, 문자열) 목록중 한가지 상수만을 저장하기 위한 변수
    private final int value;
    private final String symbol;

    //
    Direction2(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue(){return this.value;}

    public String getSymbol(){return this.symbol;}

    public static Direction2 of(int dir) {
        if(dir < 1 || dir > 4) throw new IllegalArgumentException("Invalid value : " + dir);
        return DIR_ARR[dir - 1];
    }

    public Direction2 rotate(int num) {
        num = num % 4;
        if(num < 0 ) num += 4;
        System.out.printf("name = %-6s, value = %d, num = %d -> ", this.name(), this.value, num);
        return DIR_ARR[(this.value - 1 + num)];
    }

    public String toString(){
        return String.format("%6s : %s", this.name(), this.getSymbol());
    }
}

public class EnumEx2 {
    public static void main(String[] args) {
        System.out.println("== enum 내 모든 상수(인스턴스화된) 확인 ==");
        for (Direction2 d : Direction2.values()) {
            System.out.printf("%6s = %d%n", d.name(), d.getValue());
        }

        System.out.println("== 상수 가져오기 (상수의 인스턴스 참조) ==");
        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("%6s = %d%n", d1.name(), d1.getValue());
        System.out.printf("%6s = %d%n", d2.name(), d2.getValue());

        System.out.println("== 가져온 상수의 메서드 실행 (상수의 인스턴스 참조) ==");
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.SOUTH.rotate(1));
    }
}
