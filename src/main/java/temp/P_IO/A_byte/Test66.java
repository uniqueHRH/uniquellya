package temp.P_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * I/O
 * [바이트기반 Stream ]
 * ByteArrayInputStream & ByteArrayOutputStream
 */
public class Test66 {
    public static void main(String[] args) {
        byte[] inSrc    = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc   = null;
        byte[] temp     = new byte[4];

        ByteArrayInputStream input   = null;
        ByteArrayOutputStream output  = null;

        input   = new ByteArrayInputStream(inSrc);
        output  = new ByteArrayOutputStream();

        System.out.println("Input Source === " + Arrays.toString(inSrc));

        /**
         * temp 배열의 크기 4만큼 읽어온다
         * -> 배열을 다시 쓰는것이 아니라, 이전 값이 들어있던 배열을 재사용한다
         * -> 이전 배열에 남아있던 [6, 7] 이 남아있어서 예상과 다른 값 출력
         * -> 아래와 같이 작성한다면, 정상적인 값을 돌려받을 수 있다
         * int length = input.read(temp);
         * output.write(temp, 0, length);   -> 읽어온 만큼만 write
         */
        try {
            while(input.available() > 0) {  // 읽어올 데이터 존재여부 체크
                input.read(temp);       // 읽어온 데이터가 temp에 저장된다
                output.write(temp);     // temp 데이터를 output 을 통해 출력된다

                outSrc  = output.toByteArray();
                printArrays(temp, outSrc);
            }
        } catch(IOException e) {}
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp === " + Arrays.toString(temp));
        System.out.println("Output Source === " + Arrays.toString(outSrc));
    }
}

