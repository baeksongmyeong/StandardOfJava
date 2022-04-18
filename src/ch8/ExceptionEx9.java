package ch8;

/* 키워드 throw 를 사용해서, 예외 인스턴스를 생성 후 고의로 발생시킬수 있다. */

public class ExceptionEx9 {
    public static void main(String[] args) {
        methodA();
    }

    public static void methodA(){
        try{
            Exception e = new Exception("고의로 발생시켰음.");
            throw e;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
