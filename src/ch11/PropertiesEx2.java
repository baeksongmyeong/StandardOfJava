package ch11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
* load(인풋스트림) : 인풋스트림을 읽어서 Properties 인스턴스에 저장
* 파일 내 키와 값은 키=값#주석 형태여야 한다.
* 한글을 읽는 경우, 인코딩을 설정해줘야 한다
*   - new String(Properties인스턴스.getProperty(String).getBytes("8859_1"), "EUC-KR"))
*
* */
public class PropertiesEx2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java PropertiesEx2 INPUTFILENAME");
            System.exit(0);
        }
        Properties prop = new Properties();
        String inputFile = args[0];
        try {
            prop.load(new FileInputStream(inputFile));
        } catch (IOException e) {
            System.out.println("지정된 파일을 찾을수 없습니다.");
            System.exit(-1);
        }
        String name = prop.getProperty("name");
        String[] data = prop.getProperty("data").split(",");
        int max = 0, min = 0;
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            int intValue = Integer.valueOf(data[i]);
            if (i == 0) max = min = intValue;
            if (max < intValue) max = intValue;
            if (min > intValue) min = intValue;
            sum += intValue;
        }
        System.out.println("이름 : "+name);
        System.out.println("최대값 : "+max);
        System.out.println("최소값 : "+min);
        System.out.println("합계 : "+sum);
        System.out.println("평균 : "+(float)sum / data.length);
    }
}
