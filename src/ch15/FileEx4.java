package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {
    public static void main(String[] args) {
        
        // 프로그램이 실행되는 디렉토리
        String currDir = System.getProperty("user.dir");
        
        // 현재 디렉토리 참조
        File dir = new File(currDir);

        // 현재 디렉토리내 파일 목록
        File[] files = dir.listFiles();

        for (File f : files) {
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
            String attribute = "";
            String size = "";

            // 최종수정시간 long
            long modiDate = f.lastModified();

            // 최종수정시간을 날짜 타입으로 변경
            Date date = new Date(modiDate);

            if (f.isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length() + "";
                attribute  = f.canRead() ? "R" : "";
                attribute += f.canWrite() ? "W" : "";
                attribute += f.isHidden() ? "H" : "";
            }

            System.out.printf("%s %3s %6s %s\n", df.format(modiDate), attribute, size, name);
        }

    }
}
