package ch13;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
    public static void main(String[] args) {
        // 쓰레드 생성
        ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
        ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
        
        // 쓰레드 실행
        t1.start();
        t2.start();
    }
}

class ThreadEx11_1 extends Thread {

    public ThreadEx11_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadEx11_2 extends Thread {

    public ThreadEx11_2(String name) {
        super(name);
    }

    @Override
    public void run() {
        Map<Thread, StackTraceElement[]> map = getAllStackTraces();
        Iterator<Thread> it = map.keySet().iterator();

        int x = 0;
        while (it.hasNext()) {
            Thread t = it.next();
            StackTraceElement[] ste = map.get(t);
            System.out.println("[" + (++x + "]"
                    + " name = " + t.getName()
                    + ", group = " + t.getThreadGroup().getName()
                    + ", isDaemon = " + t.isDaemon()
            ));
            for (StackTraceElement s : ste) {
                System.out.println(t);
            }

        }
    }
}