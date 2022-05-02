package ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* Collections 클래스의 sort() 메서드는 매개변수가 아래와 같이 되어 있다.
*   - sort( List<E>, Comparator<? super E> )
*   - 이 의미는
*   - 1. List 에는 E 타입의 인스턴스들이 저장되어 있으며
*   - 2. Comparator 에는 E 타입을 포함하여, E 타입보다 조상인 클래스들이 적용된 클래스이면 된다는 것이다.
*   - class FruitComparator implements Comparator<Fruit>{}
*   - 위의 클래스를 ArrayList<Apple>, ArrayList<Grape> 형태의 자손 클래스들을 담고 있는 컬렉션들의 sort() 에 사용할 수 있다.
*
* */
public class FruitBoxEx4 {
    public static void main(String[] args) {
        
        // 사과박스 생성
        FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();

        // 포도박스 생성
        FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();

        // 사과박스에 사과 추가
        appleBox.add(new Apple3("GreenApple", 300));
        appleBox.add(new Apple3("GreenApple", 100));
        appleBox.add(new Apple3("GreenApple", 200));
        
        // 포도박스에 포도 추가
        grapeBox.add(new Grape3("GreenGrape", 400));
        grapeBox.add(new Grape3("GreenGrape", 300));
        grapeBox.add(new Grape3("GreenGrape", 200));

        // 사과용 Comparator 로 사과상자 내 사과를 무게순 정렬
        System.out.println(appleBox);
        Collections.sort(appleBox.getList(), new AppleComparator()); // 내림차순
        System.out.println(appleBox);

        System.out.println();

        // 포도용 Comparator 로 포도상자 내 포도를 무게순 정렬
        System.out.println(grapeBox);
        Collections.sort(grapeBox.getList(), new GrapeComparator()); // 내림차순
        System.out.println(grapeBox);

        System.out.println();

        // 사과의 조상인 과일용 Comparator 로 사과상자 내 사과를 무게순 정렬
        Collections.sort(appleBox.getList(), new FruitComparator());
        System.out.println(appleBox);

        // 포도의 조상인 과일용 Comparator 로 포도상자 내 포도를 무게순 정렬
        Collections.sort(grapeBox.getList(), new FruitComparator());
        System.out.println(grapeBox);
    }
}

//----------------------------------
// 과일 관련 클래스들
//----------------------------------

// 과일
class Fruit3 {
    String name;
    int weight;
    public Fruit3(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    @Override public String toString(){ return name + "(" + weight + ")";}
}

// 사과
class Apple3 extends Fruit3 { public Apple3(String name, int weight){super(name, weight);}}

// 포도
class Grape3 extends Fruit3 { public Grape3(String name, int weight){super(name, weight);}}

//----------------------------------
// Comparator 구현 클래스들
//----------------------------------

// 과일 Comparator
class FruitComparator implements Comparator<Fruit3> {
    @Override
    public int compare(Fruit3 o1, Fruit3 o2) { return o1.weight < o2.weight ? -1 : 1; }
}

// 사과 Comparator
class AppleComparator implements Comparator<Apple3> {
    @Override
    public int compare(Apple3 o1, Apple3 o2) { return o1.weight > o2.weight ? -1 : 1; }
}

// 포도 Comparator
class GrapeComparator implements Comparator<Grape3> {
    @Override
    public int compare(Grape3 o1, Grape3 o2) { return o1.weight > o2.weight ? -1 : 1; }
}

//----------------------------------
// 박스 관련 클래스들
//----------------------------------

// 박스 클래스
class Box3<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int index){return list.get(index);}
    ArrayList<T> getList(){return list;}
    int size(){return list.size();}
    @Override public String toString(){return list.toString();}
}

// 과일박스 클래스
class FruitBox3<T extends Fruit3> extends Box3<T> { }