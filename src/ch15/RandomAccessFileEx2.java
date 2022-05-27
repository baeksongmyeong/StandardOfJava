package ch15;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
    public static void main(String[] args) {
        int[] score = {
           // 번호, 국어, 영어, 수학
                1, 100,  90,  90,
                2,  70,  90,  90,
                3, 100, 100, 100,
                4,  70,  60,  80,
                5,  70,  90, 100
        };

        try {
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
            for (int i = 0; i < score.length; i++) {
                raf.writeInt(score[i]);
            }

            // 파일 포인터가 파일의 마지막으로 이동해 있으므로, 맨 처음으로 이동시켜야 한다.
            raf.seek(0);

            while (true) {
                System.out.println(raf.readInt());
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (EOFException e) {
            System.out.println("EOFException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
