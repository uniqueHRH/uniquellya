package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Control Thread
 * [ suspend / resume / stop ] -> Thread 중지와 종료
 * suspend()    : Thread 일시중지 (sleep 과 동일한 동작)
 * resume()     : suspend() 로 중지된 Thread 가 다시 실행대기 상태가 된다
 * stop()       : Thread 즉시 중지
 *
 * suspend() 와 stop() 이 교착상태(deadlock)를 일으키기 쉽기 때문에 사용은 권장하지 않는다 -> API 문서에서 'deprecated' 로 기재
 * Test30 을 보다 간략한 코드로 작성
 */
@Slf4j
public class Test31 {
    public static void main(String[] args) {
        Test31_1 th1    = new Test31_1("*");
        Test31_1 th2    = new Test31_1("**");
        Test31_1 th3    = new Test31_1("***");

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
class Test31_1 implements Runnable {
    boolean suspended   = false;
    boolean stopped     = false;

    Thread th;

    Test31_1(String name) {
        th  = new Thread(this, name);   // Thread(Runnable r, String name);
    }

    @Override
    public void run() {
        while(!stopped) {
            if(!suspended) {
                log.debug("Thread.currentThread().getName()" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
        log.debug(Thread.currentThread().getName() + " -stopped");
    }
    public void suspend()   { suspended = true;     }
    public void resume()    { suspended = false;    }
    public void stop()      { stopped   = true;     }
    public void start()     { th.start();           }
}