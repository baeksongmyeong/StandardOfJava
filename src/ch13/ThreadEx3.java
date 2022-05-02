package ch13;


/*
* 쓰레드의 start() 메서드가 아닌 run() 메서드를 호출하는 경우, 쓰레드가 생성되지 않는다.
* 쓰레드가 생성되지 않으므로, 호출스택도 생성되지 않는다.
* 결국, run() 메서드가 아닌 start() 메서드를 호출해야 쓰레드 및 호출스택이 생성된다는 의미이다.
*
* */
// Thread 를

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t = new ThreadEx3_1();

        // 생성된 쓰레드의 start() 메서드가 아닌, run() 메서드를 호출하면 쓰레드가 생성되지 않는다.
        //t.start();
        t.run();
    }
}

class ThreadEx3_1 extends Thread {
    @Override
    public void run() {
        throwException();
    }

    public void throwException(){
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



