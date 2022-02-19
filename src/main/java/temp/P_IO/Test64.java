package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * I/O
 * [바이트기반 Stream ]
 * ByteArrayInputStream & ByteArrayOutputStream
 * 
 * byte 배열은 메모리 자원만 사용하므로 close() 를 이용해 Stream 을 닫지 않아도, 가비지컬렉터가 자원 자동 반환
 */
@Slf4j
public class Test64 {
    public static void main(String[] args) {
        byte[] inSrc    = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc   = null;

        ByteArrayInputStream    input   = null;
        ByteArrayOutputStream   output  = null;

        input       = new ByteArrayInputStream(inSrc);
        output      = new ByteArrayOutputStream();

        /**
         * data = input.read() 먼저 수행    : tread()를 호출한 값을 data 에 저장
         * 다음 data != -1 수행             : data 값이 -1이 아닌지 비교
         * = 읽어들여올 값이 있을 때
         */
        int data    = 0;
        while((data = input.read()) != -1) {
            output.write(data);             // void write(int b)
        }
        outSrc      = output.toByteArray(); // Stream 을 byte[] 로 반환

        log.debug("Input Source === " + Arrays.toString(inSrc));
        log.debug("Output Source === " + Arrays.toString(outSrc));
    }
}
