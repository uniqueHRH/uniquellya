package temp.P_IO.D_file;

import java.io.*;

/**
 * File
 *
 * -> Test94 에서 나눈 파일을 다시 합친다
 *    프로그램 실행 두중 임의 중단되는 경우, 파일이 합쳐지는 과정에서 불완전한 파일이 생성되는 것을 막기 위해 임시 파일 사용
 *    파일을 합치는 작업이 끝나면,
 *    기존 파일을 삭제하고 임시파일의 이름을 기존 파일의 이름으로 변경한다
 */
public class Test95 {
    public static void main(String[] args) {
        System.out.println("temp dir === " + System.getProperty("java.io.tmpdir"));

        if(args.length != 1) {
            System.out.println("USAGE : java Test95 FileMerge filename");
            System.exit(0);
        }

        String mergeFilename    = args[0];

        try {
            File tempFile   = File.createTempFile("~mergetemp", ".tmp");
            tempFile.deleteOnExit();

            FileOutputStream        fos = new FileOutputStream(tempFile);
            BufferedOutputStream    bos = new BufferedOutputStream(fos);

            BufferedInputStream     bis = null;

            int number  = 1;

            File    f   = new File(mergeFilename + "_." + number);

            while(f.exists()) {
                f.setReadOnly();    // 작업 중 파일의 내용이 변경되지 않도록
                bis = new BufferedInputStream(new FileInputStream(f));

                int data    = 0;
                while((data = bis.read()) != -1) {
                    bos.write(data);
                }
                bis.close();

                f   = new File(mergeFilename + "_." + ++number);
            }

            bos.close();

            File oldFile    = new File(mergeFilename);
            if(oldFile.exists())    oldFile.delete();
            tempFile.renameTo(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
