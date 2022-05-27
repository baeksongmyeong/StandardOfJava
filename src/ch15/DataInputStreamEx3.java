package ch15;

import java.io.*;

public class DataInputStreamEx3 {

    public static void main(String[] args) {

        /*
        * try with resource 문으로 스트림을 종료시킨다.
        * */
        int score = 0;
        int sum = 0;

        try (FileInputStream fis = new FileInputStream("score.dat");
             DataInputStream dis = new DataInputStream(fis);
        ) {
            while (true) {
                score = dis.readInt();
                System.out.println("score = " + score);
                sum += score;
            }
        } catch (EOFException e) {
            System.out.println("sum = " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
