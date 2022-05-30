package ch15;

import java.io.File;
import java.io.FilenameFilter;
import java.util.stream.Stream;

public class FileEx7 {
    public static void main(String[] args) {
        // 인자 1개
        if (args.length != 1) {
            System.out.println("패턴 입력 필수");
            System.exit(0);
        }

        // 현재 디렉토리
        String currDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "ch15";

        // 패턴
        final String pattern = args[0];
        
        // 현재 디렉토리 참조
        File dir = new File(currDir);

        // 입력된 패턴을 이용하여 파일명 필터 생성
        FilenameFilter ff = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.indexOf(pattern) != -1;
            }
        };

        // 파일명 필터를 이용하여 디렉토리 내 파일목록 조회
        String[] files = dir.list(ff);

        // 파일목록 출력
        Stream.of(files).sorted().forEach(System.out::println);
    }
}
