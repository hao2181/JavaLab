/**
 * 
 */
package com.test.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
	/**  
	 * 使用RandomAccessFile写入文件  
	 * */ 
public class RandomAccess {
	    public static void main(String[] args) throws IOException {  
	        String fileName="D:"+File.separator+"hello.txt";  
	        File f=new File(fileName);  
	        RandomAccessFile demo = new RandomAccessFile(f,"rw");  
	        demo.writeBytes("asdsad");  
	        demo.writeInt(12);  
	        demo.writeBoolean(true);  
	        demo.writeChar('A');  
	        demo.writeFloat(1.21f);  
	        demo.writeDouble(12.123);  
	        demo.close();
	    }  
}

