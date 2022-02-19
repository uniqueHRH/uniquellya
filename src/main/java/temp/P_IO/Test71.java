package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * BufferedInputStream      & BufferedOutputStream
 * [ DataInputStream        & DataOutputStream 3 ]
 * -> 문자로 데이터를 저장하면 다시 데이터를 읽어올 때, 문자를 실제 값으로 변환하는 과정을 거쳐야 하고 또 읽어야하는 데이터의 갯수를 결정해야한다
 * -> 이처럼 DataInputStream & DataOutputStream 을 사용하면, 데이터를 변환할 필요도 자릿수를 세어 따지지 않아도 되므로 데이터를 편리하고 빠르게 저장&읽기가 가능하다
 * SequenceInputStream
 * PrintStream
 */
@Slf4j
public class Test71 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Test69.bat");
            DataInputStream dis = new DataInputStream(fis);

            log.debug("dis.readInt ======= " + dis.readInt());
            log.debug("dis.readFloat ===== " + dis.readFloat());
            log.debug("dis.readBoolean === " + dis.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
