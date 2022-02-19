package temp.P_IO.D_file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * File
 *
 * -> FilenameFilter 를 구현
 * -> String[] list(FilenameFilter filter) 와 함께 사용해 특정 조건에 맞는 파일 목록을 획득
 */
public class Test91 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Test91 pattern");
            System.exit(0);
        }
        String  currDir         = System.getProperty("user.dir");

        File    dir             = new File(currDir);
        final String pattern    = args[0];

        // String[] list (FilenameFilter filter)
        String[] files  = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.indexOf(pattern) != -1;
            }
        });
        
        for(int i=0; i<files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
