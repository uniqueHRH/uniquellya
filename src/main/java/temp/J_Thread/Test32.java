package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Control Thread
 * [ yield ] -> 다른 Thread 에게 양보
 *
 * 스케쥴러에 의해 1초의 시간을 할당받은 Thread 가 0.5초의 시간을 사용,
 * yield() 호출이 되면 남은 0.5초는 포기하고 실행대기상태가 된다
 * yield() 와 interrupt() 를 적절히 사용하면, 프로그램의 응답성을 높이고 보다 효율적은 실행이 가능하다
 */
@Slf4j
public class Test32 {
    public static void main(String[] args) {
        Test32_1 th1    = new Test32_1("*");
        Test32_1 th2    = new Test32_1("**");
        Test32_1 th3    = new Test32_1("***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {}
    }
}

@Slf4j
class Test32_1 implements Runnable {
    boolean suspended   = false;
    boolean stopped     = false;

    Thread th;
    Test32_1(String name) {
        th  = new Thread(this, name);   // Thread(runnable r, String name)
    }

    @Override
    public void run() {
        String name = th.getName();

        while(!stopped) {
            if(!suspended) {                // suspended == false
                log.debug("name === " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.debug(name + " - interrupted");
                }
            } else {                        // suspended == true
                Thread.yield();             // 일시정지일 경우 의미없는 반복문을 돌 수 있기 때문에, yield를 추가해 다른 Thread에게 양보
            }
        }
        log.debug(name + " - stopped");
    }

    /**
     * suspend() & stop()
     * -> sleep(1000) 이 걸려있으면,
     * 메소드가 호출되더라도 1초의 지연시간이 발생한다
     * 따라서, interrupt() 를 호출함으로써 남의 시간을 while 문에서 돌지 않고
     * 바로 동작 수행
     */
    public void suspend()   {
        suspended = true;
        th.interrupt();
        log.debug(th.getName() + " - interrupt() by suspend()");
    }
    public void stop()      {
        stopped   = true;
        th.interrupt();
        log.debug(th.getName() + " - interrupt() by stop()");
    }
    public void resume()    { suspended = false;    }
    public void start()     { th.start();           }
}