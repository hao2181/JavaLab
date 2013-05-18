/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 *
 */
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipOutputStream;  
 
/**  
 * һ����ѹ������ļ�  
 * */ 
public class ZipOutputStreamDemo1{  
    public static void main(String[] args) throws IOException{  
        // Ҫ��ѹ�����ļ���  
        File file = new File("d:" + File.separator + "temp");  
        File zipFile = new File("d:" + File.separator + "zipFile.zip");  
        InputStream input = null;  
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(  
                zipFile));  
        zipOut.setComment("hello");  
        if(file.isDirectory()){  
            File[] files = file.listFiles();  
            for(int i = 0; i < files.length; ++i){  
                input = new FileInputStream(files[i]);  
                zipOut.putNextEntry(new ZipEntry(file.getName()  
                        + File.separator + files[i].getName()));  
                int temp = 0;  
                while((temp = input.read()) != -1){  
                    zipOut.write(temp);  
                }  
                input.close();  
            }  
        }  
        zipOut.close();  
    }  
} 