package temp.J_Thread;

import javax.swing.*;

/**
 * Thread
 * 두 쓰레드가 서로 다ㅇ른 자원을 사용하는 경우, 싱글쓰레드보다 멀티 쓰레드가 더 효율적이다
 * EX.  사용자에게 데이터를 입력받는 경우
 *      프린터로 파일 출력하는 작업 -> 외부 기기와의 입출력
 *      네트워크로 파일 주고받는 작업
 * => 이러한 작업들이 끝나기 전에 다른 행동을 할 수 없다
 *
 * 유저가 입력을 끝내기 전에 for문은 별도로 동작한다 = 병행
 */
public class Test22 {
    public static void main(String[] args) {
        ThreadEx7_1 thread7 = new ThreadEx7_1();
        thread7.start();

        String input        = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다");
    }
}

class ThreadEx7_1 extends Thread {
    public void run() {
        for(int i=10; i>0; i--) {
            System.out.println("i === " + i);
            try {
                sleep(1000);
            } catch(Exception e) {

            }
        }
    }
}
