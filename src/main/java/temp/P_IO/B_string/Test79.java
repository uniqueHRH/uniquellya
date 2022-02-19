package temp.P_IO.B_string;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

/**
 * I/O
 * [ 문자 기반 Stream ]
 *
 * FileReader       & FileWriter
 * [ pipedReader    & pipedWriter ]
 * -> Thread 간 데이터를 주고받을 때 사용
 * -> 다른 Stream 과 달리 입출력 Stream 을 하나의 Stream 으로 connect 해서 데이터를 공유
 * -> 한쪽 Thread 에서 connect() 를 호울하여 입출 STream 연결
 * -> 입출이 완료된 후, 어느 한쪽 Stream 만 닫아도 나머지는 자동으로 닫힌다
 * -> Thread 를 시작하기 전 PipedReader 와 PipedWriter 를 연결해야 함
 * StringReade      & StringWriter
 */
public class Test79 {
    public static void main(String[] args) {
        InputThread     inThread    = new InputThread("InputThread");
        OutputThread    outThread   = new OutputThread("OutputThread");

        // PipedReader 와 PipedWriter 를 연결한다
        inThread.connect(outThread.getOutput());

        inThread.start();
        outThread.start();
    }
}

class InputThread extends Thread {
    PipedReader     input   = new PipedReader();
    StringWriter    sw      = new StringWriter();

    InputThread(String name) {
        super(name);            // Thread(String name);
    }
    public void run() {
        try {
            int data    = 0;

            while((data = input.read()) != -1) {
                sw.write(data);
            }
            System.out.println(getName() + " received : " + sw.toString());
        } catch (IOException e) {}
    }
    public PipedReader getInput() {
        return input;
    }
    public void connect(PipedWriter output) {
        try {
            input.connect(output);
        } catch (IOException e) {}
    }
}

class OutputThread extends Thread {
    PipedWriter output  = new PipedWriter();

    OutputThread(String name) {
        super(name);            // Thread(String name);
    }
    public void run() {
        try {
            String msg  = "Hello";
            System.out.println(getName() + " send : " + msg);
            output.write(msg);
            output.close();
        } catch (IOException e) {}
    }
    public PipedWriter getOutput() {
        return output;
    }
    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {}
    }
}