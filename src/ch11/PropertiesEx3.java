package ch11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
* store(OutputStream, String) 형태로 출력스트림에 Properties 인스턴스의 키, 값을 저장할 수 있다.
* 한글을 저장하는 경우, 인코딩 문제가 발생하는데, storeToXML 은 한글을 정상적으로 내보낼수 있다.
* */
public class PropertiesEx3 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("timeout", "30");
        prop.setProperty("language", "한글");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");
        try {
            prop.store(new FileOutputStream("output.txt"), "Properties Example");
            prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
