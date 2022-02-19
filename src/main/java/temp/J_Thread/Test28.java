package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

/**
 * Control Thread2
 * [ interrupt / interrupted ] -> Thread 작업 취소
 *          void    interrupt()     : Thread 의 interrupted 상태를 false 에서 true 로 변경
 *          boolean isInterrupted() : Thread 의 interrupted 상태를 반환
 * static   boolean interrupted()   : 현재 Thread 의 interrupted 상태를 반환 후, false 로 변경
 */
@Slf4j
public class Test28 {
    public static void main(String[] args) {
        Test28_1 t1 = new Test28_1();
        t1.start();

        String input    = JOptionPane.showInputDialog(("아무 값이나 입력하세요"));
        System.out.println("입력값은 [ " + input + " ] 입니다");
        t1.interrupt(); // interrupt()를 호출하면, interrupted 상태가 true 로 전환
        System.out.println("isInterrupted() === " + t1.isInterrupted());
        System.out.println("isInterrupted() === " + t1.isInterrupted());
    }
}

@Slf4j
class Test28_1 extends Thread {
    /**
     * for 문으로 시간을 지연시킬 때 : 입력이 끝나면 Thread 는 즉시 종료된다 -> isInterrupted() 는 true
     * sleep 문으로 시간을 지연시킬 때 : sleep() 에 의해 Thread 일시정지 중, interrupt()를 호출하면
     *                              InterruptedException 이 발생되고, Thread 의 상태는 false 로 자동 초기화되며 끝까지 카운트한다
     *                              -> isInterrupted() 는 false
     *                              -> 너무 빠르게 호출하면 true 로 출력되기도
     *                              catch 문에 interrupt(); 를 추가하면, 예외 상황에 강제 종료가 가능하다
     * 
     * for / sleep 바꿔가며 테스트
     */
    public void run() {
        int i   = 10;
        while(i != 0 && !isInterrupted()) {
            System.out.println("i === " + i--);

//            for(long x=0; x<2500000000L; x++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("카운트가 종료되었습니다");
    }
}