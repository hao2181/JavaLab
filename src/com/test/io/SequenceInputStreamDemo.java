/**
 * 
 */
package com.test.io;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.SequenceInputStream;  
 
/**  
 * �������ı��ļ��ϲ�Ϊ����һ���ı��ļ�  
 * */ 
public class SequenceInputStreamDemo{  
    public static void main(String[] args) throws IOException{  
        File file1 = new File("d:" + File.separator + "test.java");  
        File file2 = new File("d:" + File.separator + "hello.txt");  
        File file3 = new File("d:" + File.separator + "demo.txt");  
        InputStream input1 = new FileInputStream(file1);  
        InputStream input2 = new FileInputStream(file2);  
        OutputStream output = new FileOutputStream(file3);  
        // �ϲ���  
        SequenceInputStream sis = new SequenceInputStream(input1, input2);  
        int temp = 0;  
        while((temp = sis.read()) != -1){  
            output.write(temp);  
        }  
        input1.close();  
        input2.close();  
        output.close();  
        sis.close();  
    }  
} 