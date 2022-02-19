package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * File
 * [ Basic ]
 *
 * -> 이미 존재하는 파일 참조
 *    -> File f = new File("root", "fileName");
 * -> 파일을 새로 생성할 때
 *    -> File f = new File("root", "fileName");
 *    -> f.createNewFile()  => 새로운 파일 생성
 */
@Slf4j
public class Test87 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Test887 Directory");
            System.exit(0); // 시스템 정상 종료 (main 이 종료될 때, 내부적으로 System.exit(0) 호출
        }

        File    file    = new File(args[0]);

        if(!file.exists() || !file.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다");
            System.exit(0);
        }
        File[]  files   = file.listFiles();


    }
}
