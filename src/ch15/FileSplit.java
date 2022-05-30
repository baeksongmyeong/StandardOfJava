package ch15;

import java.io.*;


/*
* 원본 파일명과 파일을 자를 바이트 크기를 입력받는다
* 원본 파일의 데이터를 새로운 파일들에 나눠 담는다.
* */
public class FileSplit {
    public static void main(String[] args) {
        if(args.length != 2) System.exit(0);

        String fileName = args[0];
        final int VOLUME = Integer.valueOf(args[1]) * 1000;

        try {
            // 입력 기반 스트림
            FileInputStream fis = new FileInputStream(fileName);
            // 입력 보조 스트림
            BufferedInputStream bis = new BufferedInputStream(fis);

            // 출력 기반 스트림
            FileOutputStream fos = null;
            // 출력 보조 스트림
            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0; // 읽어들인 바이트
            int number = 0;
            
            // 1 Byte 씩 읽기
            while ((data = bis.read()) != -1) {
                
                // 파일에 write 바이트수가 지정한 최대크기에 도달했다면 (나머지가 0 이므로, i 의 값은 0 또는 최대크기이다)
                if (i % VOLUME == 0) {

                    // 프로그램 최초 시작시점이 아니라면
                    if (i != 0) {
                        bos.close();
                    }
                    
                    // 새로운 파일 스트림을 생성
                    fos = new FileOutputStream(fileName + "_." + ++number);
                    bos = new BufferedOutputStream(fos);
                }
                bos.write(data);
                i++;
            }
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
