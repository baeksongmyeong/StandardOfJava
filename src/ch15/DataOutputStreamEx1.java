package ch15;

import java.io.*;

public class DataOutputStreamEx1 {
    public static void main(String[] args) {

        try {
            // 기반 스트림
            FileOutputStream fos = new FileOutputStream("sample.dat");

            // 보조 스트림
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
