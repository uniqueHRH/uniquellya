package temp.P_IO.A_byte;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * [ DataInputStream        & DataOutputStream ]
 * SequenceInputStream
 * PrintStream
 */
public class Test69 {
    public static void main(String[] args) {
        /**
         * FileOutputStream 을 기반으로 하는 DataOutputStream 생성
         * 값들은 이진데이터(binary data)로 저장 -> text data 가 아니므로 데이터를 읽어보기는 힘듦
         * UltraEdit 같은 프로그램이나 ByteArrayOutputStream 을 사용하면 데이터를 확인할 수 있다
         */
        FileOutputStream fos    = null;
        DataOutputStream dos    = null;

        try {
            fos = new FileOutputStream("Test69.bat");
            dos = new DataOutputStream(fos);
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            dos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
