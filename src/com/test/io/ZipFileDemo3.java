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
import java.io.OutputStream;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipFile;  
import java.util.zip.ZipInputStream;  
 
/**  
 * 解压缩一个压缩文件中包含多个文件的情况  
 * */ 
public class ZipFileDemo3{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "zipFile.zip");  
        File outFile = null;  
        ZipFile zipFile = new ZipFile(file);  
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));  
        ZipEntry entry = null;  
        InputStream input = null;  
        OutputStream output = null;  
        while((entry = zipInput.getNextEntry()) != null){  
            System.out.println("解压缩" + entry.getName() + "文件");  
            outFile = new File("d:" + File.separator + entry.getName());  
            if(!outFile.getParentFile().exists()){  
                outFile.getParentFile().mkdir();  
            }  
            if(!outFile.exists()){  
                outFile.createNewFile();  
            }  
            input = zipFile.getInputStream(entry);  
            output = new FileOutputStream(outFile);  
            int temp = 0;  
            while((temp = input.read()) != -1){  
                output.write(temp);  
            }  
            input.close();  
            output.close();  
        }  
    }  
} 