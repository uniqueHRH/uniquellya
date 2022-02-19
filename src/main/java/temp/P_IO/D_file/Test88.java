package temp.P_IO.D_file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File
 *
 * -> 현재 디렉토리에 속한 파일 및 디렉토리의 이름과 크기 등 상세정보
 */
public class Test88 {
    public static void main(String[] args) {
        String  currDir = System.getProperty("user.dir");
        File    dir     = new File(currDir);
        File[]  files   = dir.listFiles();

        for(int i=0; i<files.length; i++) {
            File             file       = files[i];
            String           name       = file.getName();
            SimpleDateFormat df         = new SimpleDateFormat("yyyy-MM-dd HH:mma");
            String          attribute   = "";
            String          size        = "";

            if(files[i].isDirectory()) {
                attribute   = "DIR";
            } else {
                size    = file.length() + "";
                attribute    = file.canRead()   ? "R" : " ";
                attribute   += file.canWrite()  ? "W" : " ";
                attribute   += file.isHidden()  ? "H" : " ";
            }
            System.out.printf("%s %3s %6s %s\n", df.format((new Date(file.lastModified()))), attribute, size, name);
        }
    }
}
