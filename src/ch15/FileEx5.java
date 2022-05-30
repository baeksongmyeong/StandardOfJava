package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileEx5 {
    public static void main(String[] args) {
        if (args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
            System.out.println ("USAGE : java FileEx5 SORT OPTION ");
            System.out.println (" SORT OPTION : ");
            System.out.println (" t Time ascending sort. ");
            System.out.println (" T Time descending sort. ");
            System.out.println (" 1 Length ascending sort. ");
            System.out.println (" L Length descending sort. ");
            System.out.println (" n Name ascending sort. ");
            System.out.println (" N Name descending sort. ");
            System.exit (0) ;
        }

        // 입력된 옵션값을 상수로 설정
        final char option = args[0].charAt(0);

        // 프로그램의 시작 디렉토리 및 파일목록 저장
        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);
        File[] files = dir.listFiles();

        // 파일을 비교하기위한 Comparator 생성 및 구현
        Comparator<File> comp = new Comparator<>() {
            @Override
            public int compare(File f1, File f2) {
                // 최종수정일시
                long time1 = f1.lastModified();
                long time2 = f2.lastModified();
                long timeDiff = time1 - time2;

                // 파일크기
                long length1 = f1.length();
                long length2 = f2.length();
                long lengthDiff = length1 - length2;
                
                // 파일명
                String name1 = f1.getName();
                String name2 = f2.getName();

                // 비교 결과
                int result = 0;

                // 입력값에 따라 비교대상 설정
                switch (option) {
                    case 't' :
                        if      (timeDiff > 0 ) result = 1;
                        else if (timeDiff == 0) result = 0;
                        else                    result = -1;
                        break;
                    case 'T':
                        if      (timeDiff > 0 ) result = -1;
                        else if (timeDiff == 0) result = 0;
                        else                    result = 1;
                        break;
                    case 'l':
                        if      (lengthDiff > 0 ) result = 1;
                        else if (lengthDiff == 0) result = 0;
                        else                      result = -1;
                        break;
                    case 'L':
                        if      (lengthDiff > 0 ) result = -1;
                        else if (lengthDiff == 0) result = 0;
                        else                      result = 1;
                        break;
                    case 'n':
                        result = name1.compareTo(name2);
                        break;
                    case 'N':
                        result = name1.compareTo(name2) * -1;
                        break;
                }
                return result;
            }
        };

        // 위에 정렬 기준에 맞춰 배열 정렬
        Arrays.sort(files, comp);
        
        // 정렬된 배열 출력
        for (int i = 0; i < files.length; i++) {
            // 파일 인스턴스 참조
            File f = files[i];
            // 파일명
            String name = f.getName();
            // SimpleDateFormat
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // 속성
            String attribute;
            // 크기
            String size = "";

            if (f.isDirectory()) {
                attribute = "DIR";
            } else {
                size = f.length() + "";
                attribute  = f.canRead() ? "R" : "";
                attribute += f.canWrite() ? "W" : "";
                attribute += f.isHidden() ? "H" : "";
            }

            System.out.printf("%s %3s %6s %s%n", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(f.lastModified())), attribute, size, name);
        }
    }
}
