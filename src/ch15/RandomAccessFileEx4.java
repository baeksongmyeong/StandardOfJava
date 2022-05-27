package ch15;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx4 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        try {
            RandomAccessFile raf = new RandomAccessFile("test3.dat", "rw");
            raf.writeChars("안녕하세요");
            raf.writeChar('\n');
            raf.writeChars("자바입니다");

            raf.seek(0);

            while (true) {
                sb.append(raf.readChar());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("EOFException");
            System.out.println("출력 : " + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
