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
 * ����Ĳ���  
 * */ 
public class CharSetDemo2{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.txt");  
        OutputStream out = new FileOutputStream(file);  
        byte[] bytes = "���".getBytes("ISO8859-1");  //������벻һ�²����������
        out.write(bytes);  
        out.close();  
    }  
} 