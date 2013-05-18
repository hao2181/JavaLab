/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 *
 */
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.zip.ZipEntry;  
import java.util.zip.ZipFile;  
 
/**  
 * ��ѹ���ļ���ѹ���ļ���ֻ��һ���ļ��������  
 * */ 
public class ZipFileDemo2{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.zip");  
        File outFile = new File("d:" + File.separator + "unZipFile.txt");  
        ZipFile zipFile = new ZipFile(file);  
        ZipEntry entry = zipFile.getEntry("hello.txt");  
        InputStream input = zipFile.getInputStream(entry);  
        OutputStream output = new FileOutputStream(outFile);  
        int temp = 0;
        while((temp = input.read()) != -1){  
            output.write(temp);  
        }  
        input.close();  
        output.close();  
    }  
} 