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
import java.io.ObjectInputStream;  
 
/**  
 * ObjectInputStreamʾ��  
 * */ 
public class ObjectInputStreamDemo{  
    public static void main(String[] args) throws Exception{  
        File file = new File("d:" + File.separator + "hello.txt");  
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(  
                file));  
        Object obj = input.readObject();  
        input.close();  
        System.out.println(obj);  
    }  
} 