package ch15;

import java.io.*;

/*
* 여러 파일을 하나의 파일로 합친다.
* */
public class FileMerge {
    public static void main(String[] args) {
        if(args.length != 1) System.exit(0);
        String mergeFileName = args[0];

        try {
            // 임시파일 생성
            File tempFile = File.createTempFile("~mergetemp", ".tmp");
            
            // 프로그램 종료시 임시파일 삭제
            tempFile.deleteOnExit();

            // 임시 파일의 출력 스트림 생성
            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // 원천 파일의 입력 스트림 생성
            BufferedInputStream bis = null;

            // 원천 파일의 시퀀스
            int number = 1;

            File f = new File(mergeFileName + "_." + number);

            while (f.exists()) {

                // 읽기 전용으로 설정 (Lock)
                f.setReadOnly();
                
                // 원천 파일 스트림
                bis = new BufferedInputStream(new FileInputStream(f));

                int data = 0;

                // 원천파일의 데이터를 읽어들임
                while ((data = bis.read()) != -1) {
                    // 출력 파일에 읽어들인 데이터 쓰기
                    bos.write(data);
                }

                bis.close();

                // 다음 순번 파일 인스턴스 생성
                f = new File(mergeFileName + "_." + (++number));
            }

            bos.close();

            // 기존 파일 삭제 및 임시파일 이름 변경
            File oldFile = new File(mergeFileName);
            if (oldFile.exists()) oldFile.delete();
            tempFile.renameTo(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
