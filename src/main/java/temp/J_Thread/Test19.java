package temp.J_Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Threa
 * 싱글 쓰레드 수행 시간
 */
@Slf4j
public class Test19 {
    public static void main(String[] args) {
        long startTime  = System.currentTimeMillis();

        for(int i=0; i<300; i++) System.out.printf("%s", new String("="));
        log.debug("소요시간1 === "+(System.currentTimeMillis() - startTime));

        for(int i=0; i<300; i++) System.out.printf("%s", new String("|"));
        log.debug("소요시간2 === "+(System.currentTimeMillis() - startTime));
    }
}

// 소요시간1 === 63
// 소요시간1 === 170