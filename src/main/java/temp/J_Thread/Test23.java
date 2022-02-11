package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread 우선순위
 * 실행의 우선순위 설정
 * 쓰레스 우선순위의 범위 : 1 - 10 (숫자가 클수록 우선순위가 높다)
 * 쓰레드를 생성한 쓰레드로부터 우선순위 상속 -> main 메소드를 수행하는 쓰레드의 우선순위 = 5
 * main 메소드 내에서 생성된 쓸게드의 우선순위 = 5
 *
 * Ex.  채팅 내용을 전송하는 thread 가 파일 다운로드 thread 보다 우선되어야 함
 *      파일 다운로드 시간은 더 길어지겠지만, 사용자에게 빠른 반응을 주는 것이 우선
 */
@Slf4j
public class Test23 {
    public static void main(String[] args) {
        ThreadEx8_1 thread1 = new ThreadEx8_1();
        ThreadEx8_2 thread2 = new ThreadEx8_2();

        /**
         * 두 thread 모두 main 에서 생성되었으므로, 우선순위는 동일하게 5
         * 우선순위가 높아지면 먼저 실행 종료될 수 있기 때문에, 아무 동작없는 반복문을 추가하여 작업 지연
         */
        thread2.setPriority(7);

        log.debug("Priority of thread1 === " + thread1.getPriority());
        log.debug("Priority of thread2 === " + thread2.getPriority());

        thread1.start();
        thread2.start();
    }
}

@Slf4j
class ThreadEx8_1 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print("=");
            for(int x=0; x<1000000; x++);
        }
    }
}

@Slf4j
class ThreadEx8_2 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print("|");
            for(int x=0; x<1000000; x++);
        }
    }
}