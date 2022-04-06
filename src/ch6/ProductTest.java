package ch6;

public class ProductTest {

    // 클래스 변수
    static long count = 0;

    // 클래스 초기화 블록
    static {}

    // 인스턴스 변수
    long serialNo = 0;

    // 인스턴스 초기화 블록
    {
        count++;
        this.serialNo = count;
    }

    // 생성자
    ProductTest(){}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("serialNo : " + new ProductTest().serialNo);
        }
        System.out.printf("총 Product 개수 : " + ProductTest.count);
    }
}
