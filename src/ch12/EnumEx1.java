package ch12;


/*
* 열거형
*   - 상수를 모아서 선언해 놓은 것
*   - 선언방법
*       - enum 열거형명 { 상수명, 상수명 ... }
*       - 상수들은 선언위치 순서대로 0 부터 1씩 증가하는 정수값을 갖게된다.
*   - 열거형은 클래스, 그 안에 상수는 static 변수로, 이 상수는 상수명과 상수값(정의된 순서와는 다르게 할 수 있다.) 을 갖는 인스턴스라고 생각하면 된다.
*   - 상수 참조방법
*       - 열거형명.상수명
*       - 열거형명.valueOf("상수명")
*       - Enum.valueOf(열거형명.class, "상수명")
*   - 열거형이 제공하는 메서드
*       - 열거형명.values() : 열거형 내 상수 목록을 열거형 타입의 배열로 리턴
*       - 상수.name() : 상수의 이름을 리턴
*       - 상수.ordinal() : 상수의 선언순서를 리턴
*   - 열거형 비교
*       - == 사용 가능
*       - equals() 사용 가능
*       - <, > 사용 불가
*       - compareTo() 사용 가능
* 
* */

// 열거형 선언
enum Direction1 {
    EAST
    ,SOUTH
    ,WEST
    ,NORTH
}

public class EnumEx1 {
    public static void main(String[] args) {

        System.out.println("== 열거형의 사용 ==");

        // 열거형에 정의된 상수를 참조하는 3가지 방법
        // 1. 열거형.상수명
        // 2. 열거형.valueOf("상수명")
        // 3. Enum.valueOf(열거형.class, "상수명")
        Direction1 d1 = Direction1.EAST;
        Direction1 d2 = Direction1.valueOf("WEST");
        Direction1 d3 = Enum.valueOf(Direction1.class, "EAST");

        // 열거형 상수의 출력시 상수명이 나온다.
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("== 열거형의 동등비교 ==");

        // 열거형 비교는 '==' 연산자 사용가능. equals() 도 사용가능
        System.out.println("d1==d2 : "+ (d1==d2));
        System.out.println("d1==d3 : "+ (d1==d3));
        System.out.println("d1.equals(d3) : " + d1.equals(d3));

        System.out.println("== 열거형의 대소비교 ==");
        //System.out.println("d1 > d2 : " + (d1 > d2)); // <, > 연산자로 대소비교 불가
        System.out.println("d1.compareTo(d3) : " + d1.compareTo(d3));
        System.out.println("d1.compareTo(d2) : " + d1.compareTo(d2));

        System.out.println("== 열거형의 switch 문 사용 ==");
        switch (d1) {
            case EAST:
                System.out.println("The Direction is East.");
                break;
            case SOUTH:
                System.out.println("The Direction is SOUTH.");
                break;
            case WEST:
                System.out.println("The Direction is WEST.");
                break;
            case NORTH:
                System.out.println("The Direction is NORTH.");
                break;
            default:
                System.out.println("Invalid Direction.");
                break;
        }

        System.out.println("== 열거형 안에 정의된 모든 상수 확인 ==");
        Direction1[] dArr = Direction1.values();
        for (Direction1 d : dArr) {
            System.out.printf("%6s = %d%n", d.name(), d.ordinal());
        }
    }
}


