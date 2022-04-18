package ch8;

/*
*  사용자 정의 예외 클래스를 만들수 있다. 보통 Exception 클래스나, RuntimeException 클래스를 상속받아 생성한다.
*  클래스 안에 새로운 멤버를 추가해서 예외 발생시 사용하도록 할 수 있다.
*  */

public class NewExceptionTest {

    public static void main(String[] args) {
        try{
            startInstall();
            copyFiles();
        }catch(SpaceException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(MemoryException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.gc();
        }finally {
            deleteTempFile();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()) throw new SpaceException("설치할 공간이 부족합니다.");
        if(!enoughMemory()) throw new MemoryException("메모리가 부족합니다.");
    }

    static void copyFiles(){}
    static void deleteTempFile(){}
    static boolean enoughSpace(){ return false; }
    static boolean enoughMemory(){ return false; }
}

// Exception 클래스를 상속한 사용자 정의 예외 클래스

class SpaceException extends Exception {
    SpaceException(String msg){super(msg);}
}

class MemoryException extends Exception {
    MemoryException(String msg){super(msg);}
}