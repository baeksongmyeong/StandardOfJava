package ch8;

/* finally 블록은 catch 블록에서 예외를 처리하지 못하는 경우에도 수행된다.
*  finally 블록은 try~catch 블록에 return 문이 있어도 수행된다.
* */

public class FinallyTest3 {
    public static void main(String[] args) {
        method1();
        System.out.println("main 돌아옴");
    }

    static void method1(){
        try{
            System.out.println("method1 호출");
            return;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally 실행");
        }
    }
}
