package temp;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread
 */
@Slf4j
public class Test16 {

    public static void main(String[] args) {
        ThreadEx1_1 thread1    = new ThreadEx1_1();

        /**
         * Runnable 인터페이스를 구현한 경우,
         * Runnable 인터페이스를 구현한 클래스의 인스턴스 생성
         * -> 인스턴스를 Thrad 클래스 생성자의 매개변수로 전달해야함
         */
        Runnable runnable       = new ThreadEx1_2();
        Thread thread2          = new Thread(runnable);
//      Thread thread2          = new Thread(new ThreadEx1_2());   -> 위 두줄을 한줄로 정리

        /**
         * start() 를 호출해야면 쓰레드 실행
         * 하나의 쓰레드에서 start()가 한 번만 호출 가능 -> 재실행 불가
         * -> 재실행이 필요하다면 아래와 같이 새로운 쓰레드를 생성하여 실행해야 한다
         * -> ThreadEx1_1 thread1   = new ThreadEx1_1();
         * thread1.start();
         * thread1 = new ThreadEx1_1();
         * thread1.start();
         * 
         * 새로운 쓰레드 생성없이 재실행할 경우, IllegalThreadStateException 발생
         * thread1.start();
         * thread1.start();   -> IllegalThreadStateException 예외
         */

        /**
         * run() 이 아니라 start() 호출인 이유
         * run()    : 쓰레드를 실행시키는 것이 아니라 클레스에 선언된 메소드를 호출할 뿐
         * start()  : 쓰레드가 작업을 실행하는데 필요한 호출스택(call stack) 을 생성한 다음 run() 호출
         *            -> 생성된 호출스택에 run() 이 첫번째로 올라가도록 한다
         */
        thread1.start();
        thread2.start();
    }
}

@Slf4j
class ThreadEx1_1 extends Thread {
    public void run() {
        for(int i=0; i<5; i++) {
            log.debug("ThreadEx1_1   ===" + getName());
        }
    }
}

@Slf4j
class ThreadEx1_2 implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            // Thread.currentThread()   -> 현재 실행중인 thread 반환
            log.debug("currentThread === " + Thread.currentThread());
        }
    }
}

