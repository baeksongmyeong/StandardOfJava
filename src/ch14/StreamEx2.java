package ch14;

import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {

        // File 배열 생성
        File[] fileArr = new File[]{new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};

        // 스트림 생성
        Stream<File> fs = Arrays.stream(fileArr);

        // 파일 인스턴스들의 스트림에서 파일 이름만 추출하여 String 스트림에 저장
        Stream<String> fns = fs.map(file -> file.getName());

        // 스트림 출력
        fns.forEach(System.out::println);

        System.out.println();

        // 스트림을 다 썼으니 재생성
        fs = Arrays.stream(fileArr);

        // 확장자만 수집하여 스트림으로 만들어서 출력
        fs.map(File::getName).filter(s -> s.indexOf(".") > -1).map(s->s.substring(s.indexOf(".")+1)).map(String::toUpperCase).distinct()
                .forEach(System.out::println);

        //
        IntStream.range(1, 11).mapToObj(i->"값 : " + i)
                .forEach(System.out::println);
    }
}
