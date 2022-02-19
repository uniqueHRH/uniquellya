package temp.P_IO;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class Test86 {
    public static void main(String[] args) throws IOException {
        File    f           = new File("D:\\program\\workspace\\uniquellya\\src\\main\\java\\temp\\P_IO\\Test86.java");
        String  fileName    = f.getName();
        int     pos         = fileName.lastIndexOf(".");

        log.debug("경로를 제외한 파일 이름 === " + f.getName());
        log.debug("확장자를 제외한 파일 이름 === " + fileName.substring(0, pos));
        log.debug("확장자 === " + fileName.substring(pos + 1) + "\n\n");

        log.debug("경로를 포함한 파일 이름 === " + f.getPath());
        log.debug("파일의 절대 경로 === " + f.getAbsolutePath());
        log.debug("파일의 정규 경로 === " + f.getCanonicalPath());
        log.debug("파일이 속해있는 디렉토리 === " + f.getParent() + "\n");
        log.debug("File.pathSeparator === " + File.pathSeparator);
        log.debug("File.pathSeparatorChar === " + File.pathSeparatorChar + "\n\n");

        log.debug("File.separator === " + File.separator);
        log.debug("File.separatorChar === " + File.separatorChar + "\n");
        log.debug("user.dir === " + System.getProperty("user.dir"));
        log.debug("sun.boot.class.path === " + System.getProperty("sun.boot.class.path"));
    }
}
