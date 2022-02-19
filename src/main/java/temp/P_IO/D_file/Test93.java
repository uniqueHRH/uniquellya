package temp.P_IO.D_file;

import java.io.File;

/**
 * File
 *
 * -> 파일 이름 변경
 *    파일 이름이 숫자일 궁여, 앞에 '0000' 을 붙인 후, substring() 으로 이름의 길이를 맞춘다
 */
public class Test93 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Test93 DIRECTORY");
            System.exit(0);
        }

        File dir    = new File(args[0]);

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다");
            System.exit(0);
        }
        File[] list = dir.listFiles();

        for(int i=0; i<list.length; i++) {
            String fileName = list[i].getName();
            // 파일명
            String newFileName = "0000" + fileName;
            newFileName = newFileName.substring(newFileName.length() -7);
            list[i].renameTo(new File(dir, newFileName));
        }
    }
}
