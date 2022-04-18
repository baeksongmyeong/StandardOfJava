package ch8;

/* finally 블록은 예외 발생여부와 관계없이 try~catch 블록이 끝나면 무조건 실행되는 블록이다. */

public class FinallyTest2 {
    public static void main(String[] args) {
        try{
            startInstall();
            copyFiles();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            deleteTempFiles();
        }
    }

    static void startInstall(){}
    static void copyFiles(){}
    static void deleteTempFiles(){}
}
