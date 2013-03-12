/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 *
 */
import java.io.File;  
import java.io.IOException;  
import java.util.zip.ZipFile;  
 
/**  
 * ZipFile演示  
 * */ 
public class ZipFileDemo{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.zip");  
        ZipFile zipFile = new ZipFile(file);  
        System.out.println("压缩文件的名称为：" + zipFile.getName());  
    }  
} 