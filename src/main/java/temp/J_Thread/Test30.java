package temp.J_Thread;

/**
 * Control Thread
 * [ suspend / resume / stop ] -> Thread 중지와 종료
 * suspend()    : Thread 일시중지 (sleep 과 동일한 동작)
 * resume()     : suspend() 로 중지된 Thread 가 다시 실행대기 상태가 된다
 * stop()       : Thread 즉시 중지
 *
 * suspend() 와 stop() 이 교착상태(deadlock)를 일으키기 쉽기 때문에 사용은 권장하지 않는다 -> API 문서에서 'deprecated' 로 기재
 * Test31 에서 보다 간략한 코드로 작성 -> 비교
 */
public class Test30 {
    /**
     * 각 Thread 가 다른 실행상태를 가져야 하므로,
     * 각각의 RunnableImpl2 객체를 가진다
     */
    public static void main(String[] args) {
        RunnableImpl2 r1    = new RunnableImpl2();
        RunnableImpl2 r2    = new RunnableImpl2();
        RunnableImpl2 r3    = new RunnableImpl2();

        Thread t1           = new Thread(r1, "*");
        Thread t2           = new Thread(r1, "**");
        Thread t3           = new Thread(r1, "***");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000);
            r1.suspend();
            Thread.sleep(2000);
            r2.suspend();
            Thread.sleep(3000);
            r1.resume();
            Thread.sleep(3000);
            r1.stop();
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch(InterruptedException e) {}
    }
}

class RunnableImpl2 implements Runnable {
    boolean suspended   = false;
    boolean stopped     = false;

    @Override
    public void run() {
        while(!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");
    }
    public void suspend()   { suspended = true;     }
    public void resume()    { suspended = false;    }
    public void stop()      { stopped   = true;     }
}