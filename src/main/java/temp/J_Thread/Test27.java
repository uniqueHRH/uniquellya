package temp.J_Thread;

/**
 * Control Thread
 * [ sleep ] -> Thread 일시정지
 */
public class Test27 {
    public static void main(String[] args) {
        Test27_1 t1 = new Test27_1();
        Test27_2 t2 = new Test27_2();

        t1.start();
        t2.start();

        /**
         * sleep은 현재 실행중인 쓰레드에 동작하므로 t1.sleep(2000) 으로 호출하더라도,
         * main 쓰레드에 동작한다
         * 그래서 sleep()은 static으로 선언되어 있으며,
         * 참조변수를 이용해 호출하기 보다는 Thread.sleep(2000); 과 같이 해야 한다
         */
        try {
//            t1.sleep(1000 * 1000);    // main 에 동작
            Test27_1.sleep(1000 * 10);  // t1 Thread 에 동작
        } catch (InterruptedException e) {}

        System.out.println("<< MAIN END >>");
    }
}


class Test27_1 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) System.out.print("=");
        System.out.print("<< t1 종료 >>");
    }
}

class Test27_2 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) System.out.print("|");
        System.out.print("<< t2 종료 >>");
    }
}