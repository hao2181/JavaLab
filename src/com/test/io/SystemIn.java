/**
 * 
 */
package com.test.io;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
 
/**  
 * System.in重定向  
 * */ 
public class SystemIn{  
    public static void main(String[] args){  
        File file = new File("d:" + File.separator + "hello.txt");  
        if(!file.exists()){  
            return;  
        }else{  
            try{  
                System.setIn(new FileInputStream(file));  
            }catch(FileNotFoundException e){  
                e.printStackTrace();  
            }  
            byte[] bytes = new byte[1024];  
            int len = 0;  
            try{  
                len = System.in.read(bytes);  
            }catch(IOException e){  
                e.printStackTrace();  
            }  
            System.out.println("读入的内容为：" + new String(bytes, 0, len));  
        }  
    }  
} 