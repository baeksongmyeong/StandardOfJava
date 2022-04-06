package ch6;

public class CarTest {
    public static void main(String[] args) {
        /*
        생성자에 매개변수가 없는 경우와, 있는 경우를 비교
        값의 초기화에는 매개변수가 있는 생성자가 개념적으로 이상적
         */
        // 기본 생성자 호출
        Car c1 = new Car();

        // 생성된 객체 접근
        c1.color = "white";
        c1.gearType = "auto";
        c1.door = 4;

        // 매개변수가 있는 생성자 호출
        Car c2 = new Car("white", "auto", 5);

        System.out.println(c1.color + c1.gearType + c1.door);
        System.out.println(c2.color + c2.gearType + c2.door);
    }
}

class Car {
    String color;
    String gearType;
    int door;

    Car() {}

    // 인스턴스변수와 매개변수명이 같을때, this 를 사용하지 않으면 매개변수(지역변수)로만 처리되므로 매개변수 이름을 다르게 해야 한다.
    Car(String c, String g, int d) {
        color = c;
        gearType = g;
        door = d;
    }
}
