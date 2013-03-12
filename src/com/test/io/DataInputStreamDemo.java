/**
 * 
 */
package com.test.io;

import java.io.DataInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
 
public class DataInputStreamDemo{  //数据操作流
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.txt");  
        DataInputStream input = new DataInputStream(new FileInputStream(file));  
        char[] ch = new char[10];  
        int count = 0;  
        char temp;  
        while((temp = input.readChar()) != 'C'){  
            ch[count++] = temp;  
        }  
        System.out.println(ch);  
    }  
} 