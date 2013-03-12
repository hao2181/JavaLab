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
import java.io.OutputStream;  
 
/**  
 * 乱码的产生  
 * */ 
public class CharSetDemo2{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.txt");  
        OutputStream out = new FileOutputStream(file);  
        byte[] bytes = "你好".getBytes("ISO8859-1");  //这里编码不一致产生输出乱码
        out.write(bytes);  
        out.close();  
    }  
} 