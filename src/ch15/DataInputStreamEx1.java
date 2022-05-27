package ch15;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx1 {
    public static void main(String[] args) {
        try {
            // 파일 입력 스트림 생성
            FileInputStream fis1 = new FileInputStream("sample.dat");

            // 파일 입력 스트림의 보조스트림으로 DataInputStream 생성
            DataInputStream dis = new DataInputStream(fis1);

            int iVal = dis.readInt();
            float fVal = dis.readFloat();
            boolean bVal = dis.readBoolean();

            System.out.println("iVal = " + iVal);
            System.out.println("fVal = " + fVal);
            System.out.println("bVal = " + bVal);

            /*------------------------------------------
            DataOutputStream 의 기본형 write() 메서드를 이용해서 write 한 경우
            FileInputStream 의 read() 로는 값을 정상적으로 읽을수 없다.
            ------------------------------------------*/

            // 파일 입력 스트림 생성
            FileInputStream fis2 = new FileInputStream("sample.dat");

            int i1 = fis1.read();
            int i2 = fis1.read();
            int i3 = fis1.read();

            System.out.println("i1 = " + i1);
            System.out.println("i2 = " + i2);
            System.out.println("i3 = " + i3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
