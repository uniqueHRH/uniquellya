package temp.P_IO.A_byte;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * DataInputStream          & DataOutputStream
 * [ SequenceInputStream ]
 * -> 큰 파일을 여러개의 작은 파일로 나누었다가 하나의 파일로 합치는 것과 같은 작업의 수행에 용이
 * PrintStream
 */
public class Test75 {
    /**
     * Vector -> 순서가 있는 데이터의 집합체
     * 순차적으로 값이 저장된다
     * @param args
     */
    public static void main(String[] args) {
       byte[] arr1      = {0, 1, 2};
       byte[] arr2      = {3, 4, 5};
       byte[] arr3      = {6, 7, 8};
       byte[] outSrc    = null;

        Vector vector   = new Vector();
        vector.add(new ByteArrayInputStream(arr1));
        vector.add(new ByteArrayInputStream(arr2));
        vector.add(new ByteArrayInputStream(arr3));

        SequenceInputStream     input   = new SequenceInputStream(vector.elements());
        ByteArrayOutputStream   output  = new ByteArrayOutputStream();

        int data        = 0;

        try {
            while((data = input.read()) != -1) {    // 더이상 읽어온 데이터가 없을 때까지
                output.write(data); // void write(int b)
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        outSrc  = output.toByteArray();

        System.out.println("input Source1 === " + Arrays.toString(arr1));
        System.out.println("input Source2 === " + Arrays.toString(arr2));
        System.out.println("input Source3 === " + Arrays.toString(arr3));
        System.out.println("output Source === " + Arrays.toString(outSrc));
    }
}
