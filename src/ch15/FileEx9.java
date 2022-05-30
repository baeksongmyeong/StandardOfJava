package ch15;

import java.io.File;

public class FileEx9 {
    public static void main(String[] args) {
        if (args.length != 1) System.exit(0);
        File dir = new File(args[0]);
        if(!dir.exists() || !dir.isDirectory()) System.exit(0);
        File[] files = dir.listFiles();

        for (File file : files) {

            String fileName = file.getName();
            String newFileName = "0000" + fileName;
            
            // 기존 파일명이 길지 않은 경우만 가능. 숫자는 기존 파일명의 최대길이를 고려해서 적용해야 함
            newFileName.substring(newFileName.length() - 7);
            
            // 파일명 변경시에 파일 인스턴스 필요
            file.renameTo(new File(dir, newFileName));
        }
    }
}