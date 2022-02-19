package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;

/**
 * Deamon Thread2
 */
@Slf4j
public class Test26 {
    public static void main(String[] args) {
        Test26_1 t1 = new Test26_1("Thread1");
        Test26_2 t2 = new Test26_2("Thread2");

        t1.start();
        t2.start();
    }
}

class Test26_1 extends Thread {
    Test26_1(String name) {
        super(name);
    }

    public void run() {
        try {
            sleep(5 * 1000);    // 5초
        } catch (InterruptedException e) {}
    }
}

@Slf4j
class Test26_2 extends Thread {
    Test26_2(String name) {
        super(name);
    }

    public void run() {
        Map map     = getAllStackTraces();
        Iterator it = map.keySet().iterator();

        int x       = 0;
        while(it.hasNext()) {
            Object obj              = it.next();
            Thread t                = (Thread)obj;
            StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));

            System.out.println(" ["+ ++x + " ] name = " + t.getName()
                    + ", group = " + t.getThreadGroup().getName()
                    + ", daemon = " + t.isDaemon());

            for(int i=0; i<ste.length; i++) {
//                System.out.println("ste[i] === " + ste[i]);
                System.out.println("ste[i] === " + ste[i]);
            }
            System.out.println();
        }
    }
}