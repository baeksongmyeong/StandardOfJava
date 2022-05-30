package ch15;

import java.io.File;

public class FileEx8 {

    static int deleteCount;

    static {
        deleteCount = 0;
    }


    public static void main(String[] args) {

        // 인자
        if (args.length != 2) {
            System.out.println("디렉토리와 확장자 입력");
            System.exit(0);
        }

        // 시작 디렉토리
        String sDir = args[0];
        File dir = new File(sDir);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println(sDir + " 은/는 유효한 디렉토리 경로가 아닙니다.");
            System.exit(0);
        }

        // 확장자
        String extension = args[1];

        deleteFile(dir, extension);

        System.out.println(deleteCount + " 개의 파일이 삭제되었습니다.");

    }

    public static void deleteFile(File dir, String extension) {

        // 디렉토리 내 디렉토리, 파일 목록
        File[] files = dir.listFiles();

        for (File file : files) {
            
            // 하위 디렉토리이면 재귀호출
            if (file.isDirectory()) deleteFile(file, extension);
            
            // 파일의 절대경로
            String fileName = file.getAbsolutePath();

            // 파일이 확장자로 끝나는지 검토
            if (fileName.endsWith(extension)) {

                // 삭제대상 파일명 출력
                System.out.println(fileName);

//                // 삭제 실행
//                if (file.delete()) {
//                    System.out.println("삭제성공");
//                    deleteCount++;
//                } else {
//                    System.out.println("삭제실패");
//                }
            }
        }
    }
}
