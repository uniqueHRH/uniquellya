package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Demon Thread
 * 무한 루프와 조건문을 이요해 실행 후,
 * 대기하고 있다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성
 * 일반 쓰레드와 작성 방법은 동일하며,
 * setDaemon(true) 를 호출하기만 하면 된다
 * .start() 전에 호출해야 한다 -> IllegalThreadStateException 발생
 */
@Slf4j
public class Test25 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread   = new Thread(new Test25());
        thread.setDaemon(true); // 없으면, thread 가 종료되지 않는다. 무한루프
        thread.start();

        for(int i=1; i<=10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            log.debug("i === " + i);

            if(i == 5) autoSave = true;
        }
        log.debug("프로그램을 종료합니다");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3 * 1000); // 3초마다
            } catch (InterruptedException e) {}
            // autoSave의 값이 true 이면 autoSave() 호출
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        log.debug("작업파일이 자동저장 되었습니다.");
    }
}
