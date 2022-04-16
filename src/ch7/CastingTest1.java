package ch7;

/*
업캐스팅 : 형변환 생략가능. 자손 멤버 접근 불가
다운캐스팅 : 형변환 생략불가. 멤버 접근 가능
 */
public class CastingTest1 {
    
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();

        // 업캐스팅. 형변환 생략가능
        car = fe;

        // FireEngine 클래스의 인스턴스에는 존재하는 멤버이지만 참조변수인 Car 클래스에 없는 멤버이므로 참조가 불가하다.
        //car.water();

        // 다운캐스팅. 형변환 생략불가
        fe2 = (FireEngine)car;

        fe2.water();

    }
}