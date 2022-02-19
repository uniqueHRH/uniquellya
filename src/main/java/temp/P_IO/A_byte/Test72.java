package temp.P_IO.A_byte;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * [ DataInputStream        & DataOutputStream 4 ]
 * SequenceInputStream
 * PrintStream
 */
public class Test72 {
    public static void main(String[] args) {
        int[] score = {100, 90, 95, 85, 50};

        try {
            FileOutputStream    fos = new FileOutputStream("Test72.dat");
            DataOutputStream    dos = new DataOutputStream(fos);

            for(int i=0; i<score.length; i++) {
                dos.writeInt(score[i]);
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
