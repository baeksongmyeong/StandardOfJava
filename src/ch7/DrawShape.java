package ch7;

/*-----------------------------------------------
바탕이 되는 2개의 클래스. Shape(도형), Point(점)
-----------------------------------------------*/
class Shape {
    // 클래스 변수
    // 인스턴스 변수
    String color = "black";
    // 클래스 초기화 블럭
    static {}
    // 인스턴스 초기화 블럭
    {}
    // 생성자
    Shape(){}
    // 클래스 메서드

    // 인스턴스 메서드
    void draw(){
        System.out.printf("[color=%s]%n", color);
    }
}

class Point {
    // 클래스 변수
    // 인스턴스 변수
    int x, y;
    // 클래스 초기화 블록
    // 인스턴스 초기화 블록
    // 생성자
    Point(){ this(0, 0); }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 클래스 메서드
    // 인스턴스 메서드
    String getXY(){
        return "(" + x + ", " + y + ")";
    }
}

/*-----------------------------------------------
원은 도형이다. >> 도형 클래스를 상속한 원 클래스
원은 도형을 가지고 있다. >> X
원은 점이다. >> X
원은 점을 가지고 있다. >> 점 클래스를 포함한 원 클래스
-----------------------------------------------*/
class Circle extends Shape { // 클래스간 상속관계
    // 클래스 변수
    // 인스턴스 변수
    Point center; // 클래스간 포함관계
    int r; // 반지름
    // 클래스 초기화 블록
    // 인스턴스 초기화 블록
    // 생성자
    Circle(){

    }
    Circle(Point center, int r){

    }
    // 클래스 메서드
    // 인스턴스 메서드
}




public class DrawShape {
}
