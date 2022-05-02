package ch12;

abstract class Direction extends MyEnum {

    // static 상수로 인스턴스 생성 및 추상 메서드를 익명 클래스로 구현
    static final Direction EAST = new Direction("EAST") {
        @Override Point move(Point p) {return null;}
    };

    static final Direction SOUTH = new Direction("SOUTH") {
        @Override Point move(Point p) {return null;}
    };

    static final Direction WEST = new Direction("WEST") {
        @Override Point move(Point p) {return null;}
    };

    static final Direction NORTH = new Direction("NORTH") {
        @Override Point move(Point p) {return null;}
    };

    // 생성자. 상수명 입력
    private Direction(String name) {
        super(name);
    }

    // 추상메서드. 상수에서 구현해야 한다.
    abstract Point move(Point p);
}

class Point {}
