package temp.J_Thread;

import java.util.ArrayList;

/**
 * Control Thread
 * wait() & notify()
 * 실제 테스트하면서 에러가 발생하지는 않았지만,
 * 예외가 발생하는 경우도 있다
 * 1. Cook Thread가 음식을 놓는 도중에 Customer Thread 가 음식을 가져가려는 경우 -> ConcurrentModificationException
 * 2. Cust1 Thrad가 마지막 남은 음식을 가져가는 도중, Cust2 Thread가 먼저 음식을 가져가버려서
 *    존재하지도 않은 음식을 삭제하려는 경우 -> IndexOutOfBoundsException
 * => 여러 Thread 가 테이블을 공유하는데도 동기화를 하지 않았기 때문
 * => Test37 에서 동기화 적용 예제 확인
 */
public class Test36 {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(100);  // 0.1초 후 강제 종료
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table   table;
    private String  food;

    Customer(Table table, String food) {
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

class Cook implements Runnable {
    private Table   table;

    Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true) {
            // 임의의 요리를 선택해서 table 에 추가
            int idx = (int)(Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
        }
    }
}

class Table {
    String[] dishNames  = {"donut", "donut", "burger"}; // donut 이 더 자주 나온다
    final int MAX_FOOD  = 6;                            // 최대 음식의 갯수는 6

    private ArrayList<String> dishes    = new ArrayList<>();

    public void add(String dish) {
        // 테이블에 음식이 가득차면, 더 음식을 추가하지 않는다
        if(dishes.size() >= MAX_FOOD) return;
        dishes.add(dish);
        System.out.println("Dished === " + dishes.toString());
    }

    public boolean remove(String dishName) {
        for(int i=0; i<dishes.size(); i++) {
            if(dishName.equals((dishes.get(i)))) {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }
    public int dishNum() { return dishNames.length; }
}