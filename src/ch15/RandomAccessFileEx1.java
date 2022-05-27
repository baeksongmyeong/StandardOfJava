package ch15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());

            // 기본형 int 는 4 Byte
            raf.writeInt(100);
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());

            // 기본형 long 은 8 Byte
            raf.writeLong(100L);
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());

            // 문자열. char 의 배열이므로, 한 문자는 2Byte
            raf.writeChars("123");
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());

            raf.writeChars("\n");
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());

            raf.writeChars("456");
            System.out.println("파일포인터 위치 : " + raf.getFilePointer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
