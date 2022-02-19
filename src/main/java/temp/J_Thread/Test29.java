package temp.J_Thread;

/**
 * Control Thread
 * [ suspend / resume / stop ] -> Thread 중지와 종료
 * suspend()    : Thread 일시중지 (sleep 과 동일한 동작)
 * resume()     : suspend() 로 중지된 Thread 가 다시 실행대기 상태가 된다
 * stop()       : Thread 즉시 중지
 * 
 * suspend() 와 stop() 이 교착상태(deadlock)를 일으키기 쉽기 때문에 사용은 권장하지 않는다 -> API 문서에서 'deprecated' 로 기재
 * -> 이 예제는 간단하기 때문에 문제없이 동작한다
 */
public class Test29 {
    public static void main(String[] args) {
        RunnableImpl runnable   = new RunnableImpl();
        Thread t1               = new Thread(runnable, "*");
        Thread t2               = new Thread(runnable, "**");
        Thread t3               = new Thread(runnable, "***");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            t1.suspend();
            Thread.sleep(2000);
            t2.suspend();
            Thread.sleep(3000);
            t1.resume();    // 바로 실행되지 않고, 실행 대기상태가 된단
            Thread.sleep(3000);
            t1.stop();
            t2.stop();
            Thread.sleep(2000);
            t3.stop();
        } catch (InterruptedException e) {}
    }
}

class RunnableImpl implements Runnable {
    @Override
    public void run() {
        while(true) {
//            System.out.println("Thread name === " + Thread.currentThread().getName());
            System.out.println("Thread name === " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}