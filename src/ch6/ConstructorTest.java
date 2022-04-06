package ch6;

public class ConstructorTest {
    public static void main(String[] args) {
        Data4 data4 = new Data4();
        //Data5 data5 = new Data5(); // 컴파일 오류 발생. 코딩한 생성자가 있어서 기본 생성자를 컴파일러가 자동으로 추가하지 않음.
    }
}

class Data4 {
    int value;
}

class Data5 {
    int value;
    // 생성자. 인스턴스 초기화 용도
    Data5(int x) { value = x; }
}


