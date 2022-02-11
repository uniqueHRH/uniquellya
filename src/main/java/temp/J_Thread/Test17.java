package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread
 * 호출스택의 위치 = run
 * 새로운 쓰레드를 생성한 후 main 쓰레드는 종료되었기 때문에,
 * run 쓰레드에서 에러 발생
 */
@Slf4j
public class Test17 {
    public static void main(String[] args) {
        ThreadEx2_1 tread1  = new ThreadEx2_1();
        tread1.start();
    }
}

@Slf4j
class ThreadEx2_1 extends Thread {
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
