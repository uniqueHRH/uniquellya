package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * I/O
 * [ 바이트 기반의 보조스트림 ]
 * FilterInputStream        & FilterOutputStream
 * [ BufferedInputStream    & BufferedOutputStream ]
 * -> 입출력의 효율을 높이기 위해 buffer 를 사용하는 Stream
 * -> 한 바이트씩 입출하기 보다는 buffer(바이트배열)를 이용해 한 번에 여러 바이트를 입출하는 것이 효율적이므로 대부분의 입출력에 사용
 * -> read 메소드를 호출하면, BufferedInputStream 은 입력소스로 부터 buffer 크기만큼의 데이터를 읽어와 자신의 내부 buffer 에 저장
 * -> 외부의 입력소스로부터 읽는 것보다, 내부 buffer 로부터 읽는 것이 훨씬 빠르기 때문에 작업 효율이 높다
 * -> buffer 가 가득 찰 때만 출력하기 때문에, 마지막 출력부분이 쓰이지 못하고 BufferedOutputStream buffer 에 남은 채로 종료될 수 있다
 * -> 모든 출력작업을 마친 후 close() 나 flush() 를 호출하여 남은 내용이 출력되도록 한다
 * -> BufferedOutputStream 의 close() 는 기반 Stream 인 FileOutputStream 의 close() 를 호출하기 때문에 FileOutputStream 의 close() 는 따로 호출하지 않아도 된다
 * DataInputStream          & DataOutputStream
 * SequenceInputStream
 * PrintStream
 */
@Slf4j
public class Test68 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos        = new FileOutputStream("Test68.txt");
            // BufferedOutputStream 의 버퍼 크기를 5로 한다
            BufferedOutputStream bos    = new BufferedOutputStream(fos, 5);
            // ,파일 123.txt 에 1 부터 9까지 출력한다
            for(int i='1'; i<= '9'; i++) {
                bos.write(i);
            }
//          fos.close();    // 12345 만 출력된다 . 남은 6789 는 buffer 가 채워지지 않아서 출력이 안됨
            bos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
