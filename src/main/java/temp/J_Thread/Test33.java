package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Control Thread
 * [ join ] -> 다른 Thread 의 작업에 대기
 *
 * sleep() 과 비슷하며, interrupt() 에 의해 대기상태에서 벗어날 수 있다 
 * sleep() 과의 차이는, join() 은 현재 Thread 가 아닌 특정 Thread 에 대해 동작하므로 static 메소드가 아니다
 */
@Slf4j
public class Test33 {
    static long startTime   = 0;

    public static void main(String[] args) {
        Test22_1 t1 = new Test22_1();
        Test22_2 t2 = new Test22_2();

        t1.start();
        t2.start();

        startTime   = System.currentTimeMillis();

        /**
         * 여기서 join() 을 호출하지 않는다면,
         * main Thread 가 먼저 종료되면서 소요시간을 구할 수 없다
         */
        try {
            t1.join();  // main 쓰레드가 t1의 작업이 끝날 때까지 기다린다
            t2.join();  // main 쓰레드가 t2의 작업이 끝날 때까지 기다린다
        } catch (InterruptedException e) {}

        log.debug("소요시간 === " + (System.currentTimeMillis() - Test33.startTime));
    }
}

class Test22_1 extends Thread {
    public void run() {
        for (int i=0; i<300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class Test22_2 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print(new String("|"));
        }
    }
}