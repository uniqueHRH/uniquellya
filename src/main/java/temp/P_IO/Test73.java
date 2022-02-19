package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

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
public class Test73 {
    public static void main(String[] args) {
        int sum     = 0;
        int score   = 0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        /**
         * DataInputStream 의 readInt() 와 같이 데이터를 읽는 메소드는 더이상 읽을 데이터가 없으면 EOFException 발생
         * -> 다른 inputStream 과 달리 무한 반복문과 EOFException 을 처리하는 catch 문을 이용해 데이터를 읽음
         * -> while 작업 후 Stream 을 닫아야 하나, while 이 무한반복문이기 때문에 finally 블럭에서 Stream 을 닫았다
         * -> dis 가 null일 때 close() 를 호출ㅊ하면 NPE 가 발생하므로, if 로 null 체크 후 close() 호출
         * -> close() 는 IOException 이 발생할 수 있으므로, try ~ catch 사용
         * 작업 도중 오류로 Stream 을 닫지 못하고 try 를 벗엉날 수 있으므로, finally 블럭을 이용해 Stream 을 닫아준다 => finally 는 무조건 들린다
          */
        try {
            fis = new FileInputStream("Test72.dat");
            dis = new DataInputStream(fis);

            while(true) {
                score   = dis.readInt();
                log.debug("score === " + score);
                sum += score;
            }
        } catch (EOFException e) {
            log.debug("점수의 총합은 === " + sum + " 입니다");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
