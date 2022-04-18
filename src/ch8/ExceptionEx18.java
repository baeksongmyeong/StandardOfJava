package ch8;

/*
* 리턴값이 있는 메서드인 경우, try 뿐만 아니라 catch 에도 return 문장이 필요하다. catch 가 있다는 것은 예외를 처리했다는 의미이니까, 정상적인 프로그램 진행이 되어야 한다.
* 하지만, 예외 되던지기를 하는 경우에는 catch 에 return 문장이 필요없다.
* */


public class ExceptionEx18 {

    public static void main(String[] args) {

    }

    // 예외 되던지기 미적용
    static int method1(){
        try{
            return 0;
        } catch (Exception e){
            return 1; // return 문 없으면 오류 발생
        }
    }

    // 예외 되던지기 적용
    static int method2() throws Exception {
        try{
            return 0;
        }catch (Exception e){
            throw e;
            //return 1; // return 문 있으면 오류 발생
        }
    }

}
