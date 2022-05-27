package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {
    public static void main(String[] args) {
        // 입력용 byte 배열 3개 생성
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {6, 7, 8};

        // 결과용 byte 배열 1개 생성
        byte[] outSrc = null;

        // 읽어들인 값을 참조할 변수
        int data = 0;

        try (ByteArrayInputStream bais1 = new ByteArrayInputStream(arr1);
             ByteArrayInputStream bais2 = new ByteArrayInputStream(arr2);
             ByteArrayInputStream bais3 = new ByteArrayInputStream(arr3);
             ByteArrayOutputStream output = new ByteArrayOutputStream();
        ) {

            Vector<ByteArrayInputStream> v = new Vector<>();
            v.add(bais1);
            v.add(bais2);
            v.add(bais3);

            // 입력 스트림을 합쳐서 하나의 SequenceInputStream 생성
            SequenceInputStream input = new SequenceInputStream(v.elements());

            while ( (data = input.read()) != -1 ) {
                output.write(data);
            }

            outSrc = output.toByteArray();
            System.out.println(Arrays.toString(outSrc));

            input.close();


        } catch (IOException e) {
            e.printStackTrace();
        }









        

        


    }
}
