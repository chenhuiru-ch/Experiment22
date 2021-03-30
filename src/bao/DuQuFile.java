package bao;
import java.io.*;

/**
任务3-1
可正确读入实验数据文件的有效D{0-1}KP数据；
**/
public class  DuQuFile  {

   public static void main(String[] args) {         

      //读取txt文件
      File file = new File("H:\\软件工程\\实验二 任务3data_set\\idkp1-10.txt");
      //File file = new File("H:\\软件工程\\实验二 任务3data_set\\sdkp1-10.txt");
      //File file = new File("H:\\软件工程\\实验二 任务3data_set\\udkp1-10.txt");
      //File file = new File("H:\\软件工程\\实验二 任务3data_set\\wdkp1-10.txt");
      
      BufferedInputStream bis = null;
      FileInputStream  fis= null;
      try{
          //第一步 通过文件路径来创建文件实例
          fis = new FileInputStream(file);
          /*把FileInputStream实例 传递到 BufferedInputStream
                   目的是能快速读取文件
           */
          bis = new BufferedInputStream(fis);
          /*available检查是不是读到了文件末尾 */
          
          while( bis.available() > 0 ){                 
              System.out.print((char)bis.read());
          }
          
       }catch(FileNotFoundException fnfe)
        {
            System.out.println("文件不存在" + fnfe);
        }

        catch(IOException ioe)
        {
            System.out.println("I/O 错误: " + ioe); 
        }

        finally
        {
            try{
               if(bis != null && fis!=null)
               {
                     fis.close();
                  bis.close();
               }      
             }catch(IOException ioe)
              {
                  System.out.println("关闭InputStream句柄错误: " + ioe);
              }         
        }
   }    
}