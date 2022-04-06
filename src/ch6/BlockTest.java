package ch6;

public class BlockTest {
    
    // 클래스 초기화 블록
    static{
        System.out.println("클래스 초기화 블록");
    }

    // 인스턴스 초기화 블록
    {
        System.out.println("인스턴스 초기화 블록");
    }

    BlockTest(){
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("첫번째 객체 생성");
        BlockTest bt = new BlockTest();
        System.out.println("두번째 객체 생성");
        BlockTest bt2 = new BlockTest();
    }
}


