package ch6;

public class DocumentTest {
}

class Document {

    // 클래스 변수
    static int count = 0;

    // 클래스 초기화 블록
    static {
    }

    // 인스턴스 변수
    String name;

    // 인스턴스 초기화 블록
    {
    }

    // 생성자
    Document(String name){
        this.name = name;
        System.out.printf("문서 %s 가 생성되었습니다.%n", this.name);
    }

    Document() {
        this("제목없음" + (++count));
    }

    public static void main(String[] args) {
        new Document();
        new Document("자바.txt");
        new Document();
        new Document();
    }

}
