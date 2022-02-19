package temp.J_Thread;

/**
 * Thread
 * 싱글 쓰레드 수행 시간
 */
public class Test20 {
    static long startTime   = 0;

    public static void main(String[] args) {
        ThreadEx5_1 thread5 = new ThreadEx5_1();
        thread5.start();

        startTime           = System.currentTimeMillis();

        for(int i=0; i<300; i++) System.out.printf("%s", new String("="));
        System.out.println("소요시간1 === "+(System.currentTimeMillis() - Test20.startTime));
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) System.out.printf("%s", new String("|"));
        System.out.println("소요시간2 === "+(System.currentTimeMillis() - Test20.startTime));
    }
}

// 소요시간1 === 66
// 소요시간1 === 83