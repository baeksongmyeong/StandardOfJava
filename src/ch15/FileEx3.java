package ch15;

import java.io.File;
import java.util.ArrayList;

public class FileEx3 {

    static int totalFiles = 0;
    static int totalDirs = 0;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileEx3 DIRECTORY");
            System.exit(0);
        }

        File dir = new File(args[0]);

        // 입력된 경로가 유효하지 않거나, 디렉토리가 아니라면
        if (!(dir.exists()) || !(dir.isDirectory())) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        printFileList(dir);

        System.out.println();
        System.out.println("총 " + totalFiles + " 개의 파일");
        System.out.println("총 " + totalDirs + " 개의 디렉토리");
    }

    public static void printFileList(File dir) {
        System.out.println(dir.getAbsolutePath() + " 디렉토리 작업 시작");
        
        // 디렉토리 내 파일 목록
        File[] files = dir.listFiles();

        // 작업대상 디렉토리 내 하위 디렉토리 저장용 리스트
        ArrayList<File> subDir = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            String fileName = file.getName();
            if (file.isDirectory()) {
                fileName = "[" + fileName + "]";
                subDir.add(file);
            }
            System.out.println(fileName);
        }

        // 작업대상 디렉토리 내 하위 디렉토리 개수
        int dirNum = subDir.size();
        
        // 작업대상 디렉토리 내 파일 개수
        int fileNum = files.length - dirNum;

        // 전체 디렉토리 개수
        totalDirs += dirNum;

        // 전체 파일 개수
        totalFiles += fileNum;

        System.out.println(fileNum + " 개의 파일, " + dirNum + " 개의 하위 디렉토리");
        System.out.println();

        for (File file : subDir) {
            printFileList(file);
        }
    }
}
