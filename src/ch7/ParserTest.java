package ch7;

interface Parseable{
    // 구현하는 클래스에서 공통적으로 구현해야 할 메서드 선언
    public abstract void parse(String fileName);
}

class XMLParser implements Parseable {
    public void parse(String fileName){ System.out.println(fileName + " - XML parsing completed."); }
}

class HTMLParser implements Parseable {
    public void parse(String fileName){ System.out.println(fileName + " - HTML parsing completed."); }
}

class ParserManager {
    public static Parseable getParser(String type) { // 반환타입이 인터페이스라는 것은, 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 의미이다.
        if(type.equals("XML")){
            return new XMLParser();
        }else{
            Parseable p = new HTMLParser(); // 인터페이스를 구현한 클래스의 인스턴스는 해당 인터페이스의 참조변수로 참조가 가능하다.
            return p;
        }
    }
}

public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML"); // 인터페이스 타입 참조변수로 해당 인터페이스를 구현한 인스턴스를 참조할 수 있다.
        parser.parse("document.xml");
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }
}


