package ch8;

/*
* 2개의 예
* 첫번째는 close 에서 예외 발생
* 두번째는 close 전에 예외 발생 및 close 에서 예외 발생
* */
public class TryWithResourceEx {
    public static void main(String[] args) {
        try(CloseableResource cr = new CloseableResource()){
            cr.exceptionWork(false);
        }catch(WorkException e){
            System.out.println("WorkException 처리 1");
            e.printStackTrace();
        }catch (CloseException e){
            System.out.println("CloseException 처리 1");
            e.printStackTrace();
        }
        System.out.println();

        try(CloseableResource cr = new CloseableResource()){
            cr.exceptionWork(true);
        }catch(WorkException e){
            System.out.println("WorkException 처리 2");
            e.printStackTrace();
        }catch(CloseException e){
            // 여기로는 들어오지 않는다. 왜냐하면 예외는 프로그램에서 하나만 있을수 있고, 주된 예외로 WorkException 이 설정되었기 때문이다.
            // CloseException 은 발생하긴 했지만, WorkException 이 그 정보를 가지고 있게된다.
            // WorkException 의 정보를 출력하면 Suppressed 라는 머리말로 CloseException 의 발생 정보를 볼 수 있다.
            System.out.println("CloseException 처리 2");
            e.printStackTrace();
        }
    }

}

/* 자동으로 close 를 하기 위해서는 AutoCloseable 인터페이스를 구현해야 한다. */
class CloseableResource implements AutoCloseable {

    public void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork(" + exception + ") 가 호출됨");
        if(exception) throw new WorkException("WorkException 발생!!!");
    }

    @Override
    public void close() throws CloseException {
        System.out.println("close() 가 호출됨");
        throw new CloseException("CloseException 발생!!!");
    }
}

class WorkException extends Exception {
    WorkException(String msg){ super(msg); }
}

class CloseException extends Exception {
    CloseException(String msg){ super(msg); }
}
