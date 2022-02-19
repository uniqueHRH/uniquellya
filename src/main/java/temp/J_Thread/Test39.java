package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Control Thread
 * Lock & Condition
 * Test38 에 Lock & Condition 을 추가했다
 *
 * Cust Thread 와 Cook Thread 에 대한 통지를 지정할 수 있게 변경되었다
 * Thread 의 종류에 따라 구분할 수 있지만, 특정 Thread 에 지정할 수는 없다
 * 음식별로 Condition 을 세분화하면, 통지를 받고도 원하는 음식이 없어서 다시 기다리는 일이 없도록 가능하다
 */
@Slf4j
public class Test39 {
    public static void main(String[] args) throws InterruptedException {
        Table4 table = new Table4();

        new Thread(new Cook4(table),    "COOK1").start();
        new Thread(new Customer4(table, "donut"), "CUST1").start();
        new Thread(new Customer4(table, "burger"), "CUST2").start();

        Thread.sleep(2000);
        System.exit(0);
    }
}

@Slf4j
class Table4 {
    String[] dishNames  = { "donut", "donut", "burger"};
    final int MAX_FOOD  = 6;
    private ArrayList<String> dishes    = new ArrayList<>();

    private ReentrantLock   lock    = new ReentrantLock();
    private Condition       forCook = lock.newCondition();
    private Condition       forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();

        try {
            if(dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");

                try {
                    forCook.await();    // wait(); cook Thread 를 대기시킨다
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            dishes.add(dish);
            forCust.signal();   // notify(); 대기중인 Cust 를 깨운다
            System.out.println("Dishes === " + dishes.toString());
        } finally {
            lock.unlock();
        }
    }

    public void remove(String dishNames) {
        lock.lock();    // synchronized (this) {}
        String name = Thread.currentThread().getName();
            
        try {
            while(dishes.size() == 0) {
                System.out.println(name + " is waiting");

                try {
                    forCust.await();    // wait(); Cust Thread 대기시킨다
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            while(true) {
                for(int i=0; i<dishes.size(); i++) {
                    if(dishNames.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal();   // notify(); 기다리는 Cook Thread 를 깨운다
                        return;
                    }
                }
                try {
                    System.out.println(name + "is waiting");
                    forCust.await();    // wait(); 원하는 음식이 없는 Cust Thread 를 대기시킨다
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }
        } finally {
            lock.unlock();
        }
    }
    public int dishNum() { return dishNames.length; }
}

@Slf4j
class Customer4 implements Runnable {
    private Table4  table;
    private String  food;

    Customer4(Table4 table, String food) {
        this.table  = table;
        this.food   = food;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

@Slf4j
class Cook4 implements Runnable {
    private Table4  table;

    Cook4(Table4 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            int idx = (int)(Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch(InterruptedException e) {}
        }
    }
}