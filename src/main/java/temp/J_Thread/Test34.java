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
public class Test34 {
    public static void main(String[] args) {
        Test34_1 t1 = new Test34_1();
        t1.setDaemon(true);
        t1.start();

        log.debug("========== t1 실행 ==========");
        int requiredMemory  = 0;

        for(int i=0; i<20; i++) {
            requiredMemory  = (int) (Math.random() * 10) * 20;
            log.debug("========== 반복문 수행중 ==========");
            // 필요만 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60% 이상을 사용했을 경우, t1을 깨운다
            if(t1.freeMemory() < requiredMemory
                    || t1.freeMemory() < t1.totalMemory() * 0.4) {
                log.debug("========== 메모리가 적다 / interrupt 실행 ==========");
                t1.interrupt(); // 잠든 t1 Thread 깨운다

                try {
                    log.debug("========== join 실행 ==========");
                    t1.join(100);
                } catch (InterruptedException e) {}
            }
            t1.usedMemory += requiredMemory;
            log.debug("usedMemory === " + t1.usedMemory);
        }
    }
}

@Slf4j
class Test34_1 extends Thread {
    final static int MAX_MEMORY = 1000;
    int usedMemory              = 0;

    public void run() {
    log.debug("========== run 실행 ==========");
        while(true) {   // interrupt() 실행 시 false()
            try {
                log.debug("========== Thread sleep ==========");
                Thread.sleep(10 * 1000);    // 10초 대기
            } catch (InterruptedException e) {
                log.debug("Awaken by interrupt()");
            }
        gc();
        log.debug("Garbage Collection. Free Memory === " + freeMemory());
        }
    }

//  Garbage Collection 수행
    public void gc() {
        log.debug("========== gc 실행 ==========");
        usedMemory  -= 300;
        if(usedMemory < 0)  usedMemory = 0;
    }
    public int totalMemory() {return MAX_MEMORY;                }
    public int freeMemory() { return MAX_MEMORY - usedMemory;   }
}