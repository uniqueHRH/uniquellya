package temp.P_IO.C_standard;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Stream
 * [ 표준입출력 ]
 *
 * RandomAccessFile
 * -> 하나의 클래스로 파일에 대한 입출이 모두 가능 (유일)
 * -> 기본 자료형 단위로 데이터 입출 가능
 * -> 파일의 어느 위치에나 읽기/쓰기가 가능하다
 *    -> 다른 입출 클래스들은 순차적인 입출만 제한적으로 가능
 *    -> 파일 포인터를 사용하기 때문
 *    -> 단 파일 포인터를 원하는 위치로 옮긴 다음 작업 필요
 */
public class Test85 {
    public static void main(String[] args) {
        /**
         * int 가 4byte 이기 때문에   -> 포인터 위치가 0 에서 4 로 이동
         * long 이 8 byte 이기 때문에 -> 포인터 위치가 4 에서 12 로 이동
         */
        try {
            RandomAccessFile raf    = new RandomAccessFile("Test85", "rw");
            System.out.println("파일 포인터 위치 === " +raf.getFilePointer());
            raf.writeInt(100);
            System.out.println("파일 포인터 위치 === " +raf.getFilePointer());
            raf.writeLong(100L);
            System.out.println("파일 포인터 위치 === " +raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("============================================");
////////////////////////////////////////////////////////////////////////////
        /**
         * bat 파일은 생성되지만, console에는 아무것도 출력되지 않는다
         * writeInt() 를 수행하면서 포인터의 위치가 파일의 마지막으로 이동한 후, readInt() 를 호출했기 때문
         * 이 때, seek(long pos) 를 이용해 파일 포인터의 위치를 처음으로 이동시킨 후 readInt() 를 호출한다
         */
//             번호, 국어, 영어, 수학
        int[] score = {
                1,  100,  90,  90,
                2,  100,  90,  80,
                3,  80,  100,  90,
                4,  70,   70, 100,
                5,  80,   90, 100,
        };

        try {
            RandomAccessFile raf = new RandomAccessFile("Test85.dat", "rw");

            for (int i = 0; i < score.length; i++) {
                raf.writeInt(score[i]);
            }
            raf.seek(0);
            while (true) {
                System.out.println(raf.readInt());
            }
        } catch (EOFException e) {
            // readInt() 를 호출했을 때, 더 읽을 것이 없을 때 EOFException 발생
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("============================================");
////////////////////////////////////////////////////////////////////////////
        /**
         * 기존 생성된 Test85.dat 파일의 국어과목 합계 예제
         * -> 한 학생의 데이터가 번호와 3과목의 점수로 모두 5개의 int 값으로 이루어짐 (4 x 4 = 16 byte)
         * 파일 포인터의 값을 16씩 증가시켜 readInt() 호출
         */
        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("Test85.dat", "r");
            int i = 4;

            while(true) {
                raf.seek(i);
                sum += raf.readInt();
                i += 16;
            }
        } catch (EOFException e) {
            System.out.println("sum === " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
