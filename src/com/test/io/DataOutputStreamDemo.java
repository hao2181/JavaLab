/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 *
 */
import java.io.DataOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
 
public class DataOutputStreamDemo{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.txt");  
        char[] ch = { 'A', 'B', 'C' };  
        DataOutputStream out = null;  
        out = new DataOutputStream(new FileOutputStream(file));  
        for(char temp : ch){  
            out.writeChar(temp);  
        }  
        out.close();  
    }  
} 