package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * [ DataInputStream        & DataOutputStream 3 ]
 * SequenceInputStream
 * PrintStream
 */
@Slf4j
public class Test74 {
    public static void main(String[] args) {
        int sum     = 0;
        int score   = 0;

        /**
         * JDK1.7 부터 try - with - resources 문을 이용해 close() 를 직접 호출하지 않아도 자동 호출되도록 지원된다
         * 해당 코드로 Test74 코드에 적용했다
         * 훨씬 간결한다
         */
        try (FileInputStream fis    = new FileInputStream("Test72.dat");
             DataInputStream dis    = new DataInputStream(fis)) {

            while (true) {
                score = dis.readInt();
                log.debug("scroe === " + score);
                sum += score;
            }
        } catch (EOFException e) {
            log.debug("점수의 총합은 === " + sum + " 입니다");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
