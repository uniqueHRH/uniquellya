package temp.P_IO.D_file;

import java.io.File;
import java.io.IOException;

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
public class Test86 {
    public static void main(String[] args) throws IOException {
        File    f           = new File("D:\\program\\workspace\\uniquellya\\src\\main\\java\\temp\\P_IO\\Test86.java");
        String  fileName    = f.getName();
        int     pos         = fileName.lastIndexOf(".");

        System.out.println("경로를 제외한 파일 이름 === " + f.getName());
        System.out.println("확장자를 제외한 파일 이름 === " + fileName.substring(0, pos));
        System.out.println("확장자 === " + fileName.substring(pos + 1) + "\n\n");

        System.out.println("경로를 포함한 파일 이름 === " + f.getPath());
        System.out.println("파일의 절대 경로 === " + f.getAbsolutePath());
        System.out.println("파일의 정규 경로 === " + f.getCanonicalPath());
        System.out.println("파일이 속해있는 디렉토리 === " + f.getParent() + "\n");
        System.out.println("File.pathSeparator === " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar === " + File.pathSeparatorChar + "\n\n");

        System.out.println("File.separator === " + File.separator);
        System.out.println("File.separatorChar === " + File.separatorChar + "\n");
        System.out.println("user.dir === " + System.getProperty("user.dir"));
        System.out.println("sun.boot.class.path === " + System.getProperty("sun.boot.class.path"));
    }
}
