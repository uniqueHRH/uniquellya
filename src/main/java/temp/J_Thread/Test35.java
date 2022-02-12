package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Control Thread
 * Synchronized
 */
public class Test35 {
    public static void main(String[] args) {
        Runnable runnable   = new Test35Runnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

/**
 * synchronized 를 사용하지 않은 메소드를 실행하면 결과값이 음수가 된다
 * 한 쓰레드가 if 조건식을 통과하고 출금하기 직전에
 * 다른 쓰레드가 끼어들어 먼저 출금했기 때문
 */
class Account {
    /**
     * private int balance;
     * private 으로 해야 동기화가 의미 있다
     * synchronized 는 동기화로 한 영역을 한 Thread 만 수행할 수 있도록 보장하기만 할 뿐
     * private 이 아니라면, 동기화 하더라도 외부에서 직접 접근하여 값을 변경하는 것을 막을 수 없다
     */
    private int balance = 1000;
    public int getBalance() { return balance; }
    public synchronized void withdraw(int money) {
        /**
         * synchronized 블럭을 사용하는 방법
         * public void withdraw(int money) {
         *         synchronized (this) { if절 }
         */
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
    }
}

@Slf4j
class Test35Runnable implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300 중 한 값을 임의로 선택하여 출금 (withdraw)
            int money   = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            log.debug("balance === " + acc.getBalance());
        }
    }
}