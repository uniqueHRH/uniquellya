package temp.J_Thread;

import java.util.ArrayList;

/**
 * Control Thread
 * wait() & notify()
 * Test36 에 synchronized 를 추가했다
 *
 * 원하는 음식이 테이블에 없를 때, failed to eat 출력
 * 테이블에 음식이 하나도 없으면, 0.5초마다 음식이 추가되었는지 확인하면서 waiting
 *
 * => 손님 Thread 가 lock 을 쥐고 기다리기 때문에,
 * Cook2 Thread 는 음식을 추가하지 못한다
 * 이럴 때, wait() & notify() 사용
 * => Test38 에서 wait() & notify() 적용 예제 확인
 */
public class Test37 {
    public static void main(String[] args) throws InterruptedException {
        Table2 table = new Table2();

        new Thread(new Cook2(table),    "COOK1").start();
        new Thread(new Customer2(table, "donut"), "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}

class Table2 {
    String[] dishNames  = { "donut", "donut", "burger"};
    final int MAX_FOOD  = 6;
    private ArrayList<String> dishes    = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.println("Dishes === " + dishes.toString());
    }

    public boolean remove(String dishNames) {
        synchronized (this) {
            while(dishes.size() == 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            for(int i=0; i<dishes.size(); i++) {
                if(dishNames.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    public int dishNum() { return dishNames.length; }
}

class Customer2 implements Runnable {
    private Table2  table;
    private String  food;

    Customer2(Table2 table, String food) {
        this.table  = table;
        this.food   = food;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if(eatFood()) System.out.println(name + " ate a " + food);
            else System.out.println(name + " failed to eat...");
        }
    }
    boolean eatFood() { return table.remove(food); }
}

class Cook2 implements Runnable {
    private Table2  table;

    Cook2(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            int idx = (int)(Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {}
        }
    }
}