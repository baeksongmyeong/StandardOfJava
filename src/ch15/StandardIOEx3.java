package ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            // 파일 출력 스트림
            fos = new FileOutputStream("test.txt");

            // 프린트 스트림 -> 파일 출력 스트림
            ps = new PrintStream(fos);

            // System.out -> 프린트 스트림 -> 파일 출력 스트림
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // System.out 으로 출력
        System.out.println("Hello by System.out");
        
        // System.err 로 출력
        System.err.println("Hello by System.err");
    }
}
