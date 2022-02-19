package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * I/O
 * [바이트기반 Stream ]
 * yteArrayInputStream & ByteArrayOutputStream
 * 
 * Test64 와 다르게 byte 배열을 이용해 한 번에 배열의 크기만큼 읽고 쓰도록 했다
 * temp.length 가 10이기 때문에 10 byte 를 읽어왔고,
 * temp[5] 부터 5byte 만 읽어오도록 출력했다
 * 배열을 이용한 입출ㄹ은 작업의 효율 증가 -> 대상에 따라 알맞은 크기의 배열을 사용한다
 */
@Slf4j
public class Test65 {
    public static void main(String[] args) {
        byte[] inSrc    = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc   = null;
        byte[] temp     = new byte[10];

        ByteArrayInputStream input   = null;
        ByteArrayOutputStream output  = null;

        input   = new ByteArrayInputStream(inSrc);
        output  = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);   // 읽어온 데이터를 0부터 temp 에 담는다
        output.write(temp, 5, 5);       // temp[5] 부터 5개의 데이터를 write 한다

        outSrc  = output.toByteArray();

        log.debug("Input Source === " + Arrays.toString(inSrc));
        log.debug("temp === " + Arrays.toString(temp));
        log.debug("Output Source === " + Arrays.toString(outSrc));
    }
}
