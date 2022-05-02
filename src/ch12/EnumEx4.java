package ch12;

import java.util.ArrayList;

public class EnumEx4 {
    public static void main(String[] args) {
        // MyTransportation 이 최초로 사용되는 순간, static 변수와 연결되는 인스턴스들도 모두 생성
        MyTransportation bus = MyTransportation.BUS;
        MyTransportation train = MyTransportation.TRAIN;
        MyTransportation ship = MyTransportation.SHIP;
        MyTransportation airplane = MyTransportation.AIRPLANE;
        MyTransportation bus2 = MyTransportation.BUS;

        System.out.println(bus.toString() + ", " + bus.ordinal() + ", " + bus.BASIC_FEE);
        System.out.println(train.toString() + ", " + train.ordinal() + ", " + train.BASIC_FEE);
        System.out.println(ship.toString() + ", " + ship.ordinal() + ", " + ship.BASIC_FEE);
        System.out.println(airplane.toString() + ", " + airplane.ordinal() + ", " + airplane.BASIC_FEE);
        System.out.println(bus2.toString() + ", " + bus2.ordinal() + ", " + bus2.BASIC_FEE);
        System.out.println("bus == bus2 : " + (bus == bus2));
        System.out.println("bus.compareTo(bus2) : " + bus.compareTo(bus2));
        System.out.println("bus.compareTo(train) : " + bus.compareTo(train));
    }
}

//--------------------------------------
// enum 의 기본기능을 가지는 클래스 생성
//--------------------------------------
class MyEnum2<T extends MyEnum2<T>> implements Comparable<T> {

    // id 를 카운트하기 위한 static 변수
    static int id = 0;
    
    // 인스턴스의 id 를 보관하기 위한 인스턴스 상수
    protected final int ordinal;
    
    // 인스턴스의 상수명을 보관하기 위한 인스턴스 상수
    private final String name;

    // 상수 인스턴스 생성자
    MyEnum2(String name) {
        this.name = name;
        this.ordinal = id++;
    }

    // 상수 인스턴스가 사용할 인스턴스 메서드

    // 1. ordinal 반환
    public int ordinal(){return this.ordinal;}

    // 2. name 반환
    public String name(){return this.name;}

    @Override
    public int compareTo(T t) {
        return this.ordinal - t.ordinal;
    }

    @Override
    public String toString(){
        return this.name;
    }
}

//--------------------------------------
// enum 의 기능을 하는 클래스를 상속받아 enum 구현
//--------------------------------------
abstract class MyTransportation extends MyEnum2 {

    static final MyTransportation BUS = new MyTransportation("BUS", 100) {
        @Override
        int fare(int distance) { return this.BASIC_FEE * distance;}
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150){
        @Override
        int fare(int distance) { return this.BASIC_FEE * distance;}
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100){
        @Override
        int fare(int distance) { return this.BASIC_FEE * distance;}
    };
    static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300){
        @Override
        int fare(int distance) { return this.BASIC_FEE * distance;}
    };

    // 상수를 담고 있을 배열
    static ArrayList<MyTransportation> list = new ArrayList<>();
    
    // 기본요금 인스턴스 변수
    protected final int BASIC_FEE;

    // 생성자를 private 로 생성
    public MyTransportation(String name, int basicFee) {
        super(name);
        this.BASIC_FEE = basicFee;
        //list.add(this);
    }

    // 추상메서드. 거리에 따른 요금 계산
    abstract int fare(int distance);
}
