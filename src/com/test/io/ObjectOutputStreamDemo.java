/**
 * 
 */
package com.test.io;

/**
 * @author zhanghao
 *
 */
import java.io.Serializable;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectOutputStream;  
 
/**  
 * ʵ�־������л���������  
 * */ 

/**  
 * ʾ��ObjectOutputStream  
 * */ 
public class ObjectOutputStreamDemo{  
    public static void main(String[] args) throws IOException{  
        File file = new File("d:" + File.separator + "hello.txt");  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                file));  
        oos.writeObject(new Person("rollen", 20)); 
        oos.close();  
    }  
} 