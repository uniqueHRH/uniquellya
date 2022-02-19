package temp.J_Thread;

import java.util.ArrayList;

/**
 * Control Thread
 * wait() & notify()
 * Test37 에 wait() & notify() 를 추가했다
 *
 * Table 객체의 waiting pool 에 Cook Thread 와 Cust Thread 가 함께 기다리고 있다
 * notify() 는 waiting pool 에서 임의의 Thread 에게 통지할 뿐, Cook Thread 를 선택하여 통지할 수 없다
 * 만약, Cust Thread 가 통지를 받으면 lock 을 얻더라도 여전히 원하는 음식이 없으므로 다시 waiting pool 로 돌아간다
 *
 * => Test39 에서 Lock & condition 적용 예제 확인
 */
public class Test38 {
    public static void main(String[] args) throws InterruptedException {
        Table3 table = new Table3();

        new Thread(new Cook3(table),    "COOK1").start();
        new Thread(new Customer3(table, "donut"), "CUST1").start();
        new Thread(new Customer3(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}

class Table3 {
    String[] dishNames  = { "donut", "donut", "burger"};
    final int MAX_FOOD  = 6;
    private ArrayList<String> dishes    = new ArrayList<>();

    public synchronized void add(String dish) {
        if(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting");

            try {
                wait(); // Cook Thread 를 대기시킨다
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify();   // 기다리는 Cust Thread 를 깨운다
        System.out.println("Dishes === " + dishes.toString());
    }

    public void remove(String dishNames) {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            
            while(dishes.size() == 0) {
                System.out.println(name + " is waiting");
                
                try {
                    wait(); // Cust Thread 를 대기시킨다
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            while(true) {
                for(int i=0; i<dishes.size(); i++) {
                    if(dishNames.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();   // 기다리는 Cook Thread 를 깨운다
                        return;
                    }
                }
                try {
                    System.out.println(name + "is waiting");
                    wait(); // 원하는 음식이 없는 Cust Thread 를 대기시킨다
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }
        }
    }
    public int dishNum() { return dishNames.length; }
}

class Customer3 implements Runnable {
    private Table3  table;
    private String  food;

    Customer3(Table3 table, String food) {
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

class Cook3 implements Runnable {
    private Table3  table;

    Cook3(Table3 table) {
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