package ch11;

import java.util.Enumeration;
import java.util.Properties;

/*
* Properties 는 과거의 컬렉션 클래스인 HashTable 을 상속받아 확장한 클래스이다.
* String, String 형태로 키와 값을 저장한다.
* 설정파일을 읽어서 저장하는데 주로 사용된다.
* 문자 인코딩을 메서드에서 지정할 수 있다. (한글 사용이 편리)
* */
public class PropertiesEx1 {
    public static void main(String[] args) {

        // Properties 클래스의 인스턴스 생성
        Properties prop = new Properties();

        // setProperties(String, String) : Properties 인스턴스에 요소 추가
        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        // Properties 클래스는 컬렉션 프레임웍이 나오기 전부터 있던 클래스
        // 컬렉션 인터페이스에서 지원하는 Iterator 가 없다.
        // 대신 Enumration 를 지원한다.
        Enumeration e = prop.propertyNames();

        // getProperty(String) : Properties 인스턴스 값 조회
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println(key + "=" + prop.getProperty(key));
        }
        System.out.println();

        // setProperty(String, String) : Properties 인스턴스의 값 변경
        prop.setProperty("size", "20");
        System.out.println(prop.getProperty("size"));
        System.out.println("capacity=" + prop.getProperty("capacity", "20"));
        System.out.println("loacfactor=" + prop.getProperty("loacfactor", "0.75"));
        System.out.println();


        System.out.println(prop);
        System.out.println();
        
        // list(출력스트림) : Properties 인스턴스에 저장된 요소들을 모두 출력
        prop.list(System.out);
    }
}
