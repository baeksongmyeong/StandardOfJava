package ch15;

import java.io.File;

public class FileEx2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileEx2 DIRECTORY");
            System.exit(0);
        }

        File f = new File(args[0]);

        // 입력된 경로가 유효하지 않거나, 디렉토리가 아니라면
        if (!(f.exists()) || !(f.isDirectory())) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }
        
        // 디렉토리 내 파일 목록 확인
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            System.out.println(files[i].isDirectory() ? "[" + fileName + "]" : fileName);
        }
    }
}
