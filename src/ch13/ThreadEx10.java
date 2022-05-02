package ch13;

/*
* 데몬 쓰레드
*   - 일반 쓰레드들의 작업을 보조해주기 위한 쓰레드
*   - 일반 쓰레드들이 모두 종료되면 자동으로 종료된다
*   - setDaemon(true) 메서드를 start() 메서드 호출전에 호출해야 한다.
*   - 프로그램 시작시 JVM 은 여러가지의 데몬 쓰레드를 생성 및 실행시키며, 가비지 컬렉터가 여기에 속한다.
*   - 아래 예제는 데몬 쓰레드는 무한루프이지만, 일반 쓰레드가 종료되면서 자동으로 종료되는 것을 보여주고 있다.
* */
public class ThreadEx10 implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {

        // Runnable 인스턴스 생성
        Runnable r = new ThreadEx10();

        // 쓰레드 생성
        Thread t = new Thread(r);

        // 쓰레드를 데몬 쓰레드로 변경
        t.setDaemon(true);
        
        // 데몬 쓰레드를 실행
        t.start();
        
        // 메인 메서드의 쓰레드를 계속 진행

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%d%n", i);
            if (i == 5) {
                ThreadEx10.autoSave = true;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3*1000); // 3초마다
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
