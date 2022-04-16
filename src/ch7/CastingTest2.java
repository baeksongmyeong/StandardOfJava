package ch7;

public class CastingTest2 {
    public static void main(String[] args) {
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine)car; // 조상 인스턴스를 자손 클래스 타입의 참조변수로 참조하는 것은 컴파일은 되지만, 실행시 오류가 발생한다.
        fe.drive();
        car2 = fe;
        car2.drive();
    }
}
