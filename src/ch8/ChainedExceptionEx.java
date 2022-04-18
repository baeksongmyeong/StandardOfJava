package ch8;

public class ChainedExceptionEx {

    public static void main(String[] args) {
        try{
            start();
        }catch (InstallException e){
            System.out.println("InstallException");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    static void start() throws Exception {
        try{
            install();
        }catch(InstallException e){
            Exception ex = new Exception("작업 중 오류발생");
            ex.initCause(e);
            throw ex;
        }
    }

    static void install() throws InstallException{
        try{
            startInstall();
        }catch(SpaceException2 e){
            // 원인예외 등록
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(e);
            throw ie;
        }catch(MemoryException2 e){
            // 원인예외 등록
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(e);
            throw ie;
        }finally{
            deleteTempFile();
        }
    }

    static void startInstall() throws SpaceException2, MemoryException2{
        if(!enoughSpace()){
            throw new SpaceException2("설치할 공간이 부족합니다.");
        }
        if(!enoughMemory()){
            throw new MemoryException2("메모리가 부족합니다.");

            // 원인 예외 등록 방법 1
            //throw new RuntimeException(new MemoryException2("메모리가 부족합니다."));

            // 원인 예외 등록 방법 2
            //RuntimeException runtimeException = new RuntimeException();
            //runtimeException.initCause(new MemoryException2("메모리가 부족합니다."));
        }
    }
    static void copyFiles(){}
    static void deleteTempFile(){}
    static boolean enoughSpace(){return false;}
    static boolean enoughMemory(){return true;}
}

// 사용자 정의 예외 클래스. Exception 을 상속했기때문에, 예외처리가 강제된다.

class InstallException extends Exception {
    public InstallException(String msg) {
        super(msg);
    }
}

class SpaceException2 extends Exception {
    public SpaceException2(String msg) {
        super(msg);
    }
}

class MemoryException2 extends Exception {
    public MemoryException2(String msg) {
        super(msg);
    }
}
