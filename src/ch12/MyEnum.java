package ch12;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    
    // 상수 선언 순서 카운트용 static 변수
    static int id = 0;

    // 상수 인스턴스의 선언 순서
    int ordinal;
    
    // 상수 인스턴스의 상수명
    String name;

    // 상수 인스턴스 생성
    // 상수명을 넣어주고, 상수선언순서를 1 증가시켜 인스턴스에 배정한다.
    MyEnum(String name) {
        this.name = name;
        this.ordinal = MyEnum.id++;
    }

    // 상수 인스턴스의 선언 순서 반환
    public int ordinal(){return this.ordinal;}

    // 상수 인스턴스의 상수명 반환
    public String name(){return this.name;}

    // 상수 인스턴스간에 비교
    // 현재는 값을 따로 설정하지 않았으니, ordinal 값밖에 비교할 대상이 없다.
    @Override
    public int compareTo(T t) {
        return this.ordinal - t.ordinal();
    }
}
