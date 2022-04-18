package ch8;

/* try 블록 내에서 예외가 발생하지 않으면 catch 블록 안에 있는 코드들은 수행되지 않는다. */

public class ExceptionEx4 {

    // 클래스 멤버 변수
    // 인스턴스 멤버 변수
    // 클래스 초기화 블록
    // 인스턴스 초기화 블록
    // 생성자
    // 클래스 메서드
    // 인스턴스 메서드

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(4);
        }catch(Exception e){
            System.out.println(5);
        }
        System.out.println(6);
    }
}
