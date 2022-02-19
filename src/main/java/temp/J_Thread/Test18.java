package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread
 *  호출스택의 위치 = main
 *  ThreadEx3_1 의 run() 메소드를 호출했을 뿐이기 때문에,
 *  새로운 쓰레드는 생성되지 않았다
 *  main 쓰레드에서 에러 발생
 */
public class Test18 {
    public static void main(String[] args) {
        ThreadEx3_1 thread3 = new ThreadEx3_1();

        thread3.run();
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
