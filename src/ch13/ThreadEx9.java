package ch13;

/*
* 쓰레드는 쓰레드 그룹에 반드시 포함되어야 한다.
* 쓰레드 그룹 : 연관있는 쓰레드들을 모아놓는 그룹
* 쓰레드 그룹은 하위 쓰레드 그룹을 가질수 있다.
* 프로그램 구동시 JVM 은 2개의 쓰레드 그룹을 만들고 그 안에서 쓰레드들을 관리한다
*   1. main 쓰레드 그룹
*       - 사용자를 위한 쓰레드 그룹의 최상위
*       - main 메서드를 처리하는 main 쓰레드가 이 그룹에 포함된다
*       - 사용자가 만든 쓰레드 중 그룹을 지정하지 않으면 이 그룹에 포함된다.
*       - 사용자가 만든 쓰레드 그룹은 이 그룹의 하위 그룹이 된다.
*   2. System 쓰레드 그룹
* 
* */
public class ThreadEx9 {
    public static void main(String[] args) {
        // 현재 쓰레드(메인 쓰레드)가 속한 쓰레드 그룹을 참조
        ThreadGroup main = Thread.currentThread().getThreadGroup();

        // 쓰레드 그룹 생성
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

        // 하위 쓰레드 그룹을 생성
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");

        // 쓰레드 그룹의 최대 우선순위를 변경
        grp1.setMaxPriority(3);

        // Runnable 인터페이스 구현
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 쓰레드 그룹을 지정하여 쓰레드 생성
        new Thread(grp1, r, "th1").start();
        new Thread(subGrp1, r, "th2").start();
        new Thread(grp2, r, "th3").start();

        // 쓰레드 정보 출력
        System.out.println(">> List of ThreadGroup : " + main.getName()
                + ", Active ThreadGroup : " + main.activeGroupCount()
                + ", Active Thread : " + main.activeCount()
        );

        main.list();

    }
}
