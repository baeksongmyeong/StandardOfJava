package ch11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Object> pq = new PriorityQueue<>();
        Person a = new Person(10, "A");
        Person b = new Person(20, "B");
        Person c = new Person(15, "C");
        Person d = new Person(40, "D");
        Person e = new Person(5, "E");
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        pq.offer(d);
        pq.offer(e);
        //System.out.println(pq);

        // 저장순서가 아닌 우선순위로 가져와지는지 확인
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

class Person implements Comparable{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person) o;
            //System.out.printf("this.age = %d, Person.age = %d%n", this.age, p.age);
            return this.age > p.age ? 1 : 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
