package ch15;

import java.io.*;

public class FileEx6 {

    static int found = 0;

    public static void main(String[] args) {

        // 인자값 2개 확인
        if (args.length != 2) {
            System.out.println("디렉토리와 키워드를 입력하세요");
            System.exit(0);
        }

        // 첫번째 인자 - 시작 디렉토리
        File dir = new File(args[0]);
        if ( !dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        // 두번째 인자 - 찾을 문자열
        String keyword = args[1];

        // 찾기
        findInFiles(dir, keyword);

        // 찾기 결과 출력
        System.out.println("총 " + found + " 개의 라인에서 [" + keyword + "] 을/를 발견하였습니다.");

    }

    public static void findInFiles(File dir, String keyword) {

        // 디렉토리 내 파일 및 하위 디렉토리 목록 조회
        File[] files = dir.listFiles();

        // 목록 반복 처리
        for (File file : files) {
            // 디렉토리면 디렉토리 내 keyword 찾기 메서드 호출
            if (file.isDirectory()) {
                findInFiles(file, keyword);

            }
            // 파일이면 keyword 검색
            else if (file.isFile()) {

                // 파일명
                String fileName = file.getName();

                // 확장자
                System.out.print("파일명 : " + fileName);

                if (fileName.indexOf(".") == -1) {
                    System.out.println(" >> 확장자가 없습니다");
                    continue;
                }

                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                System.out.print(" >> 확장자 " + extension);


                // 확장자가 java, txt, bak 이 아니면 검색 제외
                if (!("java".equals(extension) || "txt".equals(extension) || "bak".equals(extension))) {
                    continue;
                }

                // 파일 리더가 참조할 수 있는 형태로 파일의 절대경로 및 파일명을 문자열로 생성
                // 절대경로 + "\" + 파일명
                //String realFileName = dir.getAbsolutePath() + File.separator + fileName;
                String realFileName = file.getAbsolutePath();
                System.out.println(" >> 실제경로 : " + realFileName);

                // 파일 리더 생성
                // 버퍼 리더 생성

                try (FileReader fr = new FileReader(realFileName);
                     BufferedReader br = new BufferedReader(fr);
                ) {

                    String lineText = "";
                    int lineNum = 0;

                    // 한행씩 읽음
                    while ( (lineText = br.readLine()) != null) {

                        // 행 카운트 증가
                        lineNum++;

                        // 키워드가 있으면 출력
                        if (lineText.indexOf(keyword) > 0) {
                            
                            // 찾은 횟수 증가
                            found++;

                            System.out.println("[" + realFileName + "(" + lineNum + ")" + "]" + lineText );
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    System.out.println("파일읽기 종료");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("오류");
            }
        }
    }
}
