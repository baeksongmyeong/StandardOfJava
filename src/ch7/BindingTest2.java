package ch7;

/*

 */
public class BindingTest2 {
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        Parent1 parent1 = new Child1();

        System.out.println(child1.x);
        child1.method();
        System.out.println(parent1.x);
        parent1.method();
    }

}

class Parent1 {
    int x = 100;
    void method(){
        System.out.println("Parent Method");
    }
}

class Child1 extends Parent1 {

}
