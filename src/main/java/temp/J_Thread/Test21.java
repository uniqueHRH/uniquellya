package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

/**
 * Thread
 * 두 쓰레드가 서로 다른 자원을 사용하는 경우, 싱글쓰레드보다 멀티 쓰레드가 더 효율적이다
 * EX.  사용자에게 데이터를 입력받는 경우
 *      프린터로 파일 출력하는 작업 -> 외부 기기와의 입출력
 *      네트워크로 파일 주고받는 작업
 * => 이러한 작업들이 끝나기 전에 다른 행동을 할 수 없다
 *
 * 유저가 입력을 끝내기 전까지 for문은 동작하지 않는다
 */
@Slf4j
public class Test21 {
    public static void main(String[] args) throws InterruptedException {
        String input    = JOptionPane.showInputDialog("아무값이나 입력하세요");
        log.debug("입력값 === " + input);

        for(int i=10; i>0; i--) {
            log.debug("i === " + i);
            try {
                Thread.sleep(1000); // 1초간 시간 지연
            } catch (Exception e) {

            }
        }
    }
}
