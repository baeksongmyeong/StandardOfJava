package ch8;

/* catch 의 괄호에 넣는 클래스타입은 실제 예외 인스턴스의 조상이더라도 참조가 가능하다. 왜냐하면 instanceof 연산자를 이용해서 비교하기 때문이다. */

public class ExceptionEx6 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (Exception e){ // 실제 발생한 예외 인스턴스는 ArithmethicException 클래스의 인스턴스이지만, instanceof 를 통해 비교하므로, 조상 클래스인 Exception 으로도 참조가 가능하다.
            System.out.println(5);
            System.out.println(e.getClass());
        }
        System.out.println(6);
    }
}
