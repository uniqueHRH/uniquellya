package temp.J_Thread;

/**
 * Thread Group
 */
public class Test24 {
    public static void main(String[] args) {
        ThreadGroup main    = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1    = new ThreadGroup("Group1");
        ThreadGroup grp2    = new ThreadGroup("Group2");

        // ThreadGroup(ThreadGroup parent, String name);
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
        grp1.setMaxPriority(3); // grp1 그룹의 최대 우선순위를 3으로 지정

        Runnable runnable   = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // 정보 출력전 thread 가 종료되지 않도록, 1초 재우기
                } catch (InterruptedException e) {

                }
            }
        };

        // Thread(ThreadGroup tg, Runnable runnable, String name);
        new Thread(grp1,    runnable, "th1").start();
        new Thread(subGrp1, runnable, "th2").start();
        new Thread(grp2,    runnable, "th3").start();

        System.out.println("============================================"
                + "\nList of ThreadGroup : " + main.getName()
                + ",\nActive TheadGroup : " + main.activeGroupCount()
                + ",\nActive Thread : " + main.activeCount());

        main.list();
    }
}
