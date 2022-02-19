package temp.P_IO.D_file;

import java.io.*;

/**
 * File
 *
 * -> 지정 디렉토리 와 서브디렉토리에 포함된,
 *    확장자가 'java or txt or bak' 인 모든 파일의 내용을 읽어,
 *    지정한 키워드가 포함된 라인 출력
 */
public class Test90 {
   static int found = 0;

   public static void main(String[] args) {
       if(args.length != 2) {
           System.out.println("USAGE : java Test90 DIRECTORY KEYWORD");
           System.exit(0);
       }
       File     dir     = new File(args[0]);
       String   keyword = args[1];

       if(!dir.exists() || !dir.isDirectory()) {
           System.out.println("유효하지 않은 디렉토리입니다");
           System.exit(0);
       }
       try {
           findInFiles(dir, keyword);
       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println();
       System.out.println("총 " + found + " 개의 라인에서 '" + keyword + "'을/를 발견하였습니다");
   }

   public static void findInFiles(File dir, String keyword) throws IOException {
       File[] files = dir.listFiles();

       for(int i=0; i<files.length; i++) {
           if(files[i].isDirectory()) {
               findInFiles(files[i], keyword);
           } else {
               String filename  = files[i].getName();
               String extension = filename.substring(filename.lastIndexOf(".")+1);  // extension : 확장자
                      extension = "," + extension + ",";

              if(",java,txt,bak', ".indexOf(extension) == -1) continue; // extension 의 앞이나 뒤에만 구분자를 붙이면, 확장자가 'ava'와 같이 부분적으로 일치하는 경우 문제가 발생할 수 있다

              filename  = dir.getAbsolutePath() + File.separator + filename;
               FileReader       fr  = new FileReader(files[i]);
               BufferedReader   br  = new BufferedReader(fr);

               String data  = "";
               int lineNum  = 0;

               while((data = br.readLine()) != null) {
                   lineNum++;

                   if(data.indexOf(keyword) != -1) {
                       found++;
                       System.out.println("[ " + filename + "(" + lineNum + ")" + " ]" + data);
                   }
               }
               br.close();
           }
       }
   }
}
