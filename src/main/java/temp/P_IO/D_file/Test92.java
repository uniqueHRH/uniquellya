package temp.P_IO.D_file;

import java.io.File;

/**
 * File
 *
 * -> 지정된 디렉토리와 하위 디렉토리에 있는 파일 중
 *    지정된 확장자를 가진 파일을 delete() 를 호출해 삭제한다
 *    성공하면 true / 실패하면 false
 */
public class Test92 {
    static int deleteFiles  = 0;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Test92 Extension");
            System.exit(0);
        }

        String currDir  = System.getProperty("user.dir");

        File dir    = new File(currDir);
        String ext  = "." + args[0];

        delete(dir, ext);

        System.out.println(deleteFiles + " 개의 파일이 삭제되었습니다");
    }

    public static void delete(File dir, String ext) {
        File[] files    = dir.listFiles();
        for(int i=0; i<files.length; i++) {
            if(files[i].isDirectory()) {    // folder
                delete(files[i], ext);
            } else {                        // file
                String filename = files[i].getAbsolutePath();

                if(filename.endsWith(ext)) {
                    System.out.print(filename);
                    if(files[i].delete()) {
                        System.out.println(" - 삭제 성공");
                        deleteFiles++;
                    } else {
                        System.out.println(" - 삭제 실패");
                    }
                }
            }
        }
    }
}
