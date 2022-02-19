package temp.P_IO.D_file;

import java.io.File;
import java.util.ArrayList;

/**
 * File
 * 
 * 전체 디렉토리와 포함된 파일 및 하위 디렉토리 목록까지 보여준다
 *  재귀호출 사용 -> Test5
 */
public class Test87 {
    static int totalFiles   = 0;
    static int totalDirs    = 0;
    
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Test87 Directory");
            System.exit(0); // 시스템 정상 종료 (main 이 종료될 때, 내부적으로 System.exit(0) 호출
        }

        File dir = new File(args[0]);

        if(!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다");
            System.exit(0);
        }

        printFileList(dir);

        System.out.println();
        System.out.println("총 " + totalFiles + "개의 파일");
        System.out.println("총 " + totalDirs + "개의 디렉토리");
    }

    public static void printFileList(File dir) {
        System. out.println(dir.getAbsolutePath() + " 디렉토리");

        File[]      files   = dir.listFiles();
        ArrayList   subDir  = new ArrayList();

        for(int i=0; i<files.length; i++) {
            String fileName = files[i].getName();

            if(files[i].isDirectory()) {
                fileName = "[ " + fileName + " ]";
                subDir.add(i + "");
            }
            System.out.println(fileName);
        }

        int dirNum  = subDir.size();
        int fileNum = files.length - dirNum;

        totalFiles  += fileNum;
        totalDirs   += dirNum;

        System.out.println(fileNum + " 개의 파일, " + dirNum + " 개의 디렉토리\n");

        for(int i=0; i<subDir.size(); i++) {
            int index   = Integer.parseInt((String) subDir.get(i));
            printFileList(files[index]);
        }
    }
}
