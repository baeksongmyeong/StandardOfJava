package ch8;

/* 예외 인스턴스에서는 아래 메서드로 예외에 대한 정보를 찾아볼 수 있다.
* printStackTrace() : 예외가 발생한 메서드 정보 조회
* getMessage() : 발생한 예외의 정보 조회
* */

public class ExceptionEx8 {
    public static void main(String[] args) {
        try{
            System.out.println(0/0);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
