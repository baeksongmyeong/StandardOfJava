package ch6;

public class CarTest3 {
    /*
    인스턴스 복사 : 클래스 변수, 메서드는 인스턴스들이 동일하니, 복사할 내용은 인스턴스 변수들뿐이다.
    => 생성자의 매개변수로 참조변수를 전달할 수 있으며, 해당 참조변수와 연결된 인스턴스 내 인스턴스변수들의 값을 접근하여 복사할 수 있다는 의미
     */
    public static void main(String[] args) {

        Car2 c1 = new Car2();
        Car2 c2 = new Car2(c1); // 인자로 인스턴스 참조변수 전달

        System.out.println(c1.color+c1.gearType+c1.door);
        System.out.println(c2.color+c2.gearType+c2.door);

        c1.door = 100;

        System.out.println(c1.color+c1.gearType+c1.door);
        System.out.println(c2.color+c2.gearType+c2.door);

    }
}

class Car2 {
    // 인스턴스 변수
    String color;
    String gearType;
    int door;

    // 기본생성자
    Car2(){
        this("white", "auto", 4); // this() 로 다른 생성자 호출
    }

    // 매개변수 포함 생성자
    Car2(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    
    // 매개변수를 참조변수로 받는 생성자 - 인스턴스 복사용
    Car2(Car2 c) {
        this.color = c.color;
        this.gearType = c.gearType;
        this.door = c.door;
    }
    
}
