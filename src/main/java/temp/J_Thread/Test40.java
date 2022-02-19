package temp.J_Thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Control Thread
 * fork() & join()
 * 
 * 결과를 실행해보면,
 * 4core 보다 1core 의 실행이 더 빠르다
 * -> 작업을 나누고 다시 합치는데 걸리는 시간이 있기 때문이다
 * -> 테스트해보고 이득이 있을 때에만, multi-Thread 를 사용하도록 하자
 */
public class Test40 {
    static final ForkJoinPool pool  = new ForkJoinPool();   // Thread pool 생성

    public static void main(String[] args) {
        long from   = 1L;
        long to     = 100_000_000L;

        SumTask task    = new SumTask(from, to);

        long start      = System.currentTimeMillis();
        long result     = pool.invoke(task);    // invoke() 호출로 실행

        System.out.println("Elapsed time (4 core) === " + (System.currentTimeMillis() - start));

        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);

        result          = 0L;
        start           = System.currentTimeMillis();
        for(long i=from; i<=to; i++) {
            result += i;
        }

        System.out.println("Elapsed time (1 core) === " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
    }
}

class SumTask extends RecursiveTask<Long> {
    long from, to;

    SumTask(long from, long to) {
        this.from   = from;
        this.to     = to;
    }

    @Override
    protected Long compute() {
        long size   = to - from + 1;    // from <= i <= to

        if(size <= 5) return sum(); // 더할 숫자가 5개 미만일 때, return 숫자의 합

        long half   = (from + to)/2;

        // 범위를 반으로 나눠서 두 개의 작업 생성
        SumTask leftSum     = new SumTask(from,     half);
        SumTask rightSum    = new SumTask(half+1,   to);

        leftSum.fork();

        return rightSum.compute() + leftSum.join();
    }

    long sum() {
        long tmp    = 0L;

        for(long i=from; i<=to; i++) {
            tmp += i;
        }
        return tmp;
    }
}