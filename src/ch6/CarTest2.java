package ch6;

public class CarTest2 {
    /*
    생성자가 동일 클래스 내 다른 생성자 호출
    this() 사용 - this() 는 곧 생성자들을 의미
    매개변수 타입 및 개수로 원하는 생성자를 호출할 수 있음 - 오버로딩
     */
    public static void main(String[] args) {
        Car1 c1 = new Car1();
        Car1 c2 = new Car1("blue");
        System.out.println(c1.color+c1.gearType+c1.door);
        System.out.println(c2.color+c2.gearType+c2.door);
    }
}

class Car1 {

    // 인스턴스 변수
    String color;
    String gearType;
    int door;

    // 기본생성자
    Car1(){
        this("white", "auto", 4); // this() 로 다른 생성자 호출
    }
    
    // 매개변수 포함 생성자 (인스턴스 변수중 일부만 입력됨)
    Car1(String color){
        this(color, "auto", 4);
    }

    // 매개변수 포함 생성자
    Car1(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
