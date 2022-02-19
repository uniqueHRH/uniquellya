package temp.P_IO.A_byte;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * [ DataInputStream        & DataOutputStream 2 ]
 * SequenceInputStream
 * PrintStream
 */
public class Test70 {
    public static void main(String[] args) {
        ByteArrayOutputStream   bos = null;
        DataOutputStream        dos = null;

        byte[] result   = null;
        try {
            bos     = new ByteArrayOutputStream();
            dos     = new DataOutputStream(bos);    // dos 는 bos 기반의 보조스트림
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            result  = bos.toByteArray();

            String[] hex    = new String[result.length];

            for(int i=0; i<result.length; i++) {
                if(result[i] < 0) {
                    hex[i]  = String.format("%02x", result[i]+256);
                } else {
                    hex[i]  = String.format("%02x", result[i]);
                }
            }
            System.out.println("10진수 === " + Arrays.toString(result));
            System.out.println("16진수 === " + Arrays.toString(hex));

            dos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
