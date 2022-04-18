package ch8;

/* finally 블록은 예외 발생여부와 관계없이 try~catch 블록이 끝나면 무조건 실행되는 블록이다. */

public class FinallyTest {
    public static void main(String[] args) {
        try{
            startInstall();
            copyFiles();
            deleteTempFile(); // finally 가 없다면 try 와 catch 블록 모두에 이 코드가 들어가야 한다.
        }catch(Exception e){
            e.printStackTrace();
            deleteTempFile(); // finally 가 없다면 try 와 catch 블록 모두에 이 코드가 들어가야 한다.
        }finally {

        }
    }

    static void startInstall(){}
    static void copyFiles(){}
    static void deleteTempFile(){}

}
